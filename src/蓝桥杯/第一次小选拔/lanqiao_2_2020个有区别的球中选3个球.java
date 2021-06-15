package 蓝桥杯.第一次小选拔;

/**
 * 错了
 */
public class lanqiao_2_2020个有区别的球中选3个球 {
    public static void main(String[] args) {
        method1();
    }

    //C2020 取3
    //8,230,170,840  /  6
    //1,371,695,140
    public static void method1(){
        //long result = (2020*2019*2018)/(3*2*1);
        //long a = 8230170840/6;
        //long b = 8230170840;
        int c = ((2020*2019)/6)*2018;
        int d = (2020/6)*2019*2018;
        int e = (2020/2)*(2019/3)*(2018);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
