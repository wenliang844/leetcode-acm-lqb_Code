package ACM.每日一题leecode.day185;

import java.util.Arrays;

public class day189_443压缩字符串 {

    //压缩后字符串的新长度{需要原地改造char数组}
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a', 'b'}));
        System.out.println(compress(new char[]{'a', 'a'}));
        System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
        System.out.println(compress(new char[]{'a', 'a', 'a', 'a', 'a', 'b'}));
    }

    //双指针 98/44
    public static int compress(char[] chars) {
        int count = 0;
        int left = 0, right = 1;
        while (right < chars.length) {
            if (chars[left] == chars[right]) {
                right++;
            } else {
                if (right - left == 1) {
                    chars[count] = chars[left];
                    count++;
                } else {
                    String s = String.valueOf(right - left);
                    count += s.length() + 1;
                    int limit = s.length();
                    chars[count - limit - 1] = chars[left];
                    for (int i = 0; i < limit; i++) {
                        chars[count - limit + i] = s.charAt(i);
                    }
                }

                left = right;
                right++;
            }
            System.out.println("left:" + left + "right:" + right + "count:" + count);
        }

        if (right - left == 1) {
            chars[count] = chars[left];
            count++;
        } else {
            String s = String.valueOf(right - left);
            count += s.length() + 1;
            int limit = s.length();
            chars[count - limit - 1] = chars[left];
            for (int i = 0; i < limit; i++) {
                chars[count - limit + i] = s.charAt(i);
            }
        }

        System.out.println(Arrays.toString(chars));
        return count;
    }
}
