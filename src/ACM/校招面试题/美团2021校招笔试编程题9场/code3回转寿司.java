package ACM.校招面试题.美团2021校招笔试编程题9场;
/**
 小美请小团吃回转寿司。转盘上有N盘寿司围成一圈，第1盘与第2盘相邻，第2盘与第3盘相邻，…，
 第N-1盘与第N盘相邻，第N盘与第1盘相邻。小团认为第i盘寿司的美味值为A[i]（可能是负值，
 如果小团讨厌这盘寿司）。现在，小团要在转盘上选出连续的若干盘寿司，使得这些寿司的美味值之和最大
 （ 允许不选任何寿司，此时美味值总和为0）。
 */
import java.util.Arrays;
import java.util.Scanner;


//用二维动态规划 每个寿司可以放和不放
public class code3回转寿司 {

    //方法一:枚举
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        int[] datas = new int[groups];
        //int index = 0;
        for (int i = 0; i < groups; i++) {

            int n = sc.nextInt();//寿司数
            int[] nn = new int[n];
            for (int j = 0; j < n; j++) {
                nn[j] = sc.nextInt();//寿司喜爱度
            }
            //System.out.println(Arrays.toString(nn));

            //动态规划二维数组
           /* int[][] dp = new int[2][n];
            dp[0][0] = nn[0];//表示第一次要了
            dp[1][0] = 0;//表示第一次不要
            for (int j = 1; j < n; j++) {

            }*/

           int maxNums = 0;
           //将每一个节点作为开始节点,节点-1作为结束节点
            for (int j = 0; j < n; j++) {//开始节点
                int start = j;
                int end = (j+n-1)%n;
                //System.out.println(start+"-"+end);
                int num = 0;
                for (; start != end; ) {
                    num += nn[start];
                    if (num > maxNums){
                        maxNums = num;
                    }else if (num<0){
                        num=0;
                    }
                    //maxNums=Math.max(maxNums,num);
                   //System.out.println(num+"------"+nn[start]);

                    start++;
                    if (start>3){
                        start=0;
                    }
                }

            }
            datas[i] = maxNums;

        }

        //输出结果
        for (int i = 0; i < datas.length; i++) {
            System.out.println(datas[i]);
        }

    }

    //方法二:贪心:每次大于0就继续加  小于0就=0  thisnum和maxnum
    public static void main2(String[] args) {

    }
    //方法三:动态规划 dp[i] = max(dp[i]+array[i],array[i])
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- >0){
            int n = sc.nextInt();
            int[] nn = new int[n];
            for (int i = 0; i < n; i++) {
                nn[i] = sc.nextInt();
            }
            //System.out.println(Arrays.toString(nn));
            int dpMax = nn[0];
            int dpMin = nn[0];
            int numMax = nn[0];
            int numMin = nn[0];
            int all = nn[0];
            for (int i = 1; i < n; i++) {
                dpMax = Math.max(nn[i],dpMax+nn[i]);//最大值 是拿或不拿
                dpMin = Math.min(nn[i],dpMin+nn[i]);//最小值


                numMax = Math.max(numMax,dpMax);
                numMin = Math.min(numMin,dpMin);
                //System.out.println(i+"==="+nn[i]+"==="+dpMin+"==="+numMin);
                all+= nn[i];
            }

            //System.out.println(numMax+"---("+numMin+"---"+dpMax+"---("+dpMin+"---"+all);
            System.out.println(Math.max(numMax,all-numMin));
        }
    }

}
