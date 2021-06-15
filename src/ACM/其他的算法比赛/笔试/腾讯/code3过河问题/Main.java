package ACM.其他的算法比赛.笔试.腾讯.code3过河问题;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /***
     走钢丝:4   1 2 5 10
     2 1 10 2  2

     1234 9 10
     2 1 10 2
     2 1 4 2   2
     p0 +p1 +last +p1  ~~~+p1
     p
     * @param args
     */

    public static void main(String[] args) {
        //System.out.println((int)'0');
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();//人数
            int peopleTimes[] = new int[n];
            for (int i = 0; i < n; i++) {
                peopleTimes[i] = sc.nextInt();
            }
            Arrays.sort(peopleTimes);
            if (peopleTimes.length<3){
                System.out.println(peopleTimes[peopleTimes.length-1]);
            }else {
                //System.out.println(Arrays.toString(peopleTimes));
                int sum = 0;
                for (int i = peopleTimes.length - 1; i > 2; i -= 2) {
                    int temp = peopleTimes[i] + peopleTimes[0] + peopleTimes[1] + peopleTimes[1];
                    //System.out.println(temp);
                    sum += temp;
                }
                if (peopleTimes.length % 2 != 0) {
                    int temp = peopleTimes[0] + peopleTimes[1] + peopleTimes[2];
                    sum += temp;
                } else {
                    sum += 2;
                }
                System.out.println(sum);
            }

        }

    }
}
