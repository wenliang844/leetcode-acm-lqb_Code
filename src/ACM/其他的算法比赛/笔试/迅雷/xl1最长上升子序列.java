package ACM.其他的算法比赛.笔试.迅雷;

import java.util.Scanner;

public class xl1最长上升子序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        s = s.substring(1,s.length()-1);
        if(s.length()==0) {
            System.out.println(0);
            return;
        }
        String[] ss = s.split(",");
        int len = ss.length;
        int nums[] = new int[len];
        //Arrays.fill(nums,1);
        int max = 1;
        for(int i=0;i<len;i++){
            int maxTemp = 1;
            for(int j=0;j<i;j++){
                if(Integer.parseInt(ss[j])<Integer.parseInt(ss[i])){
                    maxTemp = Math.max(maxTemp,nums[j]+1);
                }
            }
            nums[i] = maxTemp;
            max=Math.max(max,maxTemp);
        }
        System.out.println(max);
    }
}

