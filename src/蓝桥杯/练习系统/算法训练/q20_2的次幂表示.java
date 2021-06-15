package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q20_2的次幂表示 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(dfs(n));
    }

    private static String dfs(int n) {
       /* if (n==0 ||n==1 ||n==2){
            if (n!=1){
                return n+"";
            }else {
                return "";
            }
        }*/

        //业务处理:表示成二进制,进行dfs相加
        String ans = "";
        String s = Integer.toBinaryString(n);
        int count = s.length()-1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1'){

                if (count==1 || count==0 || count==2){
                    if (count==1){
                        ans+="2+";
                    }else {
                        ans+="2("+count+")+";
                    }
                }else {
                    ans+="2("+dfs(count)+")+";
                }

                //System.out.println(count);

            }
            count--;
        }
        return ans.substring(0,ans.length()-1);
    }
}
