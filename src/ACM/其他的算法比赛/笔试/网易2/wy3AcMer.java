package ACM.其他的算法比赛.笔试.网易2;

import java.util.Scanner;

//81.82
public class wy3AcMer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length() - 4; i++) {
            min = Math.min(min, changeCount(s.substring(i, i + 5)));
        }

        System.out.println(min);
    }

    private static int changeCount(String substring) {
        //AcMer
        String s = "AcMer";
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (substring.charAt(i) != s.charAt(i)) {
                int abs = Math.abs(s.charAt(i) - substring.charAt(i));
                if (abs == 32 || abs <= 25) {
                    count += 5;
                } else {
                    count += 10;
                }
            }
        }
        return count;
    }

}
