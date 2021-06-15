package 蓝桥杯.培训.第一次培训3_12习题2019;

public class lqb1_含2019数01 {

    //1-2019中 含有2-0-1-9 的数的个数

    public static int test1(){

        int count = 0;
        int sum = 0;
        for (int i = 1; i <= 2019; i++) {
            if ((i+"").contains("2") || (i+"").contains("0") ||(i+"").contains("1") || (i+"").contains("9")){
                count++;
                System.out.println(i);
                sum+=i;
            }
        }

        System.out.println(count);
        return sum;
    }


    //来自网络用了contains方法
    public static void test2(){
        int num=0;//存储个数
        for (int i = 1; i <=2019; i++) {
            String str=String.valueOf(i);

            if(str.contains("2")||str.contains("0")||str.contains("1")||str.contains("9")){
                num++;
                //System.out.println(i);
                //System.out.println("共有"+num+"个");
            }


        }

        System.out.println("888----"+num);
    }
    public static void main(String[] args) {
        System.out.println("这是结果="+test1());
        test2();

    }
}
