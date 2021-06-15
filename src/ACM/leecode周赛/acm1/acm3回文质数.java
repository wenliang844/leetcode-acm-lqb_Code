package ACM.leecode周赛.acm1;

import java.util.Scanner;

public class acm3回文质数 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            int num = Integer.parseInt(s,2);
            //System.out.println(num);

            //业务逻辑
            //1.找到第一个大于等于,并且是质数的数
            for (int i = num;; i++) {
                if (check(i)){
                    System.out.println(Integer.toBinaryString(i));break;
                }
            }
        }
    }

    private static boolean check(int num) {
        //判断是质数并且二进制是回文
        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num%i==0){
                return false;
            }
        }

        String s = Integer.toBinaryString(num);
        //System.out.println(s);

        //判断s是回文数
        int left = 0;
        int right = s.length()-1;
        while (left<right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
