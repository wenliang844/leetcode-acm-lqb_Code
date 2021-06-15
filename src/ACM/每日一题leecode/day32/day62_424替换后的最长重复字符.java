package ACM.每日一题leecode.day32;

/***
 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

 注意：字符串长度 和 k 不会超过 104。

  

 示例 1：

 输入：s = "ABAB", k = 2
 输出：4A
 解释：用两个'A'替换为两个'B',反之亦然。
 示例 2：

 输入：s = "AABABBA", k = 1
 输出：4
 解释：
 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 子串 "BBBB" 有最长重复字母, 答案为 4。
 */
public class day62_424替换后的最长重复字符 {

    public static void main(String[] args) {
        System.out.println("这是结果="+characterReplacement("ABAB", 2));//4
        System.out.println("这是结果="+characterReplacement("AABABBA", 1));//4
        System.out.println("这是结果="+characterReplacement("AAABBB", 3));//6
        System.out.println("这是结果="+characterReplacement("AAAA", 3));//4
        System.out.println("这是结果="+characterReplacement("ABAA", 0));//2
        System.out.println("这是结果="+characterReplacement("ABBB", 2));//2
    }

    //暴力解法:
    public static int characterReplacement(String s, int k) {
        /***
         思路:
         1.暴力:设置i j
         将i进行遍历,到重复的结束之后,j记录位置,当不重复的字母超过k的时候,更新maxcount
         */

        int i=0;
        int j;
        int maxCount=0;
        int count=0;
        int dis=k;
        char[] chs = s.toCharArray();
        char ch = chs[i];
        i=1;
        count=1;
        while (i<chs.length){
            if (chs[i]==ch){
                count++;
                i++;
            }else {
                System.out.println("不相等的字母="+chs[i]);
                j=i;
                while (i<chs.length){
                        if (chs[i]!=ch){

                            if (dis<=0){
                                break;
                            }
                            dis--;
                            count++;
                            i++;
                        }else {
                            count++;
                            i++;
                        }
                }

                maxCount = Math.max(maxCount,count);
                i=j;
                ch=chs[j];
                i++;
                count=1;
                dis=k;
            }

        }
        maxCount=Math.max(count,maxCount);






        int maxCount2=0;
        count=0;
        dis=k;
        chs = String.valueOf(new StringBuilder(s).reverse()).toCharArray();
        i=0;
        ch = chs[i];
        i=1;
        count=1;
        while (i<chs.length){
            if (chs[i]==ch){
                count++;
                i++;
            }else {
                System.out.println("不相等的字母="+chs[i]);
                j=i;
                while (i<chs.length){
                    if (chs[i]!=ch){

                        if (dis<=0){
                            break;
                        }
                        dis--;
                        count++;
                        i++;
                    }else {
                        count++;
                        i++;
                    }
                }

                maxCount2 = Math.max(maxCount2,count);
                i=j;
                ch=chs[j];
                i++;
                count=1;
                dis=k;
            }

        }
        maxCount2=Math.max(count,maxCount2);



        return Math.max(maxCount,maxCount2);
    }

    //滑动窗口
    public static int characterReplacement2(String s, int k){
        /***'
         确保窗口长度为窗口内数量最多的字母+k

         */

        return 0;

    }

    /**
     answer
     class Solution {
     public int characterReplacement(String s, int k) {
     int[] num = new int[26];
     int n = s.length();
     int maxn = 0;
     int left = 0, right = 0;
     while (right < n) {
     num[s.charAt(right) - 'A']++;
     maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
     if (right - left + 1 - maxn > k) {
     num[s.charAt(left) - 'A']--;
     left++;
     }
     right++;
     }
     return right - left;
     }
     }

     */
}
