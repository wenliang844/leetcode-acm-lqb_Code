package 蓝桥杯.练习系统.基础练习;

public class lqb1301字串 {
    public static void main(String[] args) {

        for (int i = 0; i < 32; i++) {

            String s = Integer.toBinaryString(i);
            int len = s.length();
            for (int j = len; j < 5; j++) {
                s = "0"+s;
            }
            System.out.println(s);
        }
    }
}
