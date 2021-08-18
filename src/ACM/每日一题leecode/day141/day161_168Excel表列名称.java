package ACM.每日一题leecode.day141;

import java.util.Arrays;

/***
 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。

 例如：

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ... 26进制 首位是0则无 后面的0就是Z

 */
public class day161_168Excel表列名称 {
    public static void main(String[] args) {
        //System.out.println((int)'A');
        System.out.println(convertToTitle2(1));
        System.out.println(convertToTitle2(28));
        System.out.println(convertToTitle2(52));
        System.out.println(convertToTitle2(701));
        System.out.println(convertToTitle2(702));
        System.out.println(convertToTitle2(2147483647));
    }
    public static String convertToTitle(int columnNumber) {
        String res = "";
        String num = "";
        while (columnNumber>26){
            num += columnNumber%26+"-";
            columnNumber /= 26;
        }
        if (columnNumber==26){
            num += 0;
        }else {
            num +=columnNumber;
        }
        String[] split = num.split("-");
        if (split.length>=2 && split[split.length-2].equals("0")){
            split[split.length-1]=(Integer.parseInt(split[split.length-1])-1)+"";
        }
        for (int i = split.length-1; i >=0 ; i--) {
            res += split[i].equals("0")?"Z":(char)(Integer.parseInt(split[i])+64);
        }
        //System.out.println(Arrays.toString(split));
        return res;
    }
    public static String convertToTitle2(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber>0){
            int a0 = (columnNumber-1)%26+1;
            sb.append((char)(a0-1+'A'));
            columnNumber = (columnNumber-a0)/ 26;
        }
        return sb.reverse().toString();
    }
}
