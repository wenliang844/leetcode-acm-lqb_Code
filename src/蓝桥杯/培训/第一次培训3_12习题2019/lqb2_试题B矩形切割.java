package 蓝桥杯.培训.第一次培训3_12习题2019;

public class lqb2_试题B矩形切割 {

    /***
     小明有一些矩形的材料，他要从这些矩形材料中切割出一些正方形。
     当他面对一块矩形材料时，他总是从中间切割一刀，切出一块最大的正方
     形，剩下一块矩形，然后再切割剩下的矩形材料，直到全部切为正方形为止。
     例如，对于一块两边分别为 5 和 3 的材料（记为 5 × 3），小明会依次切出
     3 × 3、 2 × 2、 1 × 1、 1 × 1 共 4 个正方形。
     现在小明有一块矩形的材料，两边长分别是 2019 和 324。请问小明最终会
     切出多少个正方形？
     */


    public static int test1() {

        /**
         切除 2019 / 324 个正方形 = b
            再 2019-324   和324

         */

        int a = 2019;
        int b = 324;
        int count = 0;
        while (true){

            System.out.println("这是a="+a);
            System.out.println("这是b="+b);
            if (a==0 || b==0){
                //count++;
                break;
            }
            int temp = b;
            count += a/temp;
            b=a%temp;
            a=temp;
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println("这是结果==="+test1());
    }
}
