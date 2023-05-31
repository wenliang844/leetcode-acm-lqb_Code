package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 陈文亮
 * @date 2023/4/19 15:57
 */
public class day43_1043分隔数组以得到最大和 {

    private static final AtomicInteger whichService = new AtomicInteger(-1);

    public static void main(String[] args) {

        System.out.println(whichService.incrementAndGet());
        System.out.println(whichService.get());
        //System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));//84
        //System.out.println(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));//83
        //System.out.println(maxSumAfterPartitioning(new int[]{10,9,3,2}, 2));//30  错误
        //1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3
        //1, 7, 7, 7, 7, 9, 9, 9, 9, 9, 9 29+54=
        //4, 4, 7, 7, 7, 7, 6, 9, 9, 9, 9 12+28+36=


        //1, 15, 7, 9, 2, 5, 10


        //10,9,3,2
        //


    }

    /*
    方法一：动态规划
    思路与算法

    我们需要将 arr\textit{arr}arr 分割成若干个子数组，每个子数组的长度都不超过 kkk。分割后每个元素都将变成其所属子数组中的最大值。现考虑如何使数组和最大。

    我们很难同时分割所有元素，如果能一次只考虑分割一组，然后利用之前分割得到的信息，任务就会变得简单。试想当前枚举到了 iii，我们把 iii 当做这一组的末尾，然后在 [i−k,i−1][i - k, i - 1][i−k,i−1] 的范围内枚举 jjj，[j+1,i][j + 1, i][j+1,i] 这一段可以当做新的一组。这时我们需要利用以 jjj 为结尾分割的最大和，可以发现如果将这个问题的答案提前计算并存储下来，以 iii 为结尾的问题就可以迎刃而解。

    具体地，我们设 d[i]d[i]d[i] 为以 iii 结尾分割的最大和，求解时倒序枚举 j (j∈[i−k,i−1])j ~(j \in [i - k, i - 1])j (j∈[i−k,i−1])，那么转移方程有：

    d[i]=max⁡{d[j]+maxValue×(i−j)}d[i] = \max\{d[j] + \textit{maxValue} \times (i - j)\}
    d[i]=max{d[j]+maxValue×(i−j)}
    其中 maxValue=max⁡{arr[j+1],⋯ ,arr[i]}\textit{maxValue} = \max\{arr[j+1], \cdots, arr[i]\}maxValue=max{arr[j+1],⋯,arr[i]}。

    答案为 d[n]d[n]d[n]，nnn是 arr\textit{arr}arr 的长度。
     */

    public int maxSumAfterPartitioning2(int[] arr, int k) {
        int n = arr.length;
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                if (j > 0) {
                    maxValue = Math.max(maxValue, arr[j - 1]);
                }
            }
        }
        return d[n];
    }


    //最大值周边辐射方法， 周边更小的优先        有特殊情况
    public static int maxSumAfterPartitioning(int[] arr, int k) {

        //System.out.println(Arrays.toString(arr));
        Map<Integer, List<Integer>> indexMap = new IdentityHashMap<>();
        int length = arr.length;
        int[] sortArr = new int[length];
        int[] record = new int[length];
        for (int i = 0; i < length; i++) {
            if (indexMap.containsKey(arr[i])) {
                indexMap.get(arr[i]).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                indexMap.put(arr[i], temp);
            }
            sortArr[i] = arr[i];
        }

        Arrays.sort(sortArr);
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1 && sortArr[i] == sortArr[i + 1]) {
                continue;
            }
            List<Integer> list = indexMap.get(sortArr[i]);
            for (Integer index : list) {

                if (record[index] == 1) {
                    continue;
                }

                record[index] = 1;

                int temp = k;
                int left = index - 1;
                int right = index + 1;
                while (temp-- > 1) {
                    if (left >= 0 && right < length) {
                        if (arr[left] < arr[right] && record[left] == 0 && arr[left] < arr[index]) {
                            record[left] = 1;
                            arr[left] = arr[index];
                            left--;
                        } else if (arr[right] < arr[left] && record[right] == 0 && arr[right] < arr[index]) {
                            record[right] = 1;
                            arr[right] = arr[index];
                            right++;
                        }
                    } else if (left < 0 && record[right] == 0 && arr[right] < arr[index]) {
                        record[right] = 1;
                        arr[right] = arr[index];
                        right++;
                    } else if (right >= length && record[left] == 0 && arr[left] < arr[index]) {
                        record[left] = 1;
                        arr[left] = arr[index];
                        left--;
                    }
                }
            }
        }

        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(record));
        //System.out.println(Arrays.toString(sortArr));
        //System.out.println(indexMap);
        int total = 0;
        for (int i = 0; i < length; i++) {
            total += arr[i];
        }


        return total;
    }
}
