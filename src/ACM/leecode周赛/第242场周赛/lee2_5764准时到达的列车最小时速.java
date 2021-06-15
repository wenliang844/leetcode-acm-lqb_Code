package ACM.leecode周赛.第242场周赛;

public class lee2_5764准时到达的列车最小时速 {
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime2(new int[]{1, 3, 2}, 6));
        System.out.println(minSpeedOnTime2(new int[]{1, 3, 2}, 2.7));
        System.out.println(minSpeedOnTime2(new int[]{1, 3, 2}, 1.9));
        System.out.println(minSpeedOnTime2(new int[]{1,1,100000}, 2.01));
    }

    //从1开始枚举
    public static int minSpeedOnTime(int[] dist, double hour) {
        int max = 0;
        if (hour<dist.length-1)return -1;
        else if ((int)hour==dist.length-1){
            for (int i = 0; i < dist.length-1; i++) {
                max = Math.max(dist[i],max);
            }
            int a = (int)(1/(hour-dist.length+1));
            double num1 = dist[dist.length-1]*a;
            System.out.println(a);
            System.out.println("==="+num1);
        }
        int i;
        for (i = 1; i <= 10000000; i++) {
            double time = 0;
            for (int j = 0; j < dist.length-1; j++) {
                //dist[j]/i
                time+= dist[j]%i==0?(dist[j]/i):(dist[j]/i+1);
            }
            time+=(dist[dist.length-1]*1.00)/i;
            if (time<=hour){
                break;
            }
        }
        return i;
    }

    //方法二:二分法 避免浮点数造成的潜在误差,等式两边同时*mid和100,两边都会变成整数
    //t+dist[n-1]/mid<hour --> 100(mid*t + dist[n-1])<=mid*100*hour
    public static int minSpeedOnTime2(int[] dist, double hour) {
       int n = dist.length;
       long hr = (long) Math.ceil(hour*100);//向上取整
        if (hr < (n-1)*100){
            return -1;
        }
        //二分
        int left = 1;
        int right = (int) Math.pow(10,7);
        while (left<right){
            int mid = 1+(right-1)/2 ;
            //判断当前时速是否达标,满足时限
            long time = 0;
            //前n-1段是floor(dist[i]/mid)
            for (int i = 0; i < n - 1; i++) {
                time+=(dist[i]-1)/mid+1;
            }

            //后一段时间为dist[n-1]/mid
            time*=mid;
            time+=dist[n-1];
            if (time*100<=hr*mid){//通分转化为整数操作
                right=mid;
            }else {
                left=mid+1;
            }

        }
        return left; //满足条件的最小时速

    }

    //参考网友Java版题解
    public int minSpeedOnTime3(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour)) return -1;
        // 搜索边界
        int left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果以 mid 速度可达，那么就尝试减小速度
            if (check(dist, hour, mid)) right = mid;
                // 否则就需要加了
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(int[] dist, double hour, int speed) {
        double cnt = 0.0;
        // 对除了最后一个站点以外的时间进行向上取整累加
        for (int i = 0; i < dist.length - 1; ++i) {
            // 除法的向上取整
            cnt += (dist[i] + speed - 1) / speed;
        }
        // 加上最后一个站点所需的时间
        cnt += (double) dist[dist.length - 1] / speed;
        return cnt <= hour;
    }

}
