package ACM.leecode周赛.第52场双周赛;

import java.util.Arrays;
import java.util.Comparator;

public class lee1_5742将句子排序 {
    /****
     一个 句子 指的是一个序列的单词用单个空格连接起来，且开头和结尾没有任何空格。每个单词都只包含小写或大写英文字母。
     我们可以给一个句子添加 从 1 开始的单词位置索引 ，并且将句子中所有单词 打乱顺序 。
     比方说，句子 "This is a sentence" 可以被打乱顺序得到 "sentence4 a3 is2 This1" 或者 "is2 sentence4 This1 a3" 。
     给你一个 打乱顺序 的句子 s ，它包含的单词不超过 9 个，请你重新构造并得到原本顺序的句子。
     示例 1：
     输入：s = "is2 sentence4 This1 a3"
     输出："This is a sentence"
     解释：将 s 中的单词按照初始位置排序，得到 "This1 is2 a3 senten
     */
    public static String sortSentence(String s) {
        String[] strings = s.split(" ");
        int len = strings.length;
        int[][] indexs = new int[len][2];

        //拿到索引,进行封装到一个二维数组
        for (int i = 0; i < len; i++) {
            indexs[i][1] = i;
            indexs[i][0] = strings[i].charAt(strings[i].length() - 1) - '0';
        }

        //根据索引排序
        Arrays.sort(indexs, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
       /* for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(indexs[i]));
        }*/

        //按照索引进行String封装
        String res = "";
        for (int i = 0; i < len; i++) {
            String temp = strings[indexs[i][1]];
            res += temp.substring(0, temp.length() - 1)+" ";
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
}
