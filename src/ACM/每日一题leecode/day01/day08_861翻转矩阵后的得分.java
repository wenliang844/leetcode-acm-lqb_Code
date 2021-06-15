package ACM.每日一题leecode.day01;
/*
有一个二维矩阵 A 其中每个元素的值为 0 或 1 。

移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。

返回尽可能高的分数。

 

示例：

输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 思路: 每列的1和0都是单独的数,有固定的大小;保证前面的数字比后面的大即可--->贪心 局部最优
 * 1.保证第一列每个都是1
 * 2.保证此后每列1的个数大于0
 */
public class day08_861翻转矩阵后的得分 {

    public static void main(String[] args) {
        int[][] A= {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore(A));
    }

    public static int matrixScore(int[][] A) {

        int len = A[0].length;
        //System.out.println(len);

        //System.out.println(A.length);
        for (int i = 0; i < A.length; i++) { //第一列都置一
            if (A[i][0]==0){
                A[i][0]=1;
                for (int j = 1;j<A[i].length;j++){
                    if (A[i][j]==0){
                        A[i][j]=1;
                    }else{
                        A[i][j]=0;
                    }
                }
            }

        }

        int count;
        for (int j = 1; j < len; j++) {//记录1的数量
            count = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j]==0){
                    count++;
                }
            }

            //System.out.println(count+"---"+A.length/2);
            if (count>A.length/2){
                for (int i = 0; i < A.length; i++) {
                    if (A[i][j]==0){
                        A[i][j]=1;
                    }else{
                        A[i][j]=0;
                    }
                }
            }
        }

        /*for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }*/


        int sum = 0;
        //计算最终每列累加的结果
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < len; j++) {
                sum += Math.pow(2,len-1-j) * A[i][j];
            }
        }

        return sum;
    }
}
