package 蓝桥杯.蓝桥杯大赛历届真题.第八届.省赛;

import java.util.Scanner;

public class code3分巧克力 {

    public static void main(String[] args) {
        //从巧克力的最大边长开始尝试,当sum>= K的时候,及时他了

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//巧克力
        int k = sc.nextInt();//人数
        int maxSide = 0;//最大边长
        int rectangle[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            rectangle[i][0] = sc.nextInt();//长
            rectangle[i][1] = sc.nextInt();//宽
            maxSide = Math.max(rectangle[i][0],maxSide);
            maxSide = Math.max(rectangle[i][1],maxSide);
        }

        //从maxSize开始尝试,尝试maxSize次

        for (int i = maxSide; i >=0; i--) {

            //计算切maxSize次能得到的最多块
            int sum = 0;//块数
            for (int j = 0; j < n; j++) {
                //对每一个rectangle进行切割
                sum+=(rectangle[j][0]/maxSide) * (rectangle[j][1]/maxSide);
            }

            if (sum>=k){//够分了
                break;
            }

            maxSide--;//不够,降低标准
        }

        System.out.println(maxSide);
    }
}
