package 蓝桥杯.官方小模拟;

public class B有多少个正整数是2020的约数 {
    public static void main(String[] args) {


        System.out.println("这是结果哦==="+getnum(2020));
        System.out.println("这是结果哦==="+getnum(12));
        System.out.println("这是结果哦==="+getnum(1200000));



    }
    public static int getnum(int n){
        int count = 0;
        System.out.println(Math.sqrt(n));
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n%i==0){
                //System.out.println(i);
                count++;
            }
        }

        return count*2;
    }
}
