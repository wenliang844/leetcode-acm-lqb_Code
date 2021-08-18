package ACM.每日一题leecode.day141;

import java.util.ArrayList;
import java.util.List;

public class day156_1239串联字符串的最大长度 {
    /***
     给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
     请返回所有可行解 s 中最长长度。
     示例 1：
     输入：arr = ["un","iq","ue"]
     输出：4
     解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4
     */
    public static List<String> arrToList(String [] arr) {
        List<String> list = new ArrayList<>();
        for (String string : arr) {
            list.add(string);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(maxLength(arrToList(new String[]{"un", "iq", "ue"})));//差点导错了包
        System.out.println(maxLength(arrToList(new String[]{"yy","bkhwmpbiisbldzknpm"})));//差点导错了包
        System.out.println(maxLength(arrToList(new String[]{"a", "abc", "d", "de", "def"})));//差点导错了包
    }

    //方法一:暴力解法
    public static int maxLength(List<String> arr) {



        int maxCount = 0;
        for (int i = 0; i < arr.size(); i++) {
            int count[] = new int[26];//0-25 a-z 1-26
            int tempCount = 0;
            for (int j = i; j < arr.size(); j++) {
                String s = arr.get(j);
                int thsiCount = 0;
                for (int k = 0; k < s.length(); k++) {
                    if (count[s.charAt(k) - 'a'] == 0) {
                        count[s.charAt(k) - 'a'] = 1;
                        thsiCount++;
                    } else {
                        thsiCount=0;//自己有重复的,收回这个字母,反悔系列 并且需要将count[]复位 并且需要是从大到小的排序状态
                        break;
                        //continue;
                    }
                }
                tempCount += thsiCount;
            }

            maxCount = Math.max(tempCount,maxCount);
        }
        return maxCount;
    }

    //回溯 背包问题

}
