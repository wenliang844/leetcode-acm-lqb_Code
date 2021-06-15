package ACM.每日一题leecode.自刷;

import java.util.HashMap;
import java.util.Map;

public class leeTop面试_13罗马数字转整数 {
    /***
     罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     字符          数值
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     示例 1:
     输入: "III"
     输出: 3

     这题懂了就非常简单。首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
     */
    //方法一:枚举特例,map通常case 2053 3999
    //优化:在正常的数字中也会出现特例 20 14
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
       /* if (s.equals("IV") || s.equals("IX") || s.equals("XL") || s.equals("XC") || s.equals("CD") || s.equals("CM")){
            int num1 = map.get(s.charAt(0));
            int num2 = map.get(s.charAt(1));
            return num2-num1;
        }*/
        //else {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1) {
                String substring = s.substring(i, i + 2);
                if (substring.equals("IV") || substring.equals("IX") || substring.equals("XL") || substring.equals("XC") || substring.equals("CD") || substring.equals("CM")) {
                    int num1 = map.get(s.charAt(i));
                    int num2 = map.get(s.charAt(i + 1));
                    ans += (num2 - num1);
                    i++;
                    continue;
                }
            }
            ans += map.get(s.charAt(i));

        }
        return ans;
    }

    //网友的漂亮的代码
    public static int romanToInt2(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += which(s.charAt(i));
        }
        return result;
    }

    public static int which(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
        }
        return 0;
    }
    //}

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
