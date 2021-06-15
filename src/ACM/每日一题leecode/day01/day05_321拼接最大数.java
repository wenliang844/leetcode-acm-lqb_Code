package ACM.每日一题leecode.day01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。

示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
示例 2:

输入:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
输出:
[6, 7, 6, 0, 4]
 */
public class day05_321拼接最大数 {
    public static void printNums(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printNums(maxNumber4(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5));
        printNums(maxNumber4(new int[]{6, 7}, new int[]{6, 0, 4}, 5));
        //printNums(maxNumber2(new int[]{8,9}, new int[]{3,9}, 3));
        //printNums(maxNumber2(new int[]{6,7}, new int[]{6,0,4}, 5));

    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int i = 0;
        int j = 0;
        int i1 = 0;
        int j1 = 0;
        int temp = i;
        int maxNum = 0;
        int[] ints = new int[k];
        int k1, k2;
        for (int p = 0; p < k; p++) {
            /*int k1 = (nums2.length-j)+(nums1.length-i)-(k-p )< (nums2.length-j)+(nums1.length-i)?(nums2.length-j)+(nums1.length-i)-(k-p)+i:nums1.length;
            int k2 = (nums2.length-j)+(nums1.length-i)-(k-p )< (nums2.length-j)+(nums1.length-i)?(nums2.length-j)+(nums1.length-i)-(k-p)+j:nums2.length;*/
            k1 = nums2.length - j >= k - p - 1 ? nums1.length : nums1.length - (k - p - 1 - (nums2.length - j));
            k2 = nums1.length - i >= k - p - 1 ? nums2.length : nums2.length - (k - p - 1 - (nums1.length - j));
            System.out.println(k1 + "---" + k2);
            if (i < nums1.length) {
                for (i1 = i; i1 < k1; i1++) {
                    if (nums1[i1] > maxNum) {
                        maxNum = nums1[i1];
                        temp = i;
                        i = i1 + 1;
                    }

                }
            }
            if (j < nums2.length) {
                for (j1 = j; j1 < k2; j1++) {
                    if (nums2[j1] > maxNum) {
                        maxNum = nums2[j1];
                        j = j1 + 1;
                        i = temp;
                    }
                }
            }


            ints[p] = maxNum;
            maxNum = 0;
        }
        return ints;
    }

    //71 / 102 个通过测试用例
    public static int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        /****
         思路:
         在nums1和nums2中截取掉k个字符后,
         nums1截取if(s2-k)<0  s1-(k-s2)位 比较 0到s1-(k-s2)
         nums2  0 到 (if(s2-k)<0) ->  s2-(k-s1)
         比较nums1,nums2前面的最大值
         找到最大值result.add  i指针指向这个最大值
         以相同的方法继续比较

         1.把两个nums转化成list
         2.每次比较完后 最大的入result 保存好最后的坐标如果是i下标得到list1大 清除j的坐标为0 listremove相应的坐标

         //注意 从哪里删掉了 下一轮就要从哪里开始
         问题:
         在数字相同的情况下,不知道选哪个数字   写一个方法 帮助选数字把 gt方法
         解决:gt(list1,list2,i1,j1)  选字典序大的
         if
         list1字典序大,选list1  i1
         list2字大,选list2  j1
         */

        int i5 = 0, j5 = 0;
        int[] result = new int[k];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            list2.add(nums2[i]);
        }
        System.out.println("这是list1和list2" + list1);
        System.out.println(list2);

        int qq = k;
        for (int q = 0; q < k; q++) {
            //对第一个list进行求最大值

            int maxNum = 0;//本轮最大的值
            int i1 = -1, j1 = -1; //保存对应下标 以备lsit.remove
            int len1 = list1.size();
            //int i=0;
            //int i3 =0;
            if ((qq - list2.size()) > 0) {
                len1 = list1.size() - (qq - list2.size()) + 1;
            }

            int i;
            for (i = 0; i < len1; i++) {
                if (list1.get(i) > maxNum) {
                    maxNum = list1.get(i);
                    i1 = i;
                }
            }

            int len2 = list2.size();
            if ((qq - list1.size() > 0)) {
                len2 = list2.size() - (qq - list1.size()) + 1;
            }

            int j;
            for (j = 0; j < len2; j++) {//如果在j这里找到了更大的值,就更新j1为j  把i1清除
                if (list2.get(j) > maxNum) {
                    maxNum = list2.get(j);
                    j1 = j;
                    i1 = -1;
                } else if (list2.get(j) == maxNum) {
                    if (gt(list1, list2, i1)) {
                        maxNum = list2.get(j);
                        j1 = j;
                        i1 = -1;
                    }
                }
            }


            result[q] = maxNum;
            //对maxNum所在的数组进行清理
            if (i1 != -1) {
                System.out.println("本轮删除的是第一个list下标" + i1 + "-" + list1.get(i1));

                //list1.remove(i1);
                for (int l = 0; l <= i1; l++) {
                    list1.remove(0);
                }
                i5 = i1;//下标更新的问题:  取的是最后一个数呢?进行判断 如果>=len  直接赋值为len
            } else {
                //System.out.println("本轮删除的是第一个list下标"+j1+"-"+list2.get(j1));
                //list2.remove(j1);
                for (int l = 0; l <= j1; l++) {
                    list2.remove(0);
                }
                j5 = j1;
            }
            i1 = j1 = -1;
            System.out.println("本轮取到的最大值:" + maxNum + "-" + len1 + "-" + len2 + "下标更新为:list1:" + i5 + "list2:" + j5 + "数组变成了" + list1 + "==" + list2 + "剩余取个数" + (k - q - 1));
            maxNum = 0;//最大值从新变成0  准备下一轮

            /***
             每次找完后,相应的list直接把前面的都删除 下标每次都从0开始  待取的长度每次都-1
             */
            qq--;
        }

        return result;
    }

    //判断字典序
    public static boolean gt(List<Integer> list1, List<Integer> list2, int i1) {
        System.out.println("进入比较数组--------------------------------------------------");
        System.out.println(list1);
        System.out.println(list2);
        for (int i = 0; i < i1; i++) {
            if (list1.get(i) > list2.get(i)) {
                return true;
            } else if (list1.get(i) == list2.get(i)) {
                continue;
            } else {
                return false;
            }
        }

        return false;
    }

    public static int[] maxNumber3(int[] nums1, int[] nums2, int k) {
        /***
         得到最大数的过程分成两步，
         第一步是分别从两个数组中得到指定长度的最大子序列，
         第二步是将两个最大子序列合并。
         */

        //将nums1-i  nums2-j 中各取出一段最长序列  并合并 比较字典序
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            maxList.add(0);
        }
        for (int i = 0; i < k; i++) {
            int j = k - i;
            List<Integer> li1 = getMaxLengthNum(nums1, i);
            List<Integer> li2 = getMaxLengthNum(nums2, j);
            List<Integer> list = twoToOne(li1, li2);
            System.out.println(li1 + "-" + li2 + "-" + list);
            maxList = getMaxList(list, maxList);

        }

        int[] nums = new int[maxList.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = maxList.get(i);
        }

        return nums;
    }


    //从一个nums中获取长度为k的最长子序列  并有序   这个序列要顺序的
    public static List<Integer> getMaxLengthNum(int[] nums, int k) {
        int[] ints = Arrays.copyOf(nums, nums.length);//数组会改变值  copy一个数组使用
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int maxNum = 0;
            int j1 = 0;
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > maxNum) {
                    maxNum = ints[j];
                    j1 = j;
                    //break;
                }
            }

            list.add(maxNum);
            ints[j1] = 0;
        }

        System.out.println("这是取号的list" + list);
        return list;
    }

    //将两个子序列合并成一个最长序列
    //9 8 5   6 3 1
    public static List<Integer> twoToOne(List<Integer> nums1, List<Integer> nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1.get(i) > nums2.get(j)) {
                list.add(nums1.get(i));
                i++;
            } else {
                list.add(nums2.get(j));
                j++;
            }
        }
        if (i < nums1.size()) {
            list.addAll(nums1);
        }
        if (j < nums2.size()) {
            list.addAll(nums2);
        }

        return list;
    }

    //返回字典序更大的那个
    public static List<Integer> getMaxList(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) > list2.get(i)) {
                return list1;
            } else if (list1.get(i) == list2.get(i)) {
                continue;
            } else {
                return list2;
            }
        }
        return list1;
    }

    public static int[] maxNumber4(int[] nums1, int[] nums2, int k) {
        /***
         得到最大数的过程分成两步，
         第一步是分别从两个数组中得到指定长度的最大子序列，
         第二步是将两个最大子序列合并。
         */

        //将nums1-i  nums2-j 中各取出一段最长序列  并合并 比较字典序
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            maxList.add(0);
        }
        int res[] = new int[k];
        int m = nums1.length, n = nums2.length;
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++){
       // for (int i = 0; i < k; i++) { //你的长度  不能超过字符已有长度呀
            int j = k - i;
            int[] ints1 = maxArr(nums1, i);
            int[] ints2 = maxArr(nums2, j);

            //合并ints1 ints2
            int[] merge = merge(ints1, ints2,k);

            if (gt(merge, 0, res, 0)) res = merge;

        }

        return res;
    }

    //取序列函数
    private static int[] maxArr(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && nums[i] > res[j - 1]) j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }

    //合并函数
    private static int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++)
            res[r] = gt(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return res;
    }

    //比较
    private static boolean gt(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    /*
     *//*
     假设数组一为[3,4,6,5]、数组二为[9,1,2,5,8,3]、k = 5;
     组合情况有0 + 5、1 + 4、2 + 3、3 + 2、4 + 1五种情况,就是从此五种情况取出组合最大的一种;
     Math.max(0, k - n)表示若数组二的元素个数 >= k,则数组一的元素个数可以从0开始取,否则在数组二的大小基础上补.
     *//*
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] arr = merge(maxArr(nums1, i), maxArr(nums2, k - i), k);
            if (gt(arr, 0, res, 0)) res = arr;
        }
        return res;
    }

    *//*
    假设选择了2 + 3的情况,分别从两个数组取出相应元素个数的最大组合，对数组一来说就是[6,5],对数组二来说是[9,8,3];
    n - i : 当前数组中,当前下标到结尾还有多少个元素;
    j : 当前数组中i之前有多少个数加入到最大组合中;
    n - i + j > k <=> n - i - 1 + j >= k : 当前下标的元素大于最大组合的末尾元素，就需要弹出,弹出后的元素减少,故j--,
    n - i(数组剩余元素) - 1(去掉最大组合末尾元素) + j(最大组合中剩余元素)时刻保持 >= k;
    if j < k : 先将最大组合填满再进行比较替换操作
     *//*
    private int[] maxArr(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && nums[i] > res[j-1]) j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }

    *//*
    假设数组一最大组合为[6,5],数组二最大组合为[9,8,3],进行双指针排序,排序后为[9,8,6,5,3]
     *//*
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++)
            res[r] = gt(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return res;
    }

    *//*
    比较两数组相应位置大小,相等就一直跳过,直到不相等就比较.
     *//*
    private boolean gt(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    */
}
