package ACM.leecode周赛.第234场周赛;

import java.util.HashSet;
import java.util.Set;

public class lee1_5713字符串中不同整数的数目 {

    /***
     给你一个字符串 word ，该字符串由数字和小写英文字母组成。
     请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。
     返回对 word 完成替换后形成的 不同 整数的数目。
     如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。
     输入：word = "a123bc34d8ef34"
     输出：3
     解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。

     输入：word = "a1b01c001"
     输出：1
     解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
     */

    //方法一:暴力破解 只要0-9的数字,有字母就隔开 遇到0就去掉
    public static int numDifferentIntegers(String word) {
        //遍历一遍,去掉字符,去掉前导0,放到set<String>中
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (i < word.length() && word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                //加入sb
                sb.append(word.charAt(i));
                i++;
            }
            //如果sb非空 处理第一个数字
            if (sb.length() > 0) {
                int index = 0;
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) == '0') {
                        index++;
                    } else {
                        break;
                    }
                }
                set.add(sb.substring(index, sb.length()));
            }

        }
        //System.out.println(set);

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("a1b01c001"));
        System.out.println(numDifferentIntegers("leet1234code0234aa002034"));//
    }
}
