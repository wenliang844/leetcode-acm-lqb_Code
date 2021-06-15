package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

import java.lang.reflect.Array;
import java.util.*;

public class code10_收集两字符相加是回文串的下标_336回文对 {

    /***
     bat tab cat
     return 0,1 1,0
     */
    public static boolean isHuiWen(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //方法一:如果长度相等,只需要reverse相等会可以,否则需要拼接起来暴力判断-------超时115/134
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue; //如果不可以匹配自己
                String temp = words[i] + words[j];
                if (isHuiWen(temp)) {
                    List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(i);
                    tempList.add(j);
                    list.add(tempList);
                }
            }
        }

        return list;
    }

    //优化134 / 134
    public static List<List<Integer>> palindromePairs2(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                //String temp = words[i] + words[j];//节省两个变量
                //String temp2 = words[j] + words[i];
                if (isHuiWen(words[i] + words[j])) {
                    /*List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(i);
                    tempList.add(j);*/
                    list.add(Arrays.asList(i,j));
                }
                if (isHuiWen(words[j] + words[i])) {
                    /*List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(j);
                    tempList.add(i);*/
                    list.add(Arrays.asList(j,i));
                }
            }
        }

        return list;
    }

    /*****
     四种情况：

     数组里有空字符串，并且数组里还有自己就是回文的字符串，每出现一个可与空字符串组成两对。
     如果自己的翻转后的字符串也在数组里，可以组成一对，注意翻转后不能是自己。
     如果某个字符串能找到一个分割点，分割点前的部分是回文，后半部分翻转后也在数组里，可组成一对。
     把3反过来，如果后部分是回文，前半部分翻转后在数组里，可组成一对。
     */
    //方法二:字典树or哈希表:枚举前缀和后缀 提交的时候要非static--- 78 80
    public static List<String> wordsRev = new ArrayList<>();//反转之后的匹配字符串
    public static Map<String,Integer> indices = new HashMap<>();//存好每一个string需要的下标
    public static List<List<Integer>> palindromePairs3(String[] words){
        int n = words.length;
        for (int i = 0; i < n; i++) {
            wordsRev.add(new StringBuffer(words[i]).reverse().toString());
        }
        for (int i = 0; i < n; i++) {
            indices.put(wordsRev.get(i),i);//可以匹配的下标
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = words[i].length();
            if (m==0){//是""空字符,那么你和本身是回文不缺的可以 空字符在map里面的,只要别人找就可以了,当你是回文的时候,找的是""空
                continue;
            }
            for (int j = 0; j <=m; j++) {
                if (isPalindrome(word,j,m-1)){//判断局部字符是不是回文串 左边是回文串了,那么只需要右边匹配就可以
                    int leftId = findWord(word,0,j-1);
                    if (leftId!=-1 && leftId!=i){
                        ret.add(Arrays.asList(i,leftId));
                    }
                }

                if (j!=0 && isPalindrome(word,0,j-1)){//右边也是同理
                    int rightId = findWord(word,j,m-1);
                    if (rightId!=-1 && rightId!=i){
                        ret.add(Arrays.asList(rightId,i));
                    }
                }
            }
        }
        return ret;
    }

    private static int findWord(String s, int left, int right) {//找这个字符对应的下标
        return indices.getOrDefault(s.substring(left,right+1),-1);
    }

    //判断局部的字符是不是回文串
    private static boolean isPalindrome(String s, int left, int right) {
        int len = right-left+1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left+i)!=s.charAt(right-i)){
                return false;
            }
        }
        return true;
    }

    /***
     左程云策略
     最优解法:
     1.逆序一下 查逆序的在回文中有没有,有一定是回文
     2.palindrome->manacher算法:求一个
     变成每一个位置,离自己的位置最多的回文半径是多少,
     manacher :能快速知道一一个字符为中心,它最多能找到的回文串有多少
     121 21 135
     1
     121
     12121也是:怎么最快找到前缀是不是回文,遍历慢,manacher快速寻找



     # manacher算法，易懂版本。
     def manacher(s):
     P = [0] * len(s)
     R, C = 0, 0
     for i in range(1, len(s) - 1):
     i_mirror = 2 * C - i
     if R <= i:
     # 新起点
     pass
     else: # R > i
     if R - i > P[i_mirror]:
     # 包含，直接返回
     P[i] = P[i_mirror]
     continue
     else:
     # 相交，尝试从R处开始扩展。
     # 因为下一个比较的是s[i + P[i] + 1]，由于P[i]=R-i,所以比较的就是s[R+1]
     P[i] = R - i
     # 尝试匹配
     while s[i - P[i] - 1] == s[i + P[i] + 1]:
     P[i] += 1
     # 更新R，C
     if i + P[i] > R:
     R, C = i + P[i], i
     return P


     # manacher算法，美颜版。
     def manacher(s):
     T = '#'.join('^{}$'.format(s))
     # T = s
     P = [0] * len(T)
     R, C = 0, 0
     for i in range(1,len(T) - 1):
     if i < R:
     P[i] = min(P[2 * C - i], R - i)

     while T[i+(P[i]+1)] == T[i-(P[i]+1)]:
     P[i] += 1

     if i + P[i] > R:
     R, C = i + P[i], i
     return P
     */

    public static void main(String[] args) {
        System.out.println(palindromePairs3(new String[]{"bat", "tab", "cat", "sss"}));
        System.out.println(palindromePairs3(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(palindromePairs3(new String[]{"abcd", "dcba", "lls", "s", "sssll","","asa"}));
    }
}
