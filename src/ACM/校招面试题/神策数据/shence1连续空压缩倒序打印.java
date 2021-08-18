package ACM.校招面试题.神策数据;

import java.util.Scanner;

public class shence1连续空压缩倒序打印 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        //空格去掉, 其他的reverse
        String output = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            //是空格
            if (input.charAt(i) == ' '){
                output += sb.reverse();
                sb = new StringBuilder();
                if (output.length() >0 && output.charAt(output.length()-1) != ' '){
                    output += ' ';
                }
            }else {//不是空格
                sb.append(input.charAt(i));
            }
            //System.out.println("test-------------");
            //System.out.println(sb);
            //System.out.println(output);
            //System.out.println();
        }

        output += sb.reverse();
        System.out.println(output);


    }
}
