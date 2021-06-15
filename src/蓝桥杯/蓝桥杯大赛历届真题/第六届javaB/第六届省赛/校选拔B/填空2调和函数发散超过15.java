package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.校选拔B;

public class 填空2调和函数发散超过15 {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i <= 10000000; i++) {
            sum+=1.0/i;
            //System.out.println(sum+"--"+i);
            if (sum>15){
                System.out.println(sum+"---"+i);
                break;
            }
        }

        System.out.println(sum);
    }
}
