package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/1/29 11:24
 */
public class day028_2315统计星号 {
    public static void main(String[] args) {

        System.out.println(countAsterisks(new String("l|*e*et|c**o|*de|")));
    }

    //暴力解法
    public static int countAsterisks(String s) {

        int count = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|'){
                flag = !flag;
            }
            if (flag && s.charAt(i) == '*'){
                count++;
            }
        }
        return count;
    }
}
