package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/12/15 10:13
 */
public class day022_1945字符串转化后的各位数字之和 {
    public static void main(String[] args) {
        System.out.println(getLucky("leetcode", 2));
    }

    public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)-'a'+1);
        }
        String str = sb.toString();
        //System.out.println(str);
        int count = Integer.MAX_VALUE;
        while (k-- >0 && count>=10){
            count = 0;
            for (int i = 0; i < str.length(); i++) {
                count += Integer.valueOf(String.valueOf(str.charAt(i)));
            }
            str = String.valueOf(count);

            //System.out.println(str+"---"+k);
        }

        return count;
    }
}
