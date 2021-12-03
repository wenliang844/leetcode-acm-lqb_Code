package ACM.每日一题leecode.day185;

public class day210_326_3的幂 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(1));
    }

    //93/39
    public static boolean isPowerOfThree(int n) {
        if (n==1){
            return true;
        }
        while (n>3 && n%3==0){
            n=n/3;
        }
        return n==3;
    }
}
