package 蓝桥杯.蓝桥杯每日一题;

import java.util.Map;

public class day44_居民迁移 {

    /***
     公元2411年，人类开始在地球以外的行星建立居住点。在第1326号殖民星上，N个居住点分布在一条直线上。为了方便描述，我们设第i个居住点的位置是Xi，其中居住着Yi位居民。随着冬季的到来，一些人口较多的居住点的生态循环系统已经开始超负荷运转。为了顺利度过严冬，殖民星上的居民一致同意通过转移到人口较少的居住点来减轻人口众多的居住点的负荷。
     遗憾的是，1326殖民星的环境非常恶劣。在冬季到来前，每个居民点的居民最远能迁移到距离不超过R的居民点。1326殖民星的居民希望知道，如何安排迁移才能使完成迁移后人口最多的居民点人口最少？
     注意有可能存在多个居民点位置相同。
     输入
     第一行包含一个整数T(1 <= T <= 10)，代表测试数据的组数。
     每组数据的第一行包含2个整数N(1 <= N <= 100000)和R(0 <= R <= 10^9)。
     以下N行每行包含两个整数，Xi和Yi(0 <= Xi, Yi, <= 10^9)。
     输出
     对于每组数据输出迁移后人口最多的居民点人口最少可能的数目。
     样例输入
     3
     5 1
     10 80
     20 20
     30 100
     40 30
     50 10
     5 10
     10 80
     20 20
     30 100
     40 30
     50 10
     5 20
     10 80
     50 10
     20 20
     30 100
     40 30
     样例输出
     100
     50
     48
     */

    //方法一:遍历一次,如果当前数字最大还不能扩充到平均数字,这个数字和最大扩充值和平均数字的差进行其他能分担的值分担
    public static int getMaxPeople(int[][] nums, int R) {
        int maxAlonePoint = 0;//孤点的最大值
        //1.求出平均值
        int sum = 0;
        for (int[] num : nums) {
            //System.out.println(num[1]);
            sum += num[1];
        }
        int avg = sum / nums.length;
        System.out.println("平均数=" + avg);
        System.out.println("总数=" + sum);
        //2.遍历每一个数,求出最大可达值,如果小于平均数,记录差值,和数量
        int count = 0;//最大可达值低于平均值的数量
        int subSum = 0;//差值和
        for (int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            //从左找
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i][0] - nums[j][0] <= R) {
                    tempSum += nums[j][1];
                } else {
                    break;
                }
            }
            //从右找
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j][0] - nums[i][0] <= R) {
                    tempSum += nums[j][1];
                } else {
                    break;
                }
            }

            //如果最大可达值小于平均值,count++,subSum+=avg-tempSum;
            if (tempSum == 0 || tempSum + nums[i][1] < avg) {//==0就是不可达, 第二个就是有可达,但是加起来不足avg
                if (tempSum==0){//这个点是孤点
                    maxAlonePoint = Math.max(maxAlonePoint,nums[i][1]);
                }
                count++;
                subSum += avg - tempSum;
            }
        }
        if (count == nums.length) {//一个都不能分配,直接输出最大值
            /*int ret = 0;
            for (int[] num : nums) {
                ret = Math.max(num[1], ret);
            }*/
            return maxAlonePoint;
        }
        System.out.println("差值=" + subSum);
        System.out.println("数量=" + count);
        System.out.println("孤点最大值=" + maxAlonePoint);
        //把subSum差值让留下的可以超过平均值的居民平均分担
        int res = subSum / (nums.length - count) + avg;


        return Math.max(res,maxAlonePoint);
    }

    //方法二:贪心,区间,二分法
    public static void main(String[] args) {
        System.out.println(getMaxPeople(new int[][]{{10, 80}, {20, 20}, {30, 100}, {40, 30}, {50, 10}}, 1));
        System.out.println(getMaxPeople(new int[][]{{10, 80}, {20, 20}, {30, 100}, {40, 30}, {50, 10}}, 10));
        System.out.println(getMaxPeople(new int[][]{{10, 80}, {20, 20}, {30, 100}, {40, 30}, {50, 10}}, 20));
    }
}
