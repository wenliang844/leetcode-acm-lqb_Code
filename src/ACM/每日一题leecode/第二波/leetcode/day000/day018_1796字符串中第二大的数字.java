package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/12/3 16:03
 */
public class day018_1796字符串中第二大的数字 {

    public static void main(String[] args) {
        System.out.println(secondHighest("dfa12321afd"));
        System.out.println(secondHighest("abc1111"));
    }

    public static int secondHighest(String s) {
        int max = -1;
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int temp = c - '0';
                if (temp > max) {
                    res = max;
                    max = temp;
                } else if (temp > res && temp != max) {
                    res = temp;
                }
            }
        }
        return res;
    }
}
