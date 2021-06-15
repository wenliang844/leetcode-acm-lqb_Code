package 蓝桥杯.十二届国赛;

public class B纯质数 {//641702   1903
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <=20210605 ; i++) {
            if (check(i)){
                boolean flag = true;
                int temp = i;
                while (temp!=0){
                    if (!check(i%10)){
                        flag = false;
                        break;
                    }
                    temp /= 10;
                }

                if (flag){
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean check(int num) {
        if (num==0 || num==1)return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
