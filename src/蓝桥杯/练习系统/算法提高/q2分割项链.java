package 蓝桥杯.练习系统.算法提高;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class q2分割项链 {
    //所以只想把项链分成两条连续的珍珠链
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //业务处理
        //1.排序
        //Arrays.sort(nums);
        //2.从大到小,依次取值
        /*int num1 = 0;
        int num2 = 0;
        for (int i = n-1; i>=0; i--) {
            if (num1>num2){
                num2+=nums[i];
            }else {
                num1+=nums[i];
            }
        }*/
        //3.返回较小的那个值
        //System.out.println(num1+"--"+num2);
        //System.out.println(Math.min(num1,num2));

        //从中间每个点枚举,前缀和,最靠近一半的胜出,也就是说两者的差距最小的胜出
        /*int pre[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i]+nums[i];
        }
        System.out.println(Arrays.toString(pre));
        //int sum = pre[n];
        int minSubIndex = 1;
        int part1Sub = Math.abs(pre[n] - pre[1]-pre[1]);
        for (int i = 2; i < n; i++) {
            if (Math.abs(pre[n]-pre[i]-pre[i])<part1Sub){
                part1Sub = Math.abs(pre[n]-pre[i]-pre[i]);
                minSubIndex = i;
            }
        }
        System.out.println(Math.min(pre[minSubIndex],pre[n]-pre[minSubIndex]));*/

        //方法三:滑动窗口,从i=0开始,小于sum/2就加一个数 大于就减一个数
        int left = 0;
        int right = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int partsum=sum/2;
        int part = nums[left];
        int minAbs = Math.abs(sum - part-part);
        int minPart = part;
        while (left<right && right<n){
            if (part<partsum && right<n){
                part+=nums[right];
                right++;
            }else {
                part-=nums[left];
                left++;
            }

            //验证当前窗口和minPart的大小
            if (Math.abs(sum - part-part) < minAbs){
                minAbs = Math.abs(sum - part-part);
                minPart = part;
            }

            //System.out.println(left+"--"+right+"--"+part);
        }

        System.out.println(Math.min(minPart,sum-minPart));
    }
}
