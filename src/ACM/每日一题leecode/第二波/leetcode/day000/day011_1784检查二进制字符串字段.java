package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/10/3 22:03
 */
public class day011_1784检查二进制字符串字段 {

    /*
    给你一个二进制字符串 s ，该字符串 不含前导零 。
    如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
    如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true​​​ 。否则，返回 false 。
     

    示例 1：
    输入：s = "1001"
    输出：false
    解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
    示例 2：
    输入：s = "110"
    输出：true
     */
    public static void main(String[] args) {
        System.out.println(checkOnesSegment("110"));
    }

    //只要含有1就返回false
    public static boolean checkOnesSegment(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                count++;
            }
        }
        return count == 1 || count == 0;
    }
}
