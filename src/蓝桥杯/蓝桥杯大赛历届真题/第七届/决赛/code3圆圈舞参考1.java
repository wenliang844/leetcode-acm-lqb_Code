package 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛;

import java.util.LinkedList;
import java.util.Scanner;

public class code3圆圈舞参考1 {
    //	存放各个数的情况，[n][0]代表欢乐值,[n][1]代表感动值,[n][2]代表所在圈
    static int[][] arr;
    //	保存所有圈的情况
    static LinkedList<LinkedList<Integer>> lists = new LinkedList<LinkedList<Integer>>();
    public static void main(String[] args) {
        /*
         * 大致思路：
         * ①链表lists存放所有圈，初始有一个list，值为1-9
         * 	10个数，数组arr[n+1][3]存放欢乐值和感动值，以及所在圈数
         * ②获取m行
         * 	第一个数为1，先变圈
         * 	第一个数为2，改变欢乐值
         * 	第一个数为3，改变感动值
         * 执行完上一次操作后进行计算欢乐能量
         *
         * ③如何变圈，有两个参数(i,j)：
         * 	获得arr[i][2]与arr[j][2]，分别为ii，jj为所在圈
         * 	当ii==jj，即两个数在同一个圈
         * 		一直挪动第一个到最后，直到第一个等于i，然后直到遇见j之前，将所有的数放到新的链表里面，并加入所有圈的lists
         * 	当ii!=jj，即两个数不在同一个圈
         * 		将其中一个，例如含有j的链表B，一直挪动第一个到最后，直到第一个等于j，将此时的链表B插入到链表A（含有i的链表）
         * 		中i之后
         * ④计算欢乐能量
         * 	遍历lists中的list
         * 	记录list的大小size，操作size次
         * 	移动第一个数到链表末尾
         * 	循环链表中的[1,size-1]区间中的数
         * 	欢乐能量+=(size-p)*(当前位置的欢乐值)*(正在遍历的位置的感动值) p=当前的索引
         * 	返回欢乐能量
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n + 1][3];
        LinkedList<Integer> initList = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            // 0为欢乐值 1为感动值
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            initList.add(i);
        }
        // 添加初始链表
        lists.add(initList);
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int k = scanner.nextInt(), p = scanner.nextInt(), q = scanner.nextInt();
            if (k == 1) {
                // 变换队形
                change(p, q);
            } else if (k == 2) {
                // 改变欢乐值
                arr[p][0] = q;
            } else if (k == 3) {
                // 改变感动值
                arr[p][1] = q;
            }
            // 计算欢乐能量
            caculate();
        }
    }

    private static void caculate() {
        long sum = 0;
        // 遍历lists中的list
        for (LinkedList<Integer> list : lists) {
            int size = list.size();
            int temp = size;
            // 记录list的大小size，操作size
            while (temp-- > 0) {
                // 移动第一个数到链表末尾
                list.add(list.remove());
                // 循环链表中的[1,size-1]区间中的数
                for (int i = 1; i < size; i++) {
                    // 欢乐能量+=(size-当前索引)*(当前位置的欢乐值)*(正在遍历的位置的感动值)
                    sum = (sum + (size - i) * arr[list.get(0)][0] * arr[list.get(i)][1]) % 1000000007;
                }
            }
        }
        // 输出结果
        System.out.println(sum);
    }

    private static void change(int i, int j) {
        // 记录i所在的圈
        int ii = arr[i][2];
        // 记录j所在的圈
        int jj = arr[j][2];
        if (ii == jj) {
            // 如果两个数字在同一个圈内

            LinkedList<Integer> linkedList = lists.get(ii);
            // 一直挪动第一个到最后，直到第一个等于i
            while (linkedList.getFirst() != i) {
                linkedList.add(linkedList.remove());
            }
            // 然后直到遇见j之前，将所有的数放到新的链表里面
            LinkedList<Integer> newLinkedList = new LinkedList<Integer>();
            while (linkedList.get(1) != j) {
                newLinkedList.add(linkedList.remove(1));
            }
            // 如果新链表不为空，将其放入所有圈的lists
            if (!newLinkedList.isEmpty()) {
                lists.add(newLinkedList);
                for (Integer integer : newLinkedList) {
                    // 更新圈数
                    arr[integer][2] = lists.size() - 1;
                }
            }
        } else {
            // 如果不在同一个圈内
            LinkedList<Integer> AList = lists.get(ii);
            LinkedList<Integer> BList = lists.get(jj);
            // 将其中一个，例如含有j的链表B，一直挪动第一个到最后，直到第一个等于j
            while (BList.getFirst() != j) {
                BList.add(BList.remove());
            }
            // 将此时的链表B插入到链表A（含有i的链表）中i之后
            while (AList.getFirst() != i) {
                AList.add(AList.remove());
            }
            // 移除i
            AList.add(AList.remove());
            for (Integer integer : BList) {
                arr[integer][2] = ii;
            }
            AList.addAll(0, BList);
            // 去掉多余的链表
            lists.remove(BList);
        }
    }
}

