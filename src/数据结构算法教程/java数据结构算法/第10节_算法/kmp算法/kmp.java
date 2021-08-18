package 数据结构算法教程.java数据结构算法.第10节_算法.kmp算法;

import java.util.Arrays;

/*
4. 扩展1：BM算法
    KMP的匹配是从模式串的开头开始匹配的，而1977年，德克萨斯大学的Robert S. Boyer教授和J Strother Moore教授发明了一种新的字符串匹配算法：Boyer-Moore算法，简称BM算法。该算法从模式串的尾部开始匹配，且拥有在最坏情况下O(N)的时间复杂度。在实践中，比KMP算法的实际效能高。

    BM算法定义了两个规则：

坏字符规则：当文本串中的某个字符跟模式串的某个字符不匹配时，我们称文本串中的这个失配字符为坏字符，此时模式串需要向右移动，移动的位数 = 坏字符在模式串中的位置 - 坏字符在模式串中最右出现的位置。此外，如果"坏字符"不包含在模式串之中，则最右出现位置为-1。
好后缀规则：当字符失配时，后移位数 = 好后缀在模式串中的位置 - 好后缀在模式串上一次出现的位置，且如果好后缀在模式串中没有再次出现，则为-1。
 */
public class kmp {
    /****
     kmp;原理解析
     是通过next数组保存模式串中前后最长公共子序列的长度,
     每次回溯,通过next数组找到哦啊,前面匹配过的位置
     模式串 a b a b  最长公共子序列
     0 0 1 2
     模式串 a b a b    next数组
     -1 0 0 1

     A B C D A B D
     0 0 0 0 1 2 0

     j - next[j]
     j = next[j];


     字符串: bread
     前缀 b br bre brea
     后缀 read ead ad d
     部分匹配值就是前缀和后缀的最长共有的长度,ABCDABD
     A 0
     AB A前缀 B后缀 0
     ABC A,AB  B,BC
     ABCDA A AB ABC ABCD --- BCDA CDA DA A  共有元素A 长度1
     ABCDAB 前缀A AB ABCD ABCDA --- BCDAB AB 共有元素AB 长度2
     ABCDABD    前缀后缀   共有0

     1.KMP先得到KMP部分匹配表
     2.kmp使用部分匹配表




     假设现在S串匹配到i位置，T串匹配到j位置。

     BF算法中，
     如果当前字符匹配成功，即s[i+j]==T[j]，令i++，j++，
     继续匹配下一个字符；如果 失配，即S[i+j]!=T[j]，
     令i++，j=0，即每次匹配失败的情况下，模式 串T相对
     于原始串S向右移动了一位。

     KMP算法中，如果当前字符匹配成功，
     即S[i+j]==T[j]，令i++，j++，继续匹配下一个字符；如果 失配，
     即S[i+j]!=T[j]，令i不变，j=next[j]，(next[j]<=j-1)，
     即 模式 串T相对于原始串S向右移动了至少1位(移动的实   际位数j-next[j]>=1),

     Boyer-Moore算法是1977年，德克萨斯大学的Robert S. Boyer教授和J Strother Moore教授发明的字符串匹配算法，拥有在最坏情况下O(N)的时间复杂度，并且，在实践中，比KMP算法的实际效能高。BM算法不仅效率高，而且构思巧妙，容易理解。


     我的理解:看书之后:发现匹配的原理
          i              i
     abcabdfabcabx  abcabdfabcabx
     abcabx            abcabx
          j              j
     i不变,j到他的公共前缀 2

     */
    public static void main(String[] args) {

        //测试暴力匹配算法;
        String str1 = "guiguigui23749283daadfgagd";
        String str2 = "ui23";//7
        System.out.println(violenceMatch(str1, str2));//代价高,回溯多

        int[] next = kmpNext("ABCDABD");//0 1 2 0
        System.out.println("next=" + Arrays.toString(next));
        int[] next2 = kmpNext("ABCDABDABC");//
        System.out.println("next=" + Arrays.toString(next2));

        //测试kmp
        System.out.println(kmpSearch("BBC ABCDAB ABCDABCDABDE", "ABCDABD", next));//15
    }

    //1.暴力算法
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = str1.length();
        int s2Len = str2.length();

        int i = 0;//s1
        int j = 0;//s2
        while (i < s1Len && j < s2Len) {//下标不越界
            if (s1[i] == s2[j]) {//匹配成功
                i++;
                j++;
            } else {//匹配失败
                i = i - (j - 1);
                j = 0;
            }
        }
        //判断是否匹配成功
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }

    //Kmp算法
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i = 0,j=0; i < str1.length(); i++) {

            //需要不等的情况 str1.charAt(i) != str2.charAt(j)
            while (j>0 && str1.charAt(i) != str2.charAt(j)){//相等的情况,不等的情况
                j=next[j-1];
            }

            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){//找到了  //j=3 i=2  return 0;
                return i-j+1;
            }
        }

        return -1;
    }

    //获取一个字符串的部分匹配表 最长公共前后缀
    public static int[] kmpNext(String dest) {
        //创建一个数组next保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串是长度为1部分皮牌值就是0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j) 需要从net[j-1]获取新的j
            //直到我们发现 有 dest.CHarAt(i) == dest.charAt(j)  成立才退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {         //核心 公式 记忆
                j = next[j - 1];//这是kmp算法的一核心点
            }

            //当dest.charAt(i) == dest.charAt(j)  满足则部分匹配值+1
            if (dest.charAt(i) == dest.charAt(j)) {//部分匹配值就要加一
                j++;
            }
            next[i] = j;
        }

        return next;
    }


}
