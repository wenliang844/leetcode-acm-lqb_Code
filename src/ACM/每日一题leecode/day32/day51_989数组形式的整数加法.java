package ACM.每日一题leecode.day32;

import java.util.ArrayList;
import java.util.List;

public class day51_989数组形式的整数加法 {

    public static void main(String[] args) {

        System.out.println("这是结果=="+addToArrayForm3(new int[]{1, 2, 0, 0}, 34));
        System.out.println("这是结果=="+addToArrayForm3(new int[]{9,9,9,9,9,9,9,9,9,9},1));
        System.out.println("这是结果=="+addToArrayForm3(new int[]{0},10000));
    
    }

    //int暴力解法
    public static List<Integer> addToArrayForm(int[] A, int K) {

        int sum = 0;
        int temp = 1;
        //1.提取A总的数
        for (int i = A.length-1; i >=0; i--) {
            System.out.println(A[i]);
            sum += A[i] * temp;
            temp *= 10;
        }

        System.out.println("这是前sum="+sum);
        sum+=K;
        System.out.println("这是后sum="+sum);

        StringBuilder sb = new StringBuilder();
        while (sum>0){
            int temp2 = sum%10;
            sum=sum/10;
            sb.append(temp2);
        }

        System.out.println(sb.reverse());
        char[] chars = sb.toString().toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(Integer.parseInt(chars[i]+""));
        }

        return list;
    }

    //采用long
    public static List<Integer> addToArrayForm2(int[] A, int K) {

        long sum = 0;
        long temp = 1;
        //1.提取A总的数
        for (int i = A.length-1; i >=0; i--) {
            System.out.println(A[i]);
            sum += A[i] * temp;
            temp *= 10;
        }

        System.out.println("这是前sum="+sum);
        sum+=K;
        System.out.println("这是后sum="+sum);

        StringBuilder sb = new StringBuilder();
        while (sum>0){
            long temp2 = sum%10;
            sum=sum/10;
            sb.append(temp2);
        }

        System.out.println(sb.reverse());
        char[] chars = sb.toString().toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(Integer.parseInt(chars[i]+""));
        }

        return list;
    }

    //3.使用int -> 对k的位数进行判断
    public static List<Integer> addToArrayForm3(int[] A, int K) {

        /**
         2，我的做法：将K与A倒序的每个元素相加得到和，将和取模得到每个元素，插入到新数组中。

         用i标记数组
         用j标记K加完之后取余的数

         */
        StringBuilder sb = new StringBuilder();
        int i=A.length-1;
        int j;
        while (i>=0 && K>=0){
            K += Integer.parseInt(A[i]+"");
            j=K%10;
            K=K/10;
            sb.append(j+"");
            i--;
        }
        if (K!=0){
            String s = K+"";
            for (int k = s.length()-1; k >=0; k--) {
                sb.append(s.charAt(k));

            }
        }
        System.out.println("这是sb=" + sb.toString());
        System.out.println("这是K="+K);

        List<Integer> list = new ArrayList<>();
        for (int k = sb.length()-1; k >= 0; k--) {
            list.add(Integer.parseInt(sb.charAt(k)+""));
        }


        return list;
    }



}
