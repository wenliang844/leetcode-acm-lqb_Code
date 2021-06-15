package ACM.leecode周赛.第241场周赛;

import java.util.*;

public class lee3_5761找出和为指定值的下标对 {
    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        System.out.println(findSumPairs.count(7));  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
        findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
        System.out.println(findSumPairs.count(8));  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
        System.out.println(findSumPairs.count(4));  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
        findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
        System.out.println(findSumPairs.count(7));  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
    }


    //将num2放入哈希表// -->100/100
    static class FindSumPairs {

        int[] nums1;
        int[] nums2;
        //int[] nums2temp;
        Map<Integer, Integer> map = new HashMap<>();
        //Map<Integer,Integer> map2 = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            //map记录nums1的数目
            for (int i = 0; i < nums2.length; i++) {
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
            }
            //nums2temp = new int[nums2.length];
            //System.arraycopy(nums2,0,nums2temp,0,nums2.length);
            //Arrays.sort(nums2temp);
        }

        //如果排序的话,index会变化,所以需要另外一个临时数组来排序
        public void add(int index, int val) {
            //调整,将原来的-- 现在的++
            map.put(nums2[index], map.get(nums2[index]) - 1);
            nums2[index] += val;
            map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
        }

        //满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目
        public int count(int tot) {
            //暴力破解
            //优化 :1.map  2.相同的数字查询直接+  3.排序后,超过tot的数字不用计算
            //Arrays.sort(nums2);
            //System.out.println(priorityQueue);

            int count = 0;
            /*for (int i = 0; i < nums2.length; i++) {
             *//* if (nums2temp[i]>=tot){
                    break;
                }*//*
               if (nums2[i]<tot){
                   count += map.getOrDefault(tot-nums2[i],0);
               }
            }*/
            for (int i = 0; i < nums1.length; i++) {
                   count += map.getOrDefault(tot-nums1[i],0);
            }

            return count;
        }
    }


    //将num1放入哈希表 -->超时
    static class FindSumPairs1 {

        int[] nums1;
        int[] nums2;
        //int[] nums2temp;
        Map<Integer, Integer> map = new HashMap<>();
        //Map<Integer,Integer> map2 = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return nums2[integer] - nums2[t1];
            }
        });

        public FindSumPairs1(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            //map记录nums1的数目
            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }
            for (int i = 0; i < nums2.length; i++) {
                priorityQueue.add(i);
            }
            //nums2temp = new int[nums2.length];
            //System.arraycopy(nums2,0,nums2temp,0,nums2.length);
            //Arrays.sort(nums2temp);
        }

        //如果排序的话,index会变化,所以需要另外一个临时数组来排序
        public void add(int index, int val) {
            nums2[index] += val;
            //System.arraycopy(nums2,0,nums2temp,0,nums2.length);
            //Arrays.sort(nums2temp);
            //调整更新
            priorityQueue.remove(index);
            priorityQueue.add(index);
        }

        //满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目
        public int count(int tot) {
            //暴力破解
            //优化 :1.map  2.相同的数字查询直接+  3.排序后,超过tot的数字不用计算
            //Arrays.sort(nums2);
            //System.out.println(priorityQueue);

            int count = 0;
            /*for (int i = 0; i < nums2.length; i++) {
             *//* if (nums2temp[i]>=tot){
                    break;
                }*//*
               if (nums2[i]<tot){
                   count += map.getOrDefault(tot-nums2[i],0);
               }
            }*/
            for (Integer integer : priorityQueue) {
                if (nums2[integer] > tot) {
                    break;
                }
                count += map.getOrDefault(tot - nums2[integer], 0);
            }
            return count;
        }
    }
}
