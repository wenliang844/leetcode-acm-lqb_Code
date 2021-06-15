package ACM.每日一题leecode.day01;
/*
给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。

 

示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：

输入：s = "", t = "y"
输出："y"
示例 3：

输入：s = "a", t = "aa"
输出："a"
示例 4：

输入：s = "ae", t = "aea"
输出："a"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-difference
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
计数重排:

 */
public class day19_389找不同 {

    public static void main(String[] args) {
        System.out.println("这是结果==="+findTheDifference2("aaabcd", "abcdaea"));
    }

    //方法一 计数 退数
    public static char findTheDifference(String s, String t) {
        char[] ss = s.toCharArray();

        return 'a';
    }

    //方法二 暴力 标记
    public static char findTheDifference2(String s, String t) {
        char[] ss = s.toCharArray();

        boolean flag = false;
        int i;
        for (i = 0; i < t.length(); i++) {

            for (int j = 0; j < ss.length; j++) {
                if(t.charAt(i) ==  ss[j]){
                    System.out.println("出掉了:"+ss[j]);
                    ss[j] = ' ';
                    flag = true;
                    break;
                }
            }
            if (!flag){
                break;
            }
            flag = false;
        }
        System.out.println(i);


        return t.charAt(i);
    }

}
