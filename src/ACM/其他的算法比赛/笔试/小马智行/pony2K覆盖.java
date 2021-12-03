package ACM.其他的算法比赛.笔试.小马智行;

import java.util.Arrays;
import java.util.Scanner;

public class pony2K覆盖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.next());
        int len = s.length();
        int[] index = new int[26];
        int[] line = new int[26];
        Arrays.fill(line, -1);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int temp = i - index[c - 'a'];
            if (temp > line[c - 'a']) {
                line[c - 'a'] = temp;
            }
            index[c - 'a'] = i;
        }
        //System.out.println(Arrays.toString(index));
        //System.out.println(Arrays.toString(line));
        //StringBuilder sb = new StringBuilder(s);
        s = s.reverse();

        Arrays.fill(index, 0);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int temp = i - index[c - 'a'];
            if (temp > line[c - 'a']) {
                line[c - 'a'] = temp;
            }
            index[c - 'a'] = i;
        }
        //Arrays.fill(line,0);
        /*System.out.println("index:"+Arrays.toString(index));
        System.out.println("line:"+Arrays.toString(line));
        for (int i = len-1; i >=0; i--) {
            char c = s.charAt(i);
            int temp = (len-1-i)-index[c-'a'];
            if (temp>line[c-'a']) {
                line[c-'a']=temp;
            }
            index[c-'a']=len-1-i;

            System.out.println(i+"--"+s.charAt(i)+"---"+temp+"--"+line[c-'a']+"--------"+Arrays.toString(line));
        }*/
        //System.out.println(Arrays.toString(index));
        //System.out.println(Arrays.toString(line));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if ((line[i] != -1) && (line[i] < min)) {
                min = line[i];
            }
        }

        System.out.println(min);
    }
}
