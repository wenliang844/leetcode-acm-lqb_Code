package ACM.每日一题leecode.day185;

public class day218_441排列硬币 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(1));
        System.out.println(arrangeCoins(2147483647));
    }

    public static int arrangeCoins(int n) {
        int index = 0;
        while (n >= 0) {
            index++;
            n -= index;
        }
        return index - 1;
    }
}
