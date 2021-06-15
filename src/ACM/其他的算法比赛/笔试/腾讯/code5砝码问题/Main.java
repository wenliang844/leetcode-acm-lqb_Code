package ACM.其他的算法比赛.笔试.腾讯.code5砝码问题;


import java.util.Scanner;

public class Main {
    //最少放几个砝码可以平衡
    //6  1 2 3 4 12   放一个12(最优)  or两个3

    /*public static int findNum(int i, int j) {
        int max = Math.max(i, j);
        for (int k = max; k <= i * j; k++) {
            if (k % i == 0 && k % j == 0) {
                return k;
            }
        }
        return 0;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int weight[] = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }

            int minCount=Integer.MAX_VALUE;
            int count = 0;
            boolean flag = false;
            //暴力
            for (int i = 0; i < weight.length; i++) {
                //flag = false;
                int sum = weight[i];
                count = 1;
                if (sum % m == 0) {//拿一个
                    flag = true;
                    minCount = Math.min(minCount,count);
                }
                for (int j = i + 1; j < weight.length; j++) {
                    sum += weight[j];
                    count++;
                    if (sum % m == 0) {//拿一个
                        flag = true;
                        minCount = Math.min(minCount,count);
                    }
                }
            }
            if (flag)
                System.out.println(minCount);
            else
                System.out.println(-1);
            /*Arrays.sort(weight);
            for (int i = weight.length-1; i >=0 ; i--) {

            }*/

            /*int min = Integer.MAX_VALUE;
            for (int i = 0; i < weight.length; i++) {
                int count = findNum(weight[i], m) / weight[i];
                min = Math.min(min, count);
            }
            System.out.println(min);*/
        }
    }

}
