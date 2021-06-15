package ACM.每日一题leecode.day32;

public class day35_509斐波那契数 {

    public static void main(String[] args) {
        System.out.println(fib2(0));
        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
    }

    //递推求解法 for循环赋值
    public static int fib(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int a1=0;
        int a2=1;
        int a3=0;
        for (int i = 2; i <= n; i++) {
            a3=a1+a2;
            a1=a2;
            a2=a3;
        }

        return a3;
    }

    //递推 内存优化 ----用局部变量更慢了
    public static int fib2(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int a1=0;
        int a2=1;
        for (int i = 2; i <= n; i++) {
            int a3=a1+a2;
            a1=a2;
            a2=a3;
        }

        return a2;
    }
}
