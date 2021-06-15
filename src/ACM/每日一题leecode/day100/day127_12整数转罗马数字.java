package ACM.每日一题leecode.day100;

import java.util.HashMap;
import java.util.Map;

public class day127_12整数转罗马数字 {
    /****
     罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

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
     给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     示例 1:
     输入: 3
     输出: "III"
     */
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(9));
    }

    //暴力解法
    static String ans;
    static int orinum;
    //49,37
    public static String intToRoman(int num) {
        /*Map<Integer,Character> map = new HashMap<>();
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');*/
        //
        ans = "";
        orinum = num;
        change(1000,"M");
        change(900,"CM");
        change(500,"D");
        change(400,"CD");
        change(100,"C");
        change(90,"XC");
        change(50,"L");
        change(40,"XL");
        change(10,"X");
        change(9,"IX");
        change(5,"V");
        change(4,"IV");
        change(1,"I");


        return ans;
    }

    private static void change(int number, String m) {
        while (orinum>=number){
            orinum-=number;
            ans+=m;
        }
    }


}
