package ACM.每日一题leecode.day237;

public class day244_1688比赛中的配对次数 {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));
    }
    // 100|5
    public static int numberOfMatches(int n) {
        if (n==1) {
            return 0;
        }
        return n%2==0?n/2+numberOfMatches(n/2):n/2+numberOfMatches(n/2+1);
    }
}
