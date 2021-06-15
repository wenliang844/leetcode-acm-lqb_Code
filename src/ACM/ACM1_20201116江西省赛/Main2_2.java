package ACM.ACM1_20201116江西省赛;

import java.util.Scanner;

public class Main2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int total=2*t;
        int array[]=new int [total];
        for (int i=0;i<total;i++){
            array[i]=sc.nextInt();
        }
        for (int i=0;i<total;i=i+2){
            if(array[i]%array[i+1]==0){
                System.out.println("possible");
            }else{
                System.out.println("impossible");
            }
        }
    }
}
