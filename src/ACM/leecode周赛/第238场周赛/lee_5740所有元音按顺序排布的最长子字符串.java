package ACM.leecode周赛.第238场周赛;

public class lee_5740所有元音按顺序排布的最长子字符串 {
    /***
     当一个字符串满足如下条件时，我们称它是 美丽的 ：
     所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
     这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
     比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
     给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
     子字符串 是字符串中一个连续的字符序列。
     示例 1：
     输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
     输出：13
     解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
     */
    public static void main(String[] args) {
        System.out.println((int) 'a');//最小
        System.out.println((int) 'e');
        System.out.println((int) 'i');
        System.out.println((int) 'o');
        System.out.println((int) 'u');

        System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
        System.out.println(longestBeautifulSubstring("a"));
        System.out.println(longestBeautifulSubstring("u"));
        System.out.println(longestBeautifulSubstring("eauoiouieaaoueiuaieoeauoiaueoiaeoiuieuaoiaeouiaueo"));
    }

    //方法一:暴力枚举每一种情况:当第一个字符是开头的情况下的最长 超时:87/96
    public static int longestBeautifulSubstring(String word) {


        int maxLength = 0;
        for (int i = 0; i < word.length(); i++) {

            //当i是开头的时候,最长可以到多长,当有一个新字符<当前秩序的最大字符时,退出
            //a最小,就是你不能小于前面一个数
            if (word.charAt(i) == 'a') {
                int j = i + 1;
                for (; j < word.length(); j++) {
                    if (word.charAt(j) != word.charAt(j - 1) && (word.charAt(j) - word.charAt(j - 1) != 4 && word.charAt(j) - word.charAt(j - 1) != 6)) {//word.charAt(j)<word.charAt(j-1)
                        break;
                    }
                }
                System.out.println("i=" + i + "---maxlen=" + maxLength);
                if (word.charAt(j - 1) == 'u') {
                    maxLength = Math.max(maxLength, j - i);
                }
            }

        }
        return maxLength;
    }

    //方法二:单指针
    public static int longestBeautifulSubstring2(String word) {


        int maxLength = 0;
        return maxLength;
    }

    //方法三:动态规划
    public static int longestBeautifulSubstring3(String word) {


        int maxLength = 0;
        return maxLength;
    }
}
