package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 陈文亮
 * @date 2022/12/20 11:30
 *
 * 很多时候是自己把问题想复杂了。对于该题 ，
 * 我把球分成全部1袋1个要多少次操作？
 * 和maxoperations比较一下是否可行？
 * 如果是一袋2个呢？ 操作次数肯定是减少的，
 * 但结果2更大。对于数据范围全部来一遍就是平方的算法，
 * 所以就会想到二分了，从1 到n， （n + 1） /2 个是否可行？
 * 如果可行试图找左边有没有更好的，不可行就往右找可行的。
 */
public class day025_1760袋子里最少数目的球 {
    public static void main(String[] args) {

        System.out.println(minimumSize(new int[]{9}, 2));
        //System.out.println(minimumSize(new int[]{2, 4, 8, 2}, 4));
        //System.out.println(minimumSize(new int[]{2, 1, 1, 2}, 4));
    }

    public static int minimumSize(int[] nums, int maxOperations) {

        List<Integer> list =  Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        while (maxOperations-->0){
            System.out.println("---list print----");
            System.out.println(list);
            System.out.println(list.get(list.size()-1));
            Integer integer = list.get(list.size() - 1);
            if (integer==1){
                break;
            }
            list.set(list.size()-1, integer/2);
            list.add(integer - integer/2);
            Collections.sort(list);
        }

        System.out.println("---list print----");
        System.out.println(list);
        System.out.println(list.get(list.size()-1));
        return list.get(list.size()-1);
    }
}
