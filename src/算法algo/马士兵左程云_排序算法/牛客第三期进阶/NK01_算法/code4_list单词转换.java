package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

import java.util.ArrayList;
import java.util.List;

public class code4_list单词转换 {
    /***
     3. 给两个单词:begin endWord  词典list类型
     找到所有从beginWord 变endWord的最短转换路径
     1.一次变一个单词
     2.每一次转换word一定要在list中
     3.初始时list中没有beginword这个词
     hit -> cog
     hot dot lot log cog

     return:
     hit hot dot dog cog
     hit hot lot log cog
     1.返回不存在路径返回空链表
     2.同长度
     3.小写,无重复,begin end 都不是空或null
     */

    //方法一:用过了就删系列
    public static List<List<String>> listTranWord(String beginWord, String endWord, List<String> list) {
        List<List<String>> lists = new ArrayList<>();

        //找到 hit的相同两个字符的,list删除这个单词,list接收,hit=这个单词,循环,直到=cog这个单词,结束
        List<String> minList = new ArrayList<>();
        minList.add(beginWord);
        while (true) {
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                int count = 0;//不相等的个数不能超过1
                for (int j = 0; j < s.length(); j++) {
                    if (beginWord.charAt(j) != s.charAt(j)) {
                        count++;
                    }
                    if (count > 1) {
                        //flag = false;
                        break;
                    }
                }

                if (count <= 1) {//不大于1,则是合格的下一个单词
                    beginWord = s;
                    minList.add(s);
                    list.remove(s);
                }

                if (beginWord.equals(endWord)) {
                    flag = true;
                    break;
                }
            }

            if (flag) break;

        }

        System.out.println(minList);
        //如果有三条隔壁的是只有一个字母一样的,那么删除中间者
        for (int i = 0; i < minList.size() - 2; i++) {
            int count = 0;
            String s = minList.get(i);
            String s2 = minList.get(i + 1);
            String s3 = minList.get(i + 2);
            for (int j = 0; j < s.length(); j++) {
                if (s2.charAt(j) != s.charAt(j) || s2.charAt(j) != s3.charAt(j)) {
                    count++;
                }
                if (count > 1) {
                    //flag = false;
                    break;
                }
            }

            if (count <= 1) {//不大于1,则是可以一拆为二的单词
                minList.remove(s2);//者删除中间者
            }
        }
        lists.add(minList);
        return lists;
    }

    /* 宽度优先遍历:找到距离进的
           hit 变一个字符可得到的hot 是邻居 生成
           hit value{hot}
           hot value{dot,lot}
           dot {dog}
           dog {cog}
           */
    public static List<List<String>> listTranWord2(String beginWord, String endWord, List<String> list) {


        return null;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(listTranWord("hit", "cog", list));



        //打印所有路径
    }
}
