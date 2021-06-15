package ACM.leecode周赛.lee第221场周赛;
/*
给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。

两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。

如果 a 和 b 相似，返回 true ；否则，返回 false 。



示例 1：

输入：s = "book"
输出：true
解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
示例 2：

输入：s = "textbook"
输出：false
解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
注意，元音 o 在 b 中出现两次，记为 2 个。
示例 3：

输入：s = "MerryChristmas"
输出：false
示例 4：

输入：s = "AbCdEfGh"
输出：true
 */
public class lee_5637判断字符串的两半是否相似 {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }

    public static boolean halvesAreAlike(String s) {
        /***
         思路:用substring分成俩个字符串
         用s字符串装元音
         遍历s1 s2  用s.contain判断是否是元音 count1 count2计数
         */

        String compare = "aeiouAEIOU";
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2, s.length());


        int count1=0;
        int count2=0;
        for (int i = 0; i < s1.length(); i++) {
            if (compare.contains(s1.substring(i,i+1))){
                count1++;
            }
        }for (int i = 0; i < s2.length(); i++) {
            if (compare.contains(s2.substring(i,i+1))){
                count2++;
            }
        }
        System.out.println(s1+"---"+s2+"--"+count1+"-"+count2+"=="+compare);
        return count1==count2?true:false;
    }
}
