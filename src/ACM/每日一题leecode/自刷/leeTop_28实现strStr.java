package ACM.每日一题leecode.自刷;

public class leeTop_28实现strStr {
    /*****
     给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     示例 1:
     输入: haystack = "hello", needle = "ll"
     输出: 2
     示例 2:
     输入: haystack = "aaaaa", needle = "bba"
     输出: -1
     */
    //字符串匹配算法:1.暴力,直接匹配方法 14 99
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {//不相等的话,i需要回退
                i = i-j+1;
                j = 0;
            }
            if (j == needle.length()) {
                return i - j;
            }
        }

        return -1;
    }

    //方法二:内置api  100/89
    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    //方法三:kmp字符串匹配算法 10 29
    //Kmp算法
    public static int strStr3(String str1,String str2){
        if (str2.equals("")){
            return 0;
        }
        int[] next =kmpNext(str2);
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

    //获取一个字符串的部分匹配表
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

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("mississippi","issip"));

        System.out.println(strStr3("hello", "ll"));
        System.out.println(strStr3("aaaaa", "bba"));
        System.out.println(strStr3("", ""));
        System.out.println(strStr3("mississippi","issip"));

    }
}
