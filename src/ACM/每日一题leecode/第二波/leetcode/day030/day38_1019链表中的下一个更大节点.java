package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈文亮
 * @date 2023/4/11 15:36
 */
public class day38_1019链表中的下一个更大节点 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextLargerNodes(new ListNode(2, new ListNode(7, new ListNode(4, new ListNode(3, new ListNode(5))))))));

    }

    public static int[] nextLargerNodes(ListNode head) {

        ListNode p = head;
        List<Integer> list = new ArrayList();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        int length = list.size();
        int[] res = new int[length];
//        int[][] indexs = new int[length][2];
//
//        for (int i = 0; i < length; i++) {
//            indexs[i][0] = list.get(i);
//            indexs[i][1] = i;
//        }
//        Arrays.sort(indexs,new Comparator<int[]>(){
//            @Override
//            public int compare(int[] a,int[] b){
//                // 当第一维相等时比较第二维的
//                    return a[0]-b[0];
//            }
//        });
//
//        for (int[] num : indexs) {
//            System.out.print(Arrays.toString(num));
//        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (list.get(j) > list.get(i)) {
                    res[i] = list.get(j);
                    break;
                }
            }
        }

        return res;
    }
}
