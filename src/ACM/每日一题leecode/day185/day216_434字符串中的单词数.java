package ACM.每日一题leecode.day185;

import java.util.Arrays;

public class day216_434字符串中的单词数 {
    public static void main(String[] arg2s) {
        System.out.println(countSegments2("Hello, my name is John"));//5
        System.out.println(countSegments(", , , ,        a, eaefa"));//6
        System.out.println(countSegments2(", , , ,        a, eaefa"));
    }

    public static int countSegments(String s) {
        if (s.length()==0) {
            return 0;
        }
        String[] split = s.split(" ");
        System.out.println(Arrays.toString(split));
        return split.length;
    }

    //方法二:遍历法 100 28
    public static int countSegments2(String s) {
        if (s.length()==0) {
            return 0;
        }
        int count = 0;
        if (s.charAt(0)!=' '){
            count++;
        }

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)==' ' && s.charAt(i+1)!=' '){
                count++;
            }
        }
      return count;
    }
}
