package ACM.leecode周赛.第232场周赛;

import java.util.Arrays;

public class lee_5701仅执行一次字符串交换能否使两个字符串相等 {

    /***
     给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。

     如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。



     示例 1：

     输入：s1 = "bank", s2 = "kanb"
     输出：true
     解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
     示例 2：

     输入：s1 = "attack", s2 = "defend"
     输出：false
     解释：一次字符串交换无法使两个字符串相等
     示例 3：

     输入：s1 = "kelb", s2 = "kelb"
     输出：true
     解释：两个字符串已经相等，所以不需要进行字符串交换
     示例 4：

     输入：s1 = "abcd", s2 = "dcba"
     输出：false
     */

    /**
     * 思路:最多只有0个或两个字符串不一样
     * 定义一个i
     * 一个j 默认都是0;
     * 找出两个不相等的字符ij分别标记
     * 然后退出循环,将字符的i j进行交换  两个字符串equal则通过   返之
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean areAlmostEqual(String s1, String s2) {

        int[] index = new int[2];
        int count = 1;//count递减,当ocunt =-1   <0   退出
        //找出index[1] index[0]   两个下标
        for (int i = 0; i < s1.length(); i++) {
            //System.out.println(s1.charAt(i));
            //System.out.println(s2.charAt(i));
            if (s1.charAt(i) != s2.charAt(i)) {
                index[count] = i;
                count--;
               // System.out.println(i);
            }

            if (count < 0) {
                break;
            }
        }

        //System.out.println(Arrays.toString(index));
        //交换
        char[] chars = s1.toCharArray();
        char temp = chars[index[0]];
        chars[index[0]] = chars[index[1]];
        chars[index[1]] = temp;
        String s = new String(chars);
       // System.out.println(s +"==="+s2);
        if (s.equals(s2)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("attack", "defend"));

    }

}
