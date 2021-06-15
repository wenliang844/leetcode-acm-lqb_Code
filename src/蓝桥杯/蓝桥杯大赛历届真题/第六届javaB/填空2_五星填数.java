package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB;

public class 填空2_五星填数 {
    /***
     每个点都用了两次,加和=120,所以最终每条直线要等于24

     10个数固定位置进行全排列,得出的答案/10
     因为有5中是旋转可以得到,有两种是镜像可以得到
     120/10
     */
    public static void main(String[] args) {
        int points[] = {1,2,3,4,5,6,8,9,10,12};
        int count = 0;
        for (int i = 0; i < points.length-3; i++) {
            for (int j = i+1; j < points.length-2; j++) {
                for (int k = j+1; k < points.length-1; k++) {
                    for (int l = k+1; l < points.length; l++) {
                       if (points[i]+points[j]+points[k]+points[l]==24){
                           count++;
                           System.out.println(points[i]+"-"+points[j]+"-"+points[k]+"-"+points[l]);
                       }
                    }
                }
            }

        }

        System.out.println(count);
    }



}
