package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.校选拔B;

public class 填空1xpowxequal10 {
    /***
     求x
     */

    public static void main(String[] args) {

        for (double i = 2; i < 3; i+=0.00000001) {//2.5061850000707535
            if (Math.pow(i,i) >=10){//2.5061841991715896
                System.out.println(i);//2.5061841469236805
                break;
            }
        }
    }
}
