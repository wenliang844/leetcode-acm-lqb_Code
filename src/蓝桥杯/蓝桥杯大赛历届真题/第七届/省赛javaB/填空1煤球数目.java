package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

public class 填空1煤球数目 {

    /****
     1 1
     2 1+2
     3 1+2+3
     4 1+2+3+4
     */
    public static void test() {
        int sum[]=new int[101];
        int j=1;
        int count=0;
        for(int i=1;i<=100;i++) {
            sum[i]=sum[i-1]+j;
            j++;
            count+=sum[i];
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

        int floor=0;
        int sum=0;
        for (int i = 1; i <= 100; i++) {
            floor+=i;
            sum+=floor;
            System.out.println("i="+i+"===>"+floor+"----"+sum);
        }
        System.out.println(sum);
        test();
    }

}
