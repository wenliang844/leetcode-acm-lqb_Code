package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q6大等于n的最小完全平方数 {
    public static void main2(String[] args) {//71711-71824
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = n;; i++) {
            double sqrt = Math.sqrt(i);
            double sub = (double)(int)sqrt;
            double sub1 = sqrt - sub;
            if (sub1==0){
                System.out.println(i);
                break;
            }
        }
    }

    //暴力解法  还有二分解法
    public static void main(String[] args) {//71711-71824
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = (int) Math.sqrt(n);; i++) {
            if (i*i>=n){
                System.out.println(i*i);
                break;
            }
        }
    }//二分解法 2147483647
    public static void main4(String[] args) {//71711-71824
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n<=0){
            System.out.println(0);
            return;
        }

        int left = 0;
        int right = (int)Math.sqrt(Integer.MAX_VALUE);//Integer.MAX_VALUE
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println("这是right"+right);
        int count=20;
        while (true){
            //System.out.println("这是left=="+left+"------"+"这是right"+right);
            int mid = (left+right) /2;
            //System.out.println(mid);
            if (mid*mid>=n && (mid-1)*(mid-1)<n){
                //System.out.println("这是mid==="+mid);
                System.out.println(mid*mid);
                break;
            }
            if (mid*mid>n){
                right=mid -1;
            }else if (mid*mid<n){
                left=mid +1;
            }


            if (count--==0)break;
        }
    }
}
