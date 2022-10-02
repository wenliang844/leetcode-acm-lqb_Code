package ACM.每日一题leecode.day237;

public class day255_521最长特殊序列Ⅰ {
    public static void main(String[] args) {

    }

    //maxLength - 最长公共子序列 100 18
    public static int findLUSlength(String a, String b) {
        return a.equals(b)?-1:Math.max(a.length(),b.length());
    }
}
