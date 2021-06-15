package ACM.每日一题leecode.day01;

/*
给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积

10100
10111
11111
10010
 */
public class day26_85最大矩形_可stack优化 {

    public static void printNums(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"--");
        }
        System.out.println();
    }
    public static void printDoubleNums(int[][] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]+"--");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {

       /* for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+"=");
            }
            System.out.println();
        }*/

        System.out.println(maximalRectangle2(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
        System.out.println(maximalRectangle2(new char[][]{
                {'0','1'},
                {'1','0'},
        }));
        System.out.println(maximalRectangle2(new char[][]{
        }));
    }

    public static int maximalRectangle(char[][] matrix) {
        /***
         方法一:暴力解法
         思路:1.两重for循环找1
         2.找到1之后再两重for循环从1这个i j开始向下找
         找每的1进行
         一个横向找 碰到0就beak
         一个纵向找 碰到0就break
         一个 如果上下i j+1  i+1 j   i+1 j+1 都是1  那就递归i
         */

        /***
         方法2:暴力解法:对每一行都求出每个元素的对应高度,就是连续1的长度
         每一行更新一次最大矩形面积,这个问题就和84题的柱状图的最大矩阵是一样的
         */
        int[] heigths = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int maxLen = 0;
            int len = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                //System.out.println(matrix[i][j]);
                //System.out.println(String.valueOf(matrix[i][j]).equals("1"));
                if (String.valueOf(matrix[i][j]).equals("1")){
                    len++;
                }else {
                    maxLen=Math.max(maxLen,len);
                    len=0;
                }

            }
            maxLen=Math.max(maxLen,len);
            //System.out.println("这是maxlen"+maxLen);
            heigths[i]=maxLen;
        }
        //printNums(heigths);


        //形成一个heigths的柱状图 对每一个柱子进行左右扫描,找出最大面积
        int maxArea = 0;
        for (int i = 0; i < heigths.length; i++) {
            int tempArea=heigths[i];
            for (int j = i-1; j >=0; j--) {//向左扫描
                if (heigths[j]<heigths[i]){
                    break;
                }
                tempArea += heigths[i];
            }

            for (int j = i+1; j < heigths.length; j++) {
                if (heigths[j]<heigths[i]){
                    break;
                }
                tempArea += heigths[i];
            }

            maxArea = Math.max(maxArea,tempArea);
        }
        return maxArea;
    }
    public static int maximalRectangle2(char[][] matrix) {
        /***
         不另外创建数组，就在原来的二维数组中,把每一行的当前最大长度赋值给自己
         0 1 1 1 0 0
         0 0 1 1 1 0

         0 1 2 3 0 0
         0 0 1 2 3 0

         */
        if (matrix.length==0){
            return 0;
        }
        int[] heigths = new int[matrix.length];
        int[][] newmatrix =new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int maxLen = 0;
            int len = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                //System.out.println(matrix[i][j]);
                //System.out.println(String.valueOf(matrix[i][j]).equals("1"));
                if (String.valueOf(matrix[i][j]).equals("1")){
                    len++;
                    newmatrix[i][j]= len;
                }else {
                    maxLen=Math.max(maxLen,len);
                    len=0;
                }

            }
            maxLen=Math.max(maxLen,len);
            //System.out.println("这是maxlen"+maxLen);
            heigths[i]=maxLen;
        }
        //printNums(heigths);
        //printDoubleNums(newmatrix);


        //形成一个heigths的柱状图 对每一个柱子进行左右扫描,找出最大面积


        int maxArea = 0;
        for (int k = 0; k < matrix[0].length;k++) {

            for (int i = 0; i < matrix.length; i++) {
                heigths[i] =newmatrix[i][k];
            }
            //System.out.println("这是当前的height:");
           // printNums(heigths);

            for (int i = 0; i < heigths.length; i++) {
                int tempArea=heigths[i];
                for (int j = i-1; j >=0; j--) {//向左扫描
                    if (heigths[j]<heigths[i]){
                        break;
                    }
                    tempArea += heigths[i];
                }

                for (int j = i+1; j < heigths.length; j++) {
                    if (heigths[j]<heigths[i]){
                        break;
                    }
                    tempArea += heigths[i];
                }

                maxArea = Math.max(maxArea,tempArea);
            }

        }
        return maxArea;
    }
}
