package ACM.每日一题leecode.day185;

public class day195_剑指Offer10I斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fib2(0));
        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
        System.out.println(fib2(5));
        System.out.println(fib2(6));
        System.out.println(fib2(45));
    }

    public static int fib1(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        return fib1(n-1)+fib1(n-2);
    }

    //mod 1000000007 100/6
    public static int fib2(int n) {
       int[] a = new int[2];
       a[0] = 0;
       a[1] = 1;
        if (n<2){
            return  a[n];
        }
        for (int i = 0; i < n - 1; i++) {
            int temp = (a[0]+a[1])%1000000007;
            a[0]=a[1];
            a[1]=temp;
        }


        return a[1];
    }
}
