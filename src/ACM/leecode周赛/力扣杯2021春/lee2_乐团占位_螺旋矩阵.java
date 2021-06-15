package ACM.leecode周赛.力扣杯2021春;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lee2_乐团占位_螺旋矩阵 {
    /**
     * 某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
     * <p>
     * 为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
     */
    public static void printNums(int nums[][]) {
        for (int k = 0; k < nums.length; k++) {
            System.out.println(Arrays.toString(nums[k]));
        }
        System.out.println("--------");
    }

    //螺旋矩阵构造:超内存:
    public static int orchestraLayout(int num, int xPos, int yPos) {
        int nums[][] = new int[num][num];
        int i = 0;
        int j = 0;
        int number = 1;
        while (true) {
            while (j < num && nums[i][j] == 0) {//==0就是没填充过,<num是边界,在外圈需要边界
                nums[i][j] = number;
                j++;
                number++;
                if (number == 10) number = 1;
            }
            j--;
            i++;
           // System.out.println(i+"--"+j);
           // printNums(nums);
            while (i < num && nums[i][j] == 0) {//填充当前的数字,如果当前的数字不符合,i最后需要--退回
                nums[i][j] = number;
                i++;
                number++;
                if (number == 10) number = 1;
            }
            i--;
            j--;
            //System.out.println(i+"--"+j);
           // printNums(nums);
            while (j >= 0 && nums[i][j] == 0) {//==0就是没填充过,<num是边界,在外圈需要边界
                nums[i][j] = number;
                j--;
                number++;
                if (number == 10) number = 1;
            }
            j++;
            i--;
            //System.out.println(i+"--"+j);
           // printNums(nums);
            while (i >= 0 && nums[i][j] == 0) {//填充当前的数字,如果当前的数字不符合,i最后需要--退回
                nums[i][j] = number;
                i--;
                number++;
                if (number == 10) number = 1;
            }
            i++;
            j++;
            //System.out.println(i+"--"+j);
            //printNums(nums);
            if (nums[i][j] != 0) {
                break;
            }


        }
        //printNums(nums);

        return nums[xPos][yPos];
    }

    //找规律:超时 24/63
    public static int orchestraLayout2(int num, int xPos, int yPos) {
        //int nums[][] = new int[num][num];
        int i = 0;
        int j = 0;
        int number = 1;
        //int result = 0;
        int perLimit = num-1;
        int lastLimit = 0;
        while (true) {
            while (j <= perLimit) {//==0就是没填充过,<num是边界,在外圈需要边界
                //nums[i][j] = number;
               // System.out.println(i+"--"+j+":"+number);
                if (i==xPos && j==yPos)return number;
                j++;
                number++;
                if (number == 10) number = 1;
            }
            j--;
            i++;
           // System.out.println("-------------");
           // System.out.println(i+"--"+j);
           // printNums(nums);
            while (i <=perLimit) {//填充当前的数字,如果当前的数字不符合,i最后需要--退回
                //nums[i][j] = number;
               // System.out.println(i+"--"+j+":"+number);
                if (i==xPos && j==yPos)return number;
                i++;
                number++;
                if (number == 10) number = 1;
            }
            i--;
            j--;
            //System.out.println("-------------");
            //System.out.println(i+"--"+j);
           // printNums(nums);
            while (j >= lastLimit) {//==0就是没填充过,<num是边界,在外圈需要边界
                //nums[i][j] = number;
                //System.out.println(i+"--"+j+":"+number);
                if (i==xPos && j==yPos)return number;
                j--;
                number++;
                if (number == 10) number = 1;
            }
            j++;
            i--;
            //System.out.println("------111-------");
            perLimit--;
            lastLimit++;
            //System.out.println(i+"--"+j);
           // printNums(nums);
            while (i >= lastLimit) {//填充当前的数字,如果当前的数字不符合,i最后需要--退回
               // nums[i][j] = number;
               // System.out.println(i+"--"+j+":"+number);
                if (i==xPos && j==yPos)return number;
                i--;
                number++;
                if (number == 10) number = 1;
            }
            i++;
            j++;
            //System.out.println("-------------");
            //System.out.println(i+"--"+j);
            //printNums(nums);
            /*if (nums[i][j] != 0) {
                break;
            }*/



        }
        //printNums(nums);

        //return nums[xPos][yPos];
    }

    //同余式:

    /****
     public int orchestraLayout(int num, int xPos, int yPos) {
     //根据x，y计算k
     int k = Math.min(Math.min(xPos,yPos),Math.min(num-xPos-1,num-yPos-1)) + 1; //1,2,3
     long total_distance = 0;
     long distance = 0;
     if(xPos<=yPos){
     distance = (xPos-(k-1))+(yPos-(k-1))+1; //1,2...
     total_distance  = T(num,k-1)+distance;
     return total_distance%9==0?9:(int)(total_distance%9);
     }
     //当前层的个数减去0，1，2等
     distance = T(num,k) - T(num,k-1) - (Math.abs(xPos-k)+Math.abs(yPos-(k-1))) ;
     total_distance = T(num,k-1)+distance;
     return total_distance%9==0?9:(int)(total_distance%9);
     }
     public long T(long n,long k){ //k=1,2,3
     if(k<=0){
     return 0;
     }
     else{
     return 4*k*(n-k);
     }
     }
     */
    //数学公式法
    public static int orchestraLayout3(int num, int xPos, int yPos) {
        long x=xPos,y=yPos,n=num;
        if  (x <= y) {
            long  k= Math.min(x, n-1-y);
            return (int) ((4*k*(n-k)+1+(x+y-k*2)-1)%9+1);
        }
        long  k =Math.min(y, n-1-x)+1 ;
        return (int) ((4*k*(n-k)+1-(x+y-(k-1)*2)-1)%9+1);
    }

    /****
     数论中的重要概念。给定一个正整数m，如果两个整数a和b满足a-b能够被m整除，即(a-b)/m得到一个整数，那么就称整数a与b对模m同余，记作a≡b(mod m)。对模m同余是整数的一个等价关系。
     */
    public static void main(String[] args) {
        //System.out.println(orchestraLayout(3, 0, 2));
        //System.out.println(orchestraLayout(4, 1, 2));
        //System.out.println(orchestraLayout(5, 0, 2));

        //System.out.println(orchestraLayout2(3, 0, 2));
        //System.out.println(orchestraLayout2(4, 1, 2));
        System.out.println(orchestraLayout2(5, 0, 2));
        System.out.println(orchestraLayout3(5, 0, 2));

        //System.out.println(orchestraLayout(10,5,5));
        System.out.println(orchestraLayout2(10,5,5));
        System.out.println(orchestraLayout3(10,5,5));

    }
}
