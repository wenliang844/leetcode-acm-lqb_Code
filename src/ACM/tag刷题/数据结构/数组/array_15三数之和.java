package ACM.tag刷题.数据结构.数组;

import java.lang.reflect.Array;
import java.util.*;

public class array_15三数之和 {

    /****
     给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     注意：答案中不可以包含重复的三元组。
     示例 1：
     输入：nums = [-1,0,1,2,-1,-4]
     输出：[[-1,-1,2],[-1,0,1]]
     */
    //方法一:暴力解法 O(n**3) 315/318
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();//后期需要去重,所以在这里进行sort,然后操作
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if (!lists.contains(list)) //去重
                            lists.add(list);
                    }
                }
            }
        }


        return lists;
    }

    //方法二:暴力解法优化 O(n**2) 空间换时间 用list封装nums,然后最后一次循环直接查询list中是否有- num(i+j) 超时318/318
    public static List<List<Integer>> threeSum2(int[] nums) {
       /* List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {//用list或map将值,下标对应起来  list有重复的风险,用map
            temp.add(nums[i]);
        }
        */
        Arrays.sort(nums);//排序
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {// list有重复的风险,用map
            map.put(nums[i], i);
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            //if (nums[i] > 0) break;//剪枝
            for (int j = i + 1; j < nums.length - 1; j++) {
                //for (int k = j + 1; k < nums.length; k++) {
                Integer threeIndex = map.get(-(nums[i] + nums[j]));
                if (threeIndex != null && threeIndex > j) {
                    List<Integer> list = new ArrayList<>();//后期需要去重,所以在这里进行sort,然后操作
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[threeIndex]);
                    Collections.sort(list);
                    if (!lists.contains(list)) //去重
                        lists.add(list);
                }
                //}
            }
        }


        return lists;
    }

    //方法三:再次降维 变成一重循环+双指针  5 13
    public static List<List<Integer>> threeSum3(int[] nums) {
       /* List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {//用list或map将值,下标对应起来  list有重复的风险,用map
            temp.add(nums[i]);
        }
        */
        Arrays.sort(nums);//排序
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {// list有重复的风险,用map
            map.put(nums[i], i);
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            //采用jk双指针,j从i+1出发,k从len-1出发, 目标是-nums[i]
            int target = -nums[i];//目标值
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] > target) {//大了,小一点呗
                    k--;
                } else if (nums[j] + nums[k] < target) {//小了
                    j++;
                } else {
                    //find
                    //Integer threeIndex = map.get(-(nums[i] + nums[j]));
                    //if (threeIndex != null && threeIndex > j) {
                    List<Integer> list = new ArrayList<>();//后期需要去重,所以在这里进行sort,然后操作
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    Collections.sort(list);
                    if (!lists.contains(list)) //去重
                        lists.add(list);
                    //严格按照循序来的,不用去重 也有可能要去重,拭目以待

                    // 去除临近相同的元素 会解答出错,还是要去重
                    /*while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;*/
                    //break;
                    j++;
                    k--;
                }
            }
        }
        //if (nums[i] > 0) break;//剪枝
        //for (int j = i + 1; j < nums.length - 1; j++) {
        //for (int k = j + 1; k < nums.length; k++) {
                /*Integer threeIndex = map.get(-(nums[i] + nums[j]));
                if (threeIndex != null && threeIndex > j) {
                    List<Integer> list = new ArrayList<>();//后期需要去重,所以在这里进行sort,然后操作
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[threeIndex]);
                    Collections.sort(list);
                    if (!lists.contains(list)) //去重
                        lists.add(list);
                }*/
        //}
        //}
        //}


        return lists;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum3(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{1, 0, -1}));
        System.out.println(threeSum3(new int[]{1, 0, -1}));
        System.out.println(threeSum(new int[]{1, 2, -2, -1}));
        System.out.println(threeSum3(new int[]{1, 2, -2, -1}));

        //System.out.println("在这里print一个字符:"+"我叫陈文亮,alt+shift可以编辑多排文字 $");
        //System.out.println("在这里print一个字符:"+"我叫陈文亮,alt+shift可以编辑多排文字 $");
        //System.out.println("在这里print一个字符:"+"我叫陈文亮,alt+shift可以编辑多排文字 $");
        //System.out.println("在这里print一个字符:"+"我叫陈文亮,alt+shift可以编辑多排文字 $");
        //System.out.println("在这里print一个字符:"+"我叫陈文亮,alt+shift可以编辑多排文字 $");
        //System.out.println("在这里print一个字符:"+"我叫陈文亮,alt+shift可以编辑多排文字 $");
        //System.out.println("在这里print一个字符:"+"我叫陈文亮,alt+shift可以编辑多排文字 $");


    }
}
