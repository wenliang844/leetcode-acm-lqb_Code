package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.校选拔B;

public class code1勾股定理直角个数 {
    /***
     tell斜边,求满足直角边的个数
     */
    public static void main(String[] args) {
        int count = 0;
        //int n=100;
        //int n=5;
        int n=3;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i*i +j*j ==n*n){
                    System.out.println(i+"---"+j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
