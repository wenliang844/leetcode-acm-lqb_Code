package ACM.每日一题leecode.day185;

import java.util.Arrays;

public class day208_58最后一个单词的长度 {
    public static void main(String[] args) {
        //System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the    moon    "));
    }

    //37|10
    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        //System.out.println(Arrays.toString(split));
        //System.out.println(split[split.length-1].length());
        return split[split.length-1].length();
    }
}
