package ACM.ACM1_20201116江西省赛;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int total=2*m;
        int []array=new int[m];
        int []text=new int[total];
        for (int i=0;i<total;i++) {
            text[i] = sc.nextInt();

        }
        int z=0;
        int pre=1;
        for (int i=0;i<total;i=i+2){
            int mid=text[i+1]-text[i]+1;
            array[z]=Math.min(pre,mid);
            z++;
            pre++;
        }
        for (int i=0;i<m;i++){
            System.out.println(array[i]);
        }
        int result=0;
        for (int i=0;i<m;i++){
            if(array[i]>result) result=array[i];
        }
        System.out.println(result);
    }
}
