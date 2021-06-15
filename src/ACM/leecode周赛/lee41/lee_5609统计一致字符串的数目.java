package ACM.leecode周赛.lee41;
/*
给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致 字符串。

请你返回 words 数组中 一致 字符串的数目。



示例 1：

输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
输出：2
解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
示例 2：

输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
输出：7
解释：所有字符串都是一致的。
示例 3：

输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
输出：4
解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 */
public class lee_5609统计一致字符串的数目 {

    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};
        System.out.println("结果是==="+countConsistentStrings(allowed, words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {

        int count =0;
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                String s = String.valueOf(ch);
                //System.out.println("这是string[i]==="+words[i]);
               // System.out.println("这是s==="+s);
                if (!allowed.contains(s)){
                    //System.out.println("执行了flag=false");

                    flag = false;
                    break;
                }
            }

            if (flag){
                //System.out.println("执行了count++");
                count++;
            }
        }

        return count;
    }
}
