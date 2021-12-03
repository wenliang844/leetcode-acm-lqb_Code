package ACM.校招面试题.网易校招;

import java.util.Arrays;

public class wy4神奇的字符串 {
    public static void main(String[] args) {
        System.out.println(convertMagicalString("azbA5#1@c"));
    }

    public static long convertMagicalString (String magicalString) {
        // write code here
        String s = magicalString.toLowerCase();
        System.out.println(s);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));

        int index = 0;
        while (index<chars.length && chars[index]<'0'){
            index++;
        }
        System.out.println("idnex:"+index);
        String s1 = "";
        for (;index<chars.length;index++){
            if (chars[index]<='9'){
                s1 += chars[index];
            }else {
                break;
            }
        }

        System.out.println("idnex:"+index);
        String s2 = "";
        for (;index<chars.length;index++){
            if (chars[index]>='a' && chars[index]<='z' &&(index==chars.length-1 || chars[index+1]-chars[index]!=1)){
                s2 += (chars[index]-'a' +1);
            }
        }
        System.out.println("s1:"+s1+"s2:"+s2);
        return Long.parseLong(s2+s1);
    }
}
