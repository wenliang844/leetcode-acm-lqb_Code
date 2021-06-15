package ACM.tag刷题.数据结构.数组;

import java.util.HashMap;
import java.util.Map;

public class array_560和为K的子数组 {
    /****
     给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     示例 1 :
     输入:nums = [1,1,1], k = 2
     输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     */

    //方法一:双指针i-j相加=k
    public static int subarraySum(int[] nums, int k) {

        int count = 0;
       /* for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==k){
                    count++;
                }
            }
        }*/
        //是要连续子数组
        int i = 0;
        int j = i;
        int sum = 0;
        while (j < nums.length && i < nums.length) {
            sum += nums[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {//还可以向前面探索,看还有没有
                System.out.println("这是i=" + i + "zheshij=" + j);
                count++;
                //i++;
                //j=i;
                j++;
                //sum=0;//新一轮
            } else {
                i++;
                j = i;
                sum = 0;
            }

            if (j == nums.length && i < nums.length - 1) {
                i++;
                j = i;
                sum = 0;//新一轮
            }
        }
        return count;
    }

    //方法二:把每一个数字当做开头的数字,向左进行扩展 清晰,可靠 17 29
    //总结,需要对各种情况进行分析,找出唯一区分点,定位一个点,进行扩展,得出全部的情况 必要情况进行剪枝
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum =0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum==k){
                    count++;
                }
            }

        }

        return count;
    }

    /***
        官方方法:前缀和+哈希表优化:
     pre[i]−k 的 \textit{pre}[j]pre[j]我们建立哈希表 \textit{mp}mp，以和为键，出现次数为对应的值，记录 \textit{pre}[i]pre[i] 出现的次数，从左往右边更新 \textit{mp}mp 边计算答案，那么以 ii 结尾的答案 \textit{mp}[\textit{pre}[i]-k]mp[pre[i]−k] 即可在 O(1)O(1) 时间内得到。最后的答案即为所有下标结尾的和为 kk 的子数组个数之和。
     需要注意的是，从左往右边更新边计算的时候已经保证了\textit{mp}[\textit{pre}[i]-k]mp[pre[i]−k] 里记录的 \textit{pre}[j]pre[j] 的下标范围是 0\leq j\leq i0≤j≤i 。同时，由于\textit{pre}[i]pre[i] 的计算只与前一项的答案有关，因此我们可以不用建立 \textit{pre}pre 数组，直接用 \textit{pre}pre 变量来记录 pre[i-1]pre[i−1] 的答案即可。
     下面的动画描述了这一过程：
     */
    //官方好方法:通过前缀-前缀=7反过来,记录每一个前缀的次数,用当前前缀-7,看有没有对应的前缀,来找连续子数组和=k的 53 12
    public static int subarraySum3(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();//保存前缀出现的次数
        map.put(0,1);//初始化,前缀0出现1次
        int perSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            perSum += nums[i];

            //寻找以此前缀-k为前缀的数
            Integer tempCount = map.get(perSum - k);
            if (tempCount!=null){
                count += tempCount;
            }

            //将此前缀放到map哈希表中 这个要后放,不能自己+自已重复使用呀,当前前缀只能后者使用
            Integer integer = map.get(perSum);
            if (integer==null){
                map.put(perSum,1);
            }else {
                map.put(perSum,integer+1);
            }


        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum3(new int[]{1,1,1},2));//2
        System.out.println(subarraySum3(new int[]{1,5,4,9,8,3,6},9));
        System.out.println(subarraySum3(new int[]{-1,-1,1},0));
        System.out.println(subarraySum3(new int[]{-1,-1,1},1));
        System.out.println(subarraySum3(new int[]{1, -1, 0}, 0));
    }
}
