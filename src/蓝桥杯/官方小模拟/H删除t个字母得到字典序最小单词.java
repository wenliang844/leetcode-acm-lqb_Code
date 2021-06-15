package 蓝桥杯.官方小模拟;

import java.util.Scanner;
import java.util.Stack;

/*
list
思路:和前面的数进行比较;
    是不是删除前面的数会字典序更大?
        是 删除前面的数
        不是 再向后遍历
 */
public class H删除t个字母得到字典序最小单词 {
    public static void printChs(char[] cha) {
        for (int i = 0; i < cha.length; i++) {
            System.out.print(cha[i] + "-");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println(getLeastStrByArray("lanqiao", 3));
        System.out.println(getLeastStrByArray("123456874313", 3));
        System.out.println(getLeastStrByStack("lanqiao", 3));
        System.out.println(getLeastStrByStack("123456874313", 3));


    }

    public static String getLeastStrByArray(String str, int count) {
        //Scanner sc = new Scanner(System.in);
        //String str = sc.next();
        //int count = sc.nextInt();
        int cur = count;
        char[] chars = str.toCharArray();
        //printChs(chars);
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) continue;
            for (int j = i - 1; j >= 0; j--) {
                if (chars[j] == 1) {
                    continue;
                }
                if (chars[j] > chars[i]) {
                    //System.out.println(chars[j]+"=>>="+chars[i]+"=<<="+count);
                    chars[j] = 1;
                    count--;
                } else {
                    break;
                }
                if (count == 0) {
                    break;
                }
            }

            if (count == 0) {
                break;
            }
        }

        //printChs(chars);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 1) {
                continue;
            }
            sb.append(chars[i]);
        }
        String s = sb.toString();
        if (s.length() > chars.length - cur) {
            s = s.substring(0, chars.length - cur);
        }

        return s;
    }

    public static String getLeastStrByStack(String str, int count) {
        /****
         1.定义一个stack 将str.charAt(i)进栈
         和栈顶元素进行比较,如果栈顶元素的字典集大,出栈 直到出了count个为止

         用stack的时间 空间复杂度都要更低
         */
        Stack<Character> stack = new Stack<Character>();
        stack.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            while (stack.size() > 0) {
                if (count == 0) {
                    break;
                }
                if (stack.peek() > str.charAt(i)) {
                    System.out.println("这是弹出的元素=" + stack.pop());
                    count--;
                } else {
                    break;
                }
            }
            stack.add(str.charAt(i));
        }

        return stack.toString();
    }
}
