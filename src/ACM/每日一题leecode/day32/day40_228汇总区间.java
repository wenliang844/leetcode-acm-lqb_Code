package ACM.每日一题leecode.day32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 给定一个无重复元素的有序整数数组 nums 。

 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

 列表中的每个区间范围 [a,b] 应该按如下格式输出：

 "a->b" ，如果 a != b
 "a" ，如果 a == b
  

 示例 1：

 输入：nums = [0,1,2,4,5,7]
 输出：["0->2","4->5","7"]
 解释：区间范围是：
 [0,2] --> "0->2"
 [4,5] --> "4->5"
 [7,7] --> "7"
 示例 2：

 输入：nums = [0,2,3,4,6,8,9]
 输出：["0","2->4","6","8->9"]
 解释：区间范围是：
 [0,0] --> "0"
 [2,4] --> "2->4"
 [6,6] --> "6"
 [8,9] --> "8->9"
 示例 3：

 输入：nums = []
 输出：[]
 示例 4：

 输入：nums = [-1]
 输出：["-1"]
 示例 5：

 输入：nums = [0]
 输出：["0"]
 */
public class day40_228汇总区间 {

    public static void main(String[] args) {

        System.out.println("这是结果=" + summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println("这是结果=" + summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println("这是结果=" + summaryRanges(new int[]{}));
        System.out.println("这是结果=" + summaryRanges(new int[]{-1}));
        System.out.println("这是结果=" + summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
    }

    public static List<String> summaryRanges(int[] nums) {
        /***
         思路：双指针：
         if i+1 == j
         j++
         else
         list.add(a -> j-1)
         */
        List<String> list = new ArrayList<>();
        if (nums.length==0){
            return list;
        }
        if (nums.length==1){
            list.add(String.valueOf(nums[0]));
            return list;
        }
       /*

        for (int i = 0; i < nums.length-1; ) {
            for (int j = i+1; j < nums.length; ) {
                if (nums[j-1]+1 == nums[j]){
                    if (j==nums.length){
                        list.add(String.valueOf(nums[i])+"->"+String.valueOf(nums[j]));
                        break;
                    }
                    j++;
                }else {
                    if (i+1==j){
                        list.add(String.valueOf(nums[i]));
                        i=j;
                    }else {
                        StringBuilder sb = new StringBuilder(String.valueOf(nums[i]));
                        sb.append("->");
                        sb.append(nums[j-1]);
                        list.add(sb.toString());
                        i=j;
                    }

                    break;
                }
            }
        }

        if (nums[nums.length-2]+1==nums[nums.length-1]){
            String s = list.get(list.size() - 1);
            if (s.length()==1){
                s+="->";
                s+=String.valueOf(nums[nums.length-1]);
                list.remove(list.size()-1);
                list.add(s);
            }else {
                list.remove(list.size()-1);
                s=s.split("->")[1];
                list.add(s+"->"+String.valueOf(nums[nums.length-1]));
            }
        }else {
            list.add(String.valueOf(nums[nums.length-1]));
        }*/
        /*int j = 0;
        if (nums[0] + 1 != nums[1]) {
            list.add(String.valueOf(nums[0]));
            j=1;
        }

        for (int i = 1; i < nums.length - 1; ) {
            if (nums[i - 1] + 1 != nums[i]) {
                if (j == i) {
                    list.add(String.valueOf(nums[i]));
                    i++;
                    j++;
                } else {
                    list.add(String.valueOf(nums[j]) + "->" + String.valueOf(nums[i-1]));
                    j = i;
                }
            }

        }*/
        /**
         用一个字符串,不相等就加一个,分隔
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            sb.append(String.valueOf(nums[i]));
            if (nums[i]+1!=nums[i+1]){
                sb.append(",");
            }else {
                sb.append("~");
            }
        }
        sb.append(nums[nums.length-1]);
        //System.out.println(sb);
        String[] split = sb.toString().split(",");
        for (int i = 0; i < split.length; i++) {
            //System.out.println(split[i]);
            /*String[] split1 = split[i].split(".");
            if (split1.length==1){
                list.add(split[0]);
            }else {
                //list.add(split1[0]+"->"+split1[split1.length-1]);
            }*/
            if (split[i].contains("~")){
                String[] split1 = split[i].toString().split("~");
                //System.out.println("这是split1" + Arrays.toString(split1));
                /*for (int j = 0; j < split1.length; j++) {
                    System.out.println("---"+split1[j]);
                }*/
                list.add(split1[0]+"->"+split1[split1.length-1]);
            }else {
                list.add(split[i]);
            }
        }
        /*for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(".");
            System.out.println("split1"+split1[0]);
            if (split1.length==1){
                list.add(split1[0]);
            }else {
                list.add(split1[0]+"->"+split1[split1.length-1]);
            }
        }*/



        /*StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            sb.append(String.valueOf(nums[i]));
            if (nums[i]+1!=nums[i+1]){
                sb.append(",");
            }
        }
        sb.append(nums[nums.length-1]);
        System.out.println(sb);
        String[] split = sb.toString().split(",");
        for (int i = 0; i < split.length; i++) {
            if (split[i].length()==1){
                list.add(split[i]);
            }else {
                list.add(split[i].charAt(0)+"->"+split[i].charAt(split[i].length()-1));
            }
        }*/
        return list;
    }
}
