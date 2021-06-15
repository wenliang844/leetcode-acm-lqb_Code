package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

import java.util.Arrays;

public class code6_计算第n个丑数 {

    /**
     * 5. 规定1是丑数,只含有有2 3 5的因子的数是丑数
     * 比如1 2 3 4 5 6  9 10 12 15…
     * 求第n个丑数
     *
     * @param n
     */

    //暴力 一个一个count++
    public static boolean isUgly(int n) {

        while (n%2==0){
            n = n/2;
        }while (n%3==0){
            n = n/3;
        }while (n%5==0){
            n = n/5;
        }
        return n==1?true:false;
    }

    public static void ugly(){
        for (int i = 1; i < 20; i++) {
            if (isUgly(i)){
                System.out.print(i+"\t");
            }
        }
    }

    /***
        动态规划法:利用已经求好的答案
     第i项一定是之前的某个丑数*2,3,5形成的;
     1 2 3 4 5 6
     方法:第一个是1
     三个指针i2 i3 i5 用指下标都=0
     让i2 i3 i5中最小的作为result[index]的下一个 然后i2++
     */

    //方法一:三指针   高级 :69 33
    public static int calcUgly(int n){
        int[] result = new int[n];
        int index = 1;
        result[0] = 1;
        int i2=0,i3=0,i5=0;
        while (index<n){
            result[index] = Math.min(2*result[i2],Math.min(3*result[i3],5*result[i5]));
            if (result[index]==2*result[i2]){
                i2++;
            }if (result[index]==3*result[i3]){
                i3++;
            }if (result[index]==5*result[i5]){
                i5++;
            }
            index++;
        }

        return result[n-1];

    }

    //方法二:使用set 直接遍历set * 2 3 5  往复循环 然后排序好找第n个元素
    //方法3:大根堆,如果是重复的不进堆,最后最大的元素就是了
    public static int calcUgly2(int n){

        return 0;
    }
    public static void main(String[] args) {
        //ugly();
        System.out.println(calcUgly(10));
    }
}
