package ACM.其他的算法比赛.笔试.小马智行;

import java.util.Arrays;
import java.util.Scanner;

public class pony3消息传递 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int peoples = sc.nextInt();
        int friends = sc.nextInt();
        int[] prices = new int[peoples];
        int[] fater = new int[peoples];
        for (int i = 0; i < peoples; i++) {
            prices[i] = sc.nextInt();
            fater[i] = i;
        }
        //System.out.println(Arrays.toString(prices));

        while (friends-- > 0) {
            int f1 = sc.nextInt() - 1;
            int f2 = sc.nextInt() - 1;
            int fater1 = getFater(f1, fater);
            int fater2 = getFater(f2, fater);
            if (fater1!=fater2){
                int temp = Math.min(prices[fater1], prices[fater2]);
                prices[fater1] = temp;
                setFater(fater, fater1, fater2,prices);
            }
        }
        System.out.println(Arrays.toString(prices));
        System.out.println(Arrays.toString(fater));

        int res = 0;
        for (int i = 0; i < peoples; i++) {
            res += prices[i];
        }
        System.out.println(res);
    }

    //把fater2家族 的fater设置为fater1
    private static void setFater(int[] fater, int fater1, int fater2,int[] prices) {
        if (fater[fater2]!=fater2) {
            setFater(fater,fater1,fater[fater2],prices);
        }
        //if (fater[fater2]!=fater2) {
            fater[fater2] = fater1;
            prices[fater2] = 0;
        //}


    }

    private static int getFater(int f1, int[] fater) {
        if (fater[f1] == f1) {
            return f1;
        }
        return getFater(fater[f1], fater);
    }
}
