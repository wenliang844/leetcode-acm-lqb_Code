package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.javaB;

public class 填空2立方变自身 {
    /***
     *一个数的立方,按位累加还是等于自身
     1^3=1
     8^3=512 5+1+2=8
     17^3=4913   4+9+1+3=17
     符合的数字有多少个问
     */

    public static void main(String[] args) {
        int count=0;
        for (int i = 1; i < 1000; i++) {
            int cube = i * i * i;
            //计算cube的各个位相加
            int sum = 0;
            while (cube != 0) {
                sum += cube % 10;
                cube /= 10;
            }
            if (sum==i){
                System.out.print(i+"\t");
                count++;
            }
        }

        System.out.println("这是结果="+count);
    }
}
