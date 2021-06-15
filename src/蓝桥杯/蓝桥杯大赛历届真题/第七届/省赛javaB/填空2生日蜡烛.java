package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

public class 填空2生日蜡烛 {
    /***
     i=1  -100
     i=2 -100
     */
    public static void test(){
        int s = 0,i;
        for(i=1;s!=236;i++){
            s=0;
            for(int j=i;s<=236;j++){
                s+=j;
                if(s==236)break;
            }
        }
        System.out.println(i-1);
    }
    public static void main(String[] args) {

        for (int i = 0; i <= 100; i++) {//开始

            for (int j = i+1; j <= 100; j++) {//结束

                int sum=0;
                for (int k = i; k <=j ; k++) {
                    sum+=k;
                }
                if (sum==236){
                    System.out.println(i);
                    System.out.println(j);
                    break;
                }

            }
        }

        test();
    }
}
