package ACM.每日一题leecode.day237;

import java.util.HashMap;
import java.util.Map;

public class day263_777在LR字符串中交换相邻字符 {

    /*
    在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
    一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符
    串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换
    成end时， 返回True。

    示例 :
    输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
    输出: True
    解释:
    我们可以通过以下几步将start转换成end:
    RXXLRXRXL ->
    XRXLRXRXL ->
    XRLXRXRXL ->
    XRLXXRRXL ->
    XRLXXRRLX
     */
    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    //方法一:暴力方法 如果字母不相等,是XL就替换  是RX也替换   不相等就false
    public static boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int X = 0;
        int R = 0;
        int L = 0;

        //猜想1:XRL的数目相等,就true
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'X') {
                X++;
            } else if (start.charAt(i) == 'R') {
                R++;
            } else {
                L++;
            }
        }

        for (int i = 0; i < end.length(); i++) {
            if (end.charAt(i) == 'X') {
                X--;
            } else if (end.charAt(i) == 'R') {
                R--;
            } else {
                L--;
            }
        }
        if (L == 0 && R == 0 && X == 0) {
            return true;
        }

        return false;
    }
}
