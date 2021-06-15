package 蓝桥杯.第一次小选拔;

public class lanqiao_1_2400000约数个数 {
    public static void main(String[] args) {
        int num = 2400000;
        int count = 0;
        System.out.println(Math.sqrt(num));
        for (int i = 1; i <= Math.sqrt(num); i++) {
            //System.out.println(num%i);
            if (num%i==0){
                count += 2;
            }
        }

        System.out.println("==="+count);
    }
}
