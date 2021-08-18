package 数据结构算法教程.java数据结构算法.第1节_算法基本;

public class 引例_字符串匹配暴力和KMP {
    /*
    给定一个字符串,判断另一个字符串在第一个字符串中吗,返回第一个位置
     */
    public static void main(String[] args) {
        //System.out.println(Brute_Force("aaazaaaaz", "az"));
        int[] next = new int["aaazaaaaz".length()];
        getnext(next,"aaazaaaaz");
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
    }

    //暴力解法 O(n*m)
    public static int Brute_Force(String str1,String str2){

        //假定两者相等  维持相等   只要有不相等就退出
        boolean flag = true;
        for (int i = 0; i < str1.length(); i++) {
            int k = i;
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(k)!=str2.charAt(j)){
                    flag = false;
                    break;
                }
                k++;
            }
            if (flag==true){
                return i;
            }
            flag = true;
        }

        return -1;
    }

    //KMP字符串匹配算法O(n+m)
    /*
    思想:
        1.跳过不可能成功的字符串比较
        2.
       KMP如何做到不需要回溯
       next的求解
       快速从一个子串中找到相同的串;
        1.主串和模式串前面有一段公共匹配的
        2.模式串有公共前后缀   取最长公共前后缀
            直接移动模式串 使原来的前缀 移到后缀的位置

            前后缀:找最长 且不长过串长
                直接前缀移到后缀
        next:只研究模式串就可以;
        放在一个数组里面
     */
    public static int KMP(String str1,String str2){


        return -1;
    }

    static void getnext(int next[],String s){
        int j=0,k=-1;
        next[0] = -1;
        while(j<s.length()-1){
            if (k==-1 || s.indexOf(j) == s.indexOf(k)){
                j++;
                k++;
                next[j]=k;
            }else {
                k=next[k];
            }
        }
    }
}
