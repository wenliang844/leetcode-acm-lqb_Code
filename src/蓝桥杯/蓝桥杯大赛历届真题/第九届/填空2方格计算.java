package 蓝桥杯.蓝桥杯大赛历届真题.第九届;

public class 填空2方格计算 {
    public static void main(String[] args) {
        /***
         半径:   个数:
         1       0*4=0
         2       1*4=4
         3      2+1 *4=12  4*4 =16
         4      3+2+1 *4=24
         5      5+4+3+2+1 *4=60

         i*i +j*j <r*r就是在园里面3137524
         */
        int count=0;
        int RR=1000*1000;
        int n=1000;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i*i+j*j)<=RR){//3137548
                    count++;
                }
            }
        }

        System.out.println(count*4);
    }
}
