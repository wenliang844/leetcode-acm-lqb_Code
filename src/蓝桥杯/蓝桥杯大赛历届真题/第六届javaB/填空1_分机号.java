package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB;

public class 填空1_分机号 {
    /***
     三位数的数中有多少严格降序的,不能有重复的数字
     */

    public static int getNum(){
        int count=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (i>j&&j>k){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(getNum());
        //judgement(321);
        int count = 0;
        for (int i = 100; i <= 999; i++) {
            if (judgement(i)){
                count++;
            }
        }
        System.out.println("answer---------------");
        System.out.println(count);
    }

    private static boolean judgement(int num) {
        int one = num%10;//个位数
        int two =num%100/10;//十位数
        int three = num%1000/100;//白位数
        //System.out.println(one+"-"+two+"-"+three);
        if (three>two && two>one){
            System.out.print(num+"\t");
            return true;
        }else {
            return false;
        }
    }
}
