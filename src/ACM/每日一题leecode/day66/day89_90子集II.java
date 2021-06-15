package ACM.每日一题leecode.day66;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class day89_90子集II {

    /**
     给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     */

    /**
     * 思路:用set 7 35
     * 这个题蛮有意思的，可以直接从后遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        //对每个数字进行先加1 再加list和23的组合
        ArrayList list = new ArrayList();
        //lists.add(list);//加一个[]空
        list.add(nums[0]);
        lists.add(list);
//        lists.add(list);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> temps = new ArrayList<List<Integer>>();
            temps.addAll(lists);
            //System.out.println(lists);
            //System.out.println(temps);
            for (int j = 0;j<temps.size();j++) {
                //System.out.println(temps.get(j));
                ArrayList temp = new ArrayList();
                temp.addAll(temps.get(j));
                temp.add(nums[i]);
                Collections.sort(temp);
                lists.add(temp);
            }
            ArrayList temp = new ArrayList();
            temp.add(nums[i]);
            lists.add(temp);

        }
        //System.out.println(lists);

        Set<List<Integer>> set = new HashSet<>();
        set.addAll(lists);
        //System.out.println(set);
        lists.clear();
        lists.addAll(set);
        //加一个空
        lists.add(new ArrayList<>());
        return lists;
    }

    //一开始就用set
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        Set<List<Integer>> lists = new TreeSet<>();

        //对每个数字进行先加1 再加list和23的组合
        ArrayList list = new ArrayList();
        //lists.add(list);//加一个[]空
        list.add(nums[0]);
        lists.add(list);
//        lists.add(list);
        for (int i = 1; i < nums.length; i++) {
            Set<List<Integer>> temps = new TreeSet<>();
            temps.addAll(lists);
            //System.out.println(lists);
            //System.out.println(temps);
            for (List<Integer> t : temps) {
                //System.out.println(temps.get(j));
                ArrayList temp = new ArrayList();
                temp.addAll(t);
                temp.add(nums[i]);
                Collections.sort(temp);
                lists.add(temp);
            }
            ArrayList temp = new ArrayList();
            temp.add(nums[i]);
            //Collections.sort(temp);
            lists.add(temp);

        }
        System.out.println(lists);

        //Set<List<Integer>> set = new HashSet<>();
        //set.addAll(lists);
        //System.out.println(set);
        //lists.clear();
        //lists.addAll(set);
        //加一个空
        //lists.add(new ArrayList<>());
        return null;
    }

    public static void main(String[] args) {
        //System.out.println(subsetsWithDup(new int[]{1, 2, 2}));//[[],[1],[1,2],[1,2,2],[2],[2,2]]
        //System.out.println(subsetsWithDup(new int[]{1, 2, 3}));//
        System.out.println(subsetsWithDup(new int[]{4,4,4,1,4}));//[[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
    }
}
