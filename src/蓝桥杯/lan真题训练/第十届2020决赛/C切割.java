package 蓝桥杯.lan真题训练.第十届2020决赛;

public class C切割 {//100

    public static void main(String[] args) {
        int sum=0;
        for (int i = 4; i >= 1; i--) {
            for (int j = 4; j >=1 ; j--) {
                System.out.print(i*j+"\t");
                sum += i*j;
            }
            System.out.println();
        }

        System.out.println(sum);
    }
}
