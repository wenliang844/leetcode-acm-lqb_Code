package ACM.leecode周赛.第48场双周赛;

import java.util.Arrays;

public class lee1_5693字符串中第二大的数字 {
    /***
     给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，
     如果不存在第二大的数字，请你返回 -1 。
     混合字符串 由小写英文字母和数字组成。
     示例 1：
     输入：s = "dfa12321afd"
     输出：2
     解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
     */

    public static int test1(String s){

        /**
         思路:
         1.转换为数组
         2.是数字就留下,排序取第二个
         定义两个变量  一个first 一个second
            1.大于first  则second=(second,first)
            2.小于   second = max(second,num)
         */
        int first = -1;
        int second = -1;
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            //System.out.println(split[i]);
            if (split[i].charAt(0)>='0' && split[i].charAt(0)<='9'){
                int temp = Integer.parseInt(split[i]);
                //System.out.println(temp);
                if (temp>first){
                    second=first;
                    first=temp;
                }else if (temp<first){
                    second = Math.max(second,temp);
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(test1("dfa12321afd"));
        System.out.println(test1("ab1111"));

    }
}
