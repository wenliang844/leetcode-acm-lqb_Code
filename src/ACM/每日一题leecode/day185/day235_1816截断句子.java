package ACM.每日一题leecode.day185;

public class day235_1816截断句子 {
    public static void main(String[] args) {
        System.out.println(truncateSentence("What is the solution to this problem", 4));
        System.out.println(truncateSentence("What is the solution to this problem", 7));
    }

    //65 79
    public static String truncateSentence(String s, int k) {
        int i = 0;
        for (; i < s.length()&&k>0; i++) {
            if (s.charAt(i)==' ' || s.charAt(i)=='、'){
                k--;
            }
        }
        if (i!=s.length())i--;
        return s.substring(0,i);
    }
}
