package 蓝桥杯.练习系统.基础练习;

public class lab6回文数 {

    public static void main(String[] args) {
        //所有4位的回文数
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <=9 ; j++) {
                int num = i*1000+j*100+j*10+i;
                System.out.println(num);
            }
        }
    }
}
