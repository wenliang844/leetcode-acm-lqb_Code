package ACM.每日一题leecode.自刷;

import java.util.Map;

public class leeTop_69x的平方根 {
    /***
     实现 int sqrt(int x) 函数。
     计算并返回 x 的平方根，其中 x 是非负整数。
     由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     示例1:
     输入: 4
     输出: 2
     示例 2:
     输入: 8
     输出: 2
     说明: 8 的平方根是 2.82842...,
          由于返回类型是整数，小数部分将被舍去。
     */
    //方法一:暴力破解,枚举 5 92
    public static int mySqrt(int x) {
        long ans = 1;//int会超出范围
        while (true){
            if (ans*ans>x){
                return (int) (ans-1);
            }
            ans++;
        }
    }
      //方法二:系统api 100 79
    public static int mySqrt2(int x) {

        return (int) Math.sqrt(x);
    }
      //方法三:官方:二分查找法,牛顿迭代法
    public static int mySqrt3(int x) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1));//2
        System.out.println(mySqrt(2));//2
        System.out.println(mySqrt(3));//2
        System.out.println(mySqrt(4));//2
        System.out.println(mySqrt(5));//2
        System.out.println(mySqrt(8));//2
        System.out.println(mySqrt(9));//2
        System.out.println(mySqrt(10));//2
        System.out.println(mySqrt(2147395600));//46340
        System.out.println("-------two-------");
        System.out.println(mySqrt2(1));//2
        System.out.println(mySqrt2(2));//2
        System.out.println(mySqrt2(3));//2
        System.out.println(mySqrt2(4));//2
        System.out.println(mySqrt2(5));//2
        System.out.println(mySqrt2(8));//2
        System.out.println(mySqrt2(9));//2
        System.out.println(mySqrt2(10));//2
        System.out.println(mySqrt2(2147395600));//46340
    }

}
