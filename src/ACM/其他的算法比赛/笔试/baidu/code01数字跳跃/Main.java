package ACM.其他的算法比赛.笔试.baidu.code01数字跳跃;
//5 01212

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // int end = 5;//sc.nextInt();
        //String s = "01212";//sc.next();
        int end = sc.nextInt();
        String s = sc.next();
        int count = 0;
        char[] chars = s.toCharArray();
        int[] load = new int[end];
        for (int i = 0; i < chars.length; i++) {
            load[i] = chars[i] - 48;
        }
        //System.out.println(Arrays.toString(load));

        int dp[] = new int[end];
        dp[end-1]=0;
        //dp[end-2]=1;
        for (int i = end-2; i>=0; i--) {
            //求dp[i] = max(dp[i+1]+1,dp[j]{最近的相同}+1)
            int index = -1;
            //System.out.println("-------------------------------");
            for (int j = end-1; j >i; j--) {
               // System.out.println("==="+j+"="+load[j]+"--"+load[i]);
                if (load[j]==load[i]){
                    index=j;
                    break;
                }
            }
            if (index==-1){
                dp[i] = dp[i+1]+1;
            }else {
                dp[i] = Math.min(dp[i+1],dp[index])+1;
            }
        }
       // System.out.println(Arrays.toString(dp));
        System.out.println(dp[0]);

        //boolean flag = true;
        /*int count = 0;
        for (int i = 0; i < s.length();) {
            //找相同
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(j)==s.charAt(i)){
                    count++;
                    i=j;
                    continue;
                }
            }
                i++;
            count++;*/


            /*if (s.charAt(i) == s.charAt(end-1)){
                count++;
                break;
            }else {
                if (s.charAt(i)>i)
            }*/
    }
       /* if (flag){//找不到我就敛步走啊
            System.out.println(end-1);
        }
*/
    //System.out.println(count);
}



