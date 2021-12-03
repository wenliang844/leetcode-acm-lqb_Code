package ACM.其他的算法比赛.笔试.爱奇艺;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class aqy1统计最多数字组的个数 {
    public static void main(String[] args) {
        //System.out.println(getSum(1));
        //System.out.println(getSum(11));
        //System.out.println(getSum(111));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxSum = 0;
        Map<Integer,Integer> map = new HashMap<>();//sum,count
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            if (map.containsKey(sum)){
                Integer count = map.get(sum)+1;
                map.put(sum,count);
                maxSum = Math.max(maxSum,count);
            }else {
                map.put(sum,1);
            }
        }

        int maxCount = 0;
        for (Integer value : map.values()) {
           if (value==maxSum){
               maxCount++;
           }
        }

        System.out.println(maxCount);
    }

    private static int getSum(int i) {
        int sum = 0;
        while (i>0){
            int temp = i%10;
            sum += temp;
            i=i/10;
        }
        return sum;
    }


}
