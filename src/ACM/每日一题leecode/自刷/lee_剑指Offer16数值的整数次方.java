package ACM.每日一题leecode.自刷;

public class lee_剑指Offer16数值的整数次方 {

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow_3(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow_3(2.1, 3));
        System.out.println(myPow(2, -2));
        System.out.println(myPow_3(2, -2));
    }

    public static double myPow(double x, int n) {

        double res = Math.pow(x, n);
        return res;
    }

    //超时
    public static double myPow_1(double x, int n) {

        double res = 1;
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                res *= x;
            }
        } else {
            x = 1 / x;
            n = -n;
            for (int i = 0; i < n; i++) {
                res *= x;
            }
        }


        return res;
    }

    public static double myPow_2(double x, int n) {
        /***
         最后执行的输入：
         1.00000
         2147483647
         */
        double xx = x;
        if (x == 1) {
            return 1;
        }
        double res = 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        /*for (int i = 0; i < n; i++) {
            res *= x;
        }*/
        //折本进行 快速幂
        while (n > 0) {
            res *= x;
            n /= 2;
            x *= x;
        }

        return n > 0 ? res : 1 / (res * xx);
    }

    public static double myPow_3(double x, int n) {

        /***
         快速幂法 可将时间复杂度降低至 O(log_2 n)O(log
         2
         ​
         n) ，以下从 “二分法” 和 “二进制” 两个角度解析快速幂法。
         二分推导： x^n = x^{n/2} \times x^{n/2} = (x^2)^{n/2}x
         n
         =x
         n/2
         ×x
         n/2
         =(x
         2
         )
         n/2
         ，令 n/2n/2 为整数，则需要分为奇偶两种情况（设向下取整除法符号为 "////" ）：

         当 nn 为偶数： x^n = (x^2)^{n//2}x
         n
         =(x
         2
         )
         n//2
         ；
         当 nn 为奇数： x^n = x(x^2)^{n//2}x
         n
         =x(x
         2
         )
         n//2
         ，即会多出一项 xx
         */
        double res = 1;
        double base = x;
        boolean flag = n >= 0;
        //负数取反，考虑到最小负数，需要先自增，后续再除以2
        if (!flag) n = -(++n);
        while (n > 0) {
            long f = n & 1;//n%2=1 等价于判断最右边的值
            if (f == 1)
                res *= x;
            n = n >> 1;//n=n//2 向下取整
            x *= x;
        }
        return flag ? res : 1 / (res * base);
    }


    /***
     c++快速幂，递归双100，需要考虑负数右移始终为负数。迭代方法需要考虑最小值取正会溢出。

     //递归
     class Solution {
     public:
     double myPow(double x, int n) {
     if(n==0) return 1;
     //考虑到负数右移永远是负数，
     if(n==-1) return 1/x;
     if(n&1) return myPow(x*x, n>>1)*x;
     else return myPow(x*x, n>>1);
     }
     };

     //迭代，计算n的绝对值结果，若n为负则取倒数
     class Solution {
     public:
     double myPow(double x, int n) {
     double res=1;
     double base=x;
     bool flag=n>=0;
     //负数取反，考虑到最小负数，需要先自增，后续再除以2
     if(!flag) n=-(++n);
     while(n>0){
     if(n&1) res*=x;
     n=n>>1;
     x*=x;
     }
     return flag?res:1/(res*base);
     }
     };

     @子正 贴个完整的代码, 贴的是对特定case偷个懒

     class Solution {
     public:
     double myPow(double x, int n) {
     if(n==0) return 1.0;
     if(n==INT_MIN) {
     if(x==1.0 || x==-1.0)
     return 1.0;
     else return 0.0;
     }
     if(n<0) return myPow(1.0/x, -n);
     double t = myPow(x, n/2);
     t = t*t;
     if(n&1) t*=x;
     return t;
     }
     };


     自己写的，之前没接触过快速幂这个东西，我以为我自己的代码叫做折半相乘= =

     class Solution {
     public double myPow(double x, int n) {
     if(n == 0){
     return 1;
     }
     int temp = n;
     if(n<0){
     n = -n;
     }
     double result = x;
     int base = 1;
     n--;
     while(n >= 1){
     result = result*result;
     n = n-base;
     base = base*2;
     }
     for(int i = 0;i<n;i++){
     result *= x;
     }
     for(int i = 0;i>n;i--){
     result = result / x;
     }
     return temp>0?result:1/result;
     }
     }


     注意这里面有个坑，关于计算机里面原、反、补的数字的表示的坑。 在普通计算机内，数是用补码表示滴，而这里b = -b 和 b = -n就隐藏着这个坑、

     if(b<0) {
     x = 1/x;

     // -n会溢出，但在long形态里面，还是表示的-2147483648，为什么呢？
     // n = -2147483648(对应计算机里的补码表示)
     // -n 对应计算机里面的真实（补码）表示，和n的补码表示一样，因为已经溢出了，表示不了了。
     // 因为根据求相反数的规则：对n求相反数，就对n进行从右往左数，第1个1不变，其他的二进制位变成相反数即可。
     // 参考百度百科补码表示：https://baike.baidu.com/item/%E8%A1%A5%E7%A0%81

     b = -n ; //  b = -2147483648， 错误代码
     // b = -b;  // b = 2147483648，正确代码，-b也可以在  正数范围内进行表示。

     // System.out.println(b);

     }
     */
}
