package ACM.每日一题leecode.day100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class day106_368最大整除子集 {
    /***
     给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
     answer[i] % answer[j] == 0 ，或
     answer[j] % answer[i] == 0
     如果存在多个有效解子集，返回其中任何一个均可。
     示例 1：
     输入：nums = [1,2,3]
     输出：[1,2]
     解释：[1,3] 也会被视为正确答案。
     */
    //方法一:暴力法 一个一个尝试
    public static List<Integer> largestDivisibleSubset(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        //int visited[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //假如第一个元素是nums[i],有多少个数量
            //用list,如果之前存在了就不用找了,如果是不存在的就创建一个list进去
            int n = nums[i];
            boolean flag = true;
            for (List<Integer> integers : lists) {
                if (integers.contains(n)){
                    flag = false;
                    break;
                }
            }

            if (flag){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(n);
                for (int j = 0; j < nums.length; j++) {
                    //创建一个list,满足两个条件的加入list

                    //当前数需要和之前的所有进行比较

                   /* if (nums[j]%n==0 || n%nums[j]==0){
                        list.add(nums[j]);
                    }*/

                   int thisnum = nums[j];
                   if (thisnum == n){
                       continue;
                   }
                   boolean isnum = true;
                    for (Integer integer : list) {
                        if (thisnum%integer!=0 && integer%thisnum!=0){
                            isnum = false;
                            break;
                        }
                    }
                    if (isnum){
                        list.add(thisnum);
                    }
                }
                lists.add(list);
            }




        }
        System.out.println(lists);

        int resIndes = 0;
        for (int i = 1; i < lists.size(); i++){
            if (lists.get(i).size()>lists.get(resIndes).size()){
                resIndes = i;
            }
        }
        return lists.get(resIndes);
    }
    public static List<Integer> largestDivisibleSubset2(int[] nums) {


        int resIndes = 0;//维持一个最长的下标,只要最长的list中没有这个值,就需要查找这个值,然后更新最长的下标
        //List<List<Integer>> lists = new ArrayList<>();
        //int visited[] = new int[nums.length];

        //现找好第一个
        int temp = nums[0];
        ArrayList<Integer> templist = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]%temp==0 || temp%nums[i]==0){
                templist.add(nums[i]);
            }
        }
        //lists.add(templist);


        for (int i = 1; i < nums.length; i++) {
            //假如第一个元素是nums[i],有多少个数量
            //用list,如果之前存在了就不用找了,如果是不存在的就创建一个list进去
            int n = nums[i];
            /*boolean flag = true;
            for (List<Integer> integers : lists) {
                if (integers.contains(n)){
                    flag = false;
                    break;
                }
            }*/

            if (!templist.contains(n)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(n);
                for (int j = 0; j < nums.length; j++) {
                    //创建一个list,满足两个条件的加入list

                    //当前数需要和之前的所有进行比较

                   /* if (nums[j]%n==0 || n%nums[j]==0){
                        list.add(nums[j]);
                    }*/

                   int thisnum = nums[j];
                   if (thisnum == n){
                       continue;
                   }
                   boolean isnum = true;
                    for (Integer integer : list) {
                        if (thisnum%integer!=0 && integer%thisnum!=0){
                            isnum = false;
                            break;
                        }
                    }
                    if (isnum){
                        list.add(thisnum);
                    }
                }
                if (list.size()>templist.size()){
                    templist=list;
                }
                //lists.add(list);
            }




      }

        for (int i = nums.length-1; i>=1; i--) {
            //假如第一个元素是nums[i],有多少个数量
            //用list,如果之前存在了就不用找了,如果是不存在的就创建一个list进去
            int n = nums[i];
            /*boolean flag = true;
            for (List<Integer> integers : lists) {
                if (integers.contains(n)){
                    flag = false;
                    break;
                }
            }*/

            if (!templist.contains(n)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(n);
                for (int j = nums.length-1; j >=0; j--) {
                    //创建一个list,满足两个条件的加入list

                    //当前数需要和之前的所有进行比较

                   /* if (nums[j]%n==0 || n%nums[j]==0){
                        list.add(nums[j]);
                    }*/

                   int thisnum = nums[j];
                   if (thisnum == n){
                       continue;
                   }
                   boolean isnum = true;
                    for (Integer integer : list) {
                        if (thisnum%integer!=0 && integer%thisnum!=0){
                            isnum = false;
                            break;
                        }
                    }
                    if (isnum){
                        list.add(thisnum);
                    }
                }
                if (list.size()>templist.size()){
                    templist=list;
                }
                //lists.add(list);
            }




      }
        System.out.println(templist);

       /* int resIndes = 0;
        for (int i = 1; i < lists.size(); i++){
            if (lists.get(i).size()>lists.get(resIndes).size()){
                resIndes = i;
            }
        }*/
        return templist;
    }

    //想法:从两头分别遍历,取最短
    public static List<Integer> largestDivisibleSubset3(int[] nums) {
        List<Integer> list = largestDivisibleSubset(nums);

        return null;
    }

    //动态规划
    public static List<Integer> largestDivisibleSubset4(int[] nums) {
        /***
         最小整数的约数,和最大整数的倍数可以加入最多整除子集
        从0开始,枚举nums,统计前面可以被整除的数字个数

         然后从后面开始,从maxSize开始,选可以整除maxsize位置的maxsize-1位置的值加入结果集
         */

        int maxSize =  1;
        int maxValue = 1;
        int[] maxsizes = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(maxsizes,1);
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            //int count = 1;
            for (int j = 0; j < i; j++) {
                if (n%nums[j]==0){
                    maxsizes[i]=Math.max(maxsizes[i],maxsizes[j]+1);
                }
            }
           // maxsizes[i] = count;
            if (maxsizes[i]>maxSize){
                maxSize=maxsizes[i];
                maxValue = nums[i];
            }
        }
        System.out.println(Arrays.toString(maxsizes));

        List<Integer> list = new ArrayList<>();
        if (maxSize == 1) {
            list.add(nums[0]);
            return list;
        }

        //进行和最大值匹配
        for (int i = nums.length-1; i >=0 ; i--) {
            if (maxsizes[i] == maxSize && maxValue%nums[i]==0){
                list.add(nums[i]);
                maxSize--;
                maxValue = nums[i];
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset4(new int[]{1, 2, 3}));
        System.out.println(largestDivisibleSubset4(new int[]{1, 2, 4,8}));
        System.out.println(largestDivisibleSubset4(new int[]{5,9,18,54,108,540,90,180,360,720}));
        System.out.println(largestDivisibleSubset4(new int[]{2,4,7,8,9,12,16,18}));
        System.out.println(largestDivisibleSubset4(new int[]{1}));
    }
}
