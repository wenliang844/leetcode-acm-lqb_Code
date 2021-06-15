package 蓝桥杯.练习系统.算法训练;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class q17最大的算式 {

    //做法是枚举最后一次乘法。把算式拆成两边求解，
    //dp[i][j] = max(dp[i][j], dp[x-1][j-1] * (sum[i] - sum[x]))
    //(2 <= x  <= i 因为x可以取最后一个数, j <=k && j <= i-1）
    //前缀和 + 二维dp
    public static void main(String[] args) {
        int dp[][] = new int[20][20];			//dp[i][j]前i个数字用了j个*
        int sum[] = new int[20];			//保存前缀和 避免多次计算
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for(int i=1,x;i<=n;i++){
            sum[i] = sum[i-1]+ scanner.nextInt();
            dp[i][0] = sum[i];			//边界
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.min(k,i-1);j++){
                for(int l=1;l<=i;l++){			//枚举新增的乘号位置
                    dp[i][j] = Math.max(dp[i][j],dp[l-1][j-1]*(sum[i]-sum[l-1]));
                }
            }
        }
        System.out.println(dp[n][k]);
    }

    private static int ans;

    public static void main2(String[] args) {

        //赋值
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        //业务处理:
        //方法一:暴力dfs 先全部+号,再中间插入*号
        //System.out.println("test="+numscalc(nums,new boolean[n-1]));
        ans = 0;
        dfs(nums,new boolean[n-1], k);
        System.out.println(ans);
    }

    private static void dfs(int[] nums, boolean[] opret, int k) {
        if (k == 0) {
            ans = Math.max(ans ,numscalc(nums,opret));
        }

        //将一个*替换一个加号的最大值
        int max = 0;
        for (int i = 0; i < opret.length; i++) {
           // max = Math.max(dfs(Arrays.copyOf(nums, i), k - 1)*dfs(Arrays.copyOfRange(nums, i,nums.length),k-1 ), dfs(Arrays.copyOf(nums, i), k - 1)*dfs(Arrays.copyOfRange(nums, i,nums.length), k));
            if (opret[i]==false){
                boolean[] newB = new boolean[opret.length];
                System.arraycopy(opret,0,newB,0,newB.length);
                newB[i]=true;
                dfs(nums,newB,k-1);
            }
        }
        //return max;
    }

    static int numscalc(int[] nums, boolean[] opret){
        Stack<Integer> stack = new Stack<>();
        stack.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            stack.add(nums[i]);
            if (!opret[i - 1]){//+号
                stack.add(stack.pop()+stack.pop());
            }
        }
        int sum =stack.pop();
        while (!stack.isEmpty()){
            sum*=stack.pop();
        }
        return sum;
    }
}
