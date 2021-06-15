package 蓝桥杯.蓝桥杯大赛历届真题.第九届.决赛;
//8.795
public class 填空1三角形的面积 {
    public static void main(String[] args) {
        double sum = (6.4-2.3)*(7.2-2.5);
        double n1 = (6.4-2.3)*(3.1-2.5)/2;
        double n2 = (7.2-3.1)*(6.4-5.1)/2;
        double n3 =(7.2-2.5)*(5.1-2.3)/2;

        System.out.println(sum);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(sum-n1-n2-n3);
    }
}
