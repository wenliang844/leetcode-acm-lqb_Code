package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/9/29 11:54
 */
public class day009_面试题0109字符串轮转 {
    /*
    字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
    示例1:
     输入：s1 = "waterbottle", s2 = "erbottlewat"
     输出：True
    示例2:
     输入：s1 = "aa", s2 = "aba"
     输出：False
    提示：
    字符串长度在[0, 100000]范围内。
    说明:

    你能只调用一次检查子串的方法吗？``
     */
    public static void main(String[] args) {

        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(isFlipedString("", ""));
    }

    public static boolean isFlipedString(String s1, String s2) {

        if (s1.equals(s2)) return true;
        for (int i = 1; i < s1.length(); i++) {
            String sTemp = s1.substring(i) + s1.substring(0,i);
            if (sTemp.equals(s2)){
                return true;
            }

            //System.out.println("sTemp="+sTemp);
        }
        return false;

    }

}
