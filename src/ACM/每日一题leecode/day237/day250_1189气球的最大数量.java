package ACM.每日一题leecode.day237;

import java.util.HashMap;
import java.util.Map;

public class day250_1189气球的最大数量 {
    public static void main(String[] args) {//b a l o n
        System.out.println(maxNumberOfBalloons("nlaebolko"));
    }

    public static int maxNumberOfBalloons(String text) {
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'b') {
                b++;
            } else if (text.charAt(i) == 'a') {
                a++;
            } else if (text.charAt(i) == 'l') {
                l++;
            } else if (text.charAt(i) == 'o') {
                o++;
            } else if (text.charAt(i) == 'n') {
                n++;
            }
        }
        l = l / 2;
        o = o / 2;
        //System.out.println(b + "-" + a + "-" + l + "-" + o + "-" + n);
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}
