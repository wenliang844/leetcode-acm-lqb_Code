package ACM.tag刷题.数据结构.堆;

import java.util.*;

public class heap_347前K个高频元素 {
    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]

    //方法一:map计数,<key = value>1-3 2-2 3-2   返回map中的s
    public static int[] topKFrequent(int[] nums, int k) {
        //map计数
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer!=null){
                map.put(nums[i],integer+1);
            }else {
                map.put(nums[i],1);
            }
        }
       //System.out.println("这是map="+map);
        //value排序,找出第k大的value endNum
        List<Integer> list = new ArrayList<>();
        for (Integer value : map.values()) {
            list.add(value);
        }
        Collections.sort(list);
        //System.out.println("这是list="+list);
        int endNum = list.get(list.size()-k);
        //System.out.println("这是endNum="+endNum);

        //将map中大于等于endNum=2的存起来
        int[] res = new int[k];
        int i = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer)>=endNum){
                res[i]=integer;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }
}
