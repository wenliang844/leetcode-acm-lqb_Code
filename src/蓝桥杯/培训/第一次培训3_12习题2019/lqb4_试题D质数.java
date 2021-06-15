package 蓝桥杯.培训.第一次培训3_12习题2019;

public class lqb4_试题D质数 {

    /***
     我们知道第一个质数是 2、第二个质数是 3、第三个质数是 5……请你计算
     第 2019 个质数是多少？
     */

    public static boolean isPrimeNumber(int num){

        int a = (int) Math.sqrt(num);
        for (int i = 2; i <= a; i++) {
            if (num % i ==0){
                return false;
            }
        }
        return true;
    }

    public static int primeCount(int num){
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (isPrimeNumber(i)){
                count++;
            }
        }

        return count;
    }

    public static void prime2019(){
        int count = 2019;
        while (count!=0){
            for (int i = 2;; i++) {
                if (isPrimeNumber(i)){
                    count--;
                }

                if (count==0){
                    System.out.println("这是2019个=="+i);
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {

        System.out.println(isPrimeNumber(2));
        System.out.println(isPrimeNumber(9));
        System.out.println(isPrimeNumber(10));
        System.out.println(isPrimeNumber(11));
        System.out.println("这是结果="+primeCount(2019));
        prime2019();
    }
}
