package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.javaB;

public class 填空4加法变乘法 {
    /***

     */
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 49; i++) {
            sum += i;
        }
        System.out.println(sum);

        System.out.println(sum-10-11-27-28+(10*11)+(27*28));
        System.out.println(sum-10-11+(10*11));
        System.out.println("start--------------------");
        //将两个不相邻的加法变乘法,提交最前面的一个数
        //暴力法 target = 2015
        for (int i = 0; i <= 46; i++) {
            //用sum减去i和i+1 再加上i*(i+1)
            int temp = sum;
            temp = temp - i - (i + 1);
            temp = temp + (i * (i + 1));
            if (i==10){
                System.out.println("i=1-->=="+temp);
            }
            for (int j = i + 2; j <= 48; j++) {
                //用sum减去和j+1 再加上j*(j+1)
                //在这里需要对temp进行更新 不能沿用
                int temp2 =temp - j - (j + 1)+ (j * (j + 1));

                //System.out.print(temp+"\t");
                if (i==10 && j==27){
                    System.out.println(temp);
                }
                if (temp2 == 2015){
                    System.out.println("start=这是i=="+i);
                    System.out.println("这是第二个数j=="+j);
                }
            }
        }


    }
}
