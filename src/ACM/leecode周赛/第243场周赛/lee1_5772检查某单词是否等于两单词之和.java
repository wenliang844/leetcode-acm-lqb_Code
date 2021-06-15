package ACM.leecode周赛.第243场周赛;

public class lee1_5772检查某单词是否等于两单词之和 {
    public static void main(String[] args) {
        //从 0 开始 计数。即，'a' -> 0、'b' -> 1、'c' -> 2，以此类推。
        //System.out.println((int)'a');
        System.out.println(isSumEqual("acb", "cba", "cdb"));
        System.out.println(isSumEqual("aaa", "a", "aab"));
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        return getNum(firstWord)+getNum(secondWord)==getNum(targetWord);
    }

    public static int getNum(String s){
        int num=0;
        int i = 0;
        while (i<s.length()&&s.charAt(i)=='a' )i++;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            num=num*10+(c-97);
        }
        System.out.println(num);
        return num;
    }
}
