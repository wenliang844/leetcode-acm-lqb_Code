package ACM.每日一题leecode.day141;

import java.util.HashMap;
import java.util.Map;

public class day146_525连续数组 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
        System.out.println(findMaxLength(new int[]{0, 1, 0,1,1,0,1,0,1,1,1,0}));
        System.out.println(findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
        System.out.println(findMaxLength(new int[]{1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1}));
    }

    //方法一:暴力解法 每个点都可以作为起点 31/564 超时
    public static int findMaxLength(int[] nums) {

        return Math.max(findMaxLengthHelper(nums),findMaxLengthHelper(nums));


    } //方法一:暴力解法 每个点都可以作为起点 31/564 超时
    public static int findMaxLengthHelper(int[] nums) {

        int maxCount = 0;
        //int next = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = i;
            int count1 = 0;
            int count0 = 0;
            //以i作为起点

            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) {
                    count1++;
                } else {
                    count0++;
                }

                //判断count0 1相等这直接maxCout更新
                if (count0 == count1) {
                    maxCount = Math.max(maxCount, j - temp + 1);
                    i = j-1;
                }
            }
            //i = next;

        }
        return maxCount;


    }

    //方法:哈希表
    public static int findMaxLength2(int[] nums) {

        //以一个数字向两边辐射,要拿到与自己相反的数字
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }
//方法三:哈希表+前缀和 用0替换成-1,相加为0最长的 用前缀-前缀表示这一段为0 则更新max
    public static int findMaxLength3(int[] nums) {

        //用-1替换0
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                nums[i] = -1;
            }
        }

        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;//前缀和
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0 ){//i>max 有必要吗? 没有 -&& i>max
                max=i+1;
            }

            if (map.containsKey(sum)){
                max = Math.max(max,i-map.get(sum));//这是一段区间,如果有了,不必要在加了,保留最前面一个就可以了
            }else {
                map.put(sum,i);
            }
        }

        /***
         map.put(0, -1);
         int sum = 0, res = 0;
         for (int i = 0; i < nums.length; i++) {
         sum += nums[i];
         if (map.containsKey(sum)) res = Math.max(res, i - map.get(sum));
         else map.put(sum, i);
         }
         */
        return max;
    }

}
