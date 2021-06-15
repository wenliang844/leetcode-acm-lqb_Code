package 蓝桥杯.lan真题训练.lan2020省赛javaB组;
/*
问题描述】
小明正在分析一本小说中的人物相关性。他想知道在小说中 Alice 和 Bob
有多少次同时出现。
更准确的说，小明定义 Alice 和 Bob“同时出现”的意思是：在小说文本
中 Alice 和 Bob 之间不超过 K 个字符。
例如以下文本：
This is a story about Alice and Bob. Alice wants to send a private message to Bob.
假设 K = 20，则 Alice 和 Bob 同时出现了 2 次，分别是”Alice and Bob”
和”Bob. Alice”。前者 Alice 和 Bob 之间有 5 个字符，后者有 2 个字符。
注意:
1. Alice 和 Bob 是大小写敏感的， alice 或 bob 等并不计算在内。
2. Alice 和 Bob 应为单独的单词，前后可以有标点符号和空格，但是不能
有字母。例如 Bobbi 並不算出现了 Bob。
【输入格式】
第一行包含一个整数 K。
第二行包含一行字符串，只包含大小写字母、标点符号和空格。长度不超
过 1000000。
【输出格式】
输出一个整数，表示 Alice 和 Bob 同时出现的次数。
【样例输入】
20
This is a story about Alice and Bob. Alice wants to send a private message to Bob.
试题H: 人物相关性分析 12第十届蓝桥杯大赛软件类省赛 Java 大学 B 组
【样例输出】
2
【评测用例规模与约定】
对于所有评测用例， 1 ≤ K ≤ 1000000。
 */
public class H人物相关性分析 {

    public static void main(String[] args) {
        System.out.println(getNums("This is a story about Alice and Bob. Alice wants to send a private message to Bob. Alice want to call Bob. but Bobby and Bobbi came in", 2));
        System.out.println(getNums("This is a story about Alice and Bob. Alice wants to send a private message to Bob.", 20));
    }

    public static int getNums(String s,int k){
        /*
        方法一:字符串切割,切割( Alice )和(Alice.)
                        和( Bob )( Bob.)
         */

        /*
        This is a story about11
        and22
        11
        wants to send a private message to22
         */

        //用11代替Alice   22代替Bob
        s = s.replaceAll("^ Alice | Alice.|.Alice.$","33133");
        s = s.replaceAll("^ Bob | Bob\\.|.Bob.$","33233"); //"^ Bob | Bob\\.|.Bob.$"
        System.out.println(s);
        String[] split = s.split("(33)");//"( Alice | Alice.| Bob | Bob.|.Alice.|.Bob.)"

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        //遇到每一个11,就向前走k步  碰到几个22就count加几      --不能往回走
        //遇到每一个22,也就向前走k步  碰到几个11就count加几
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("1")){
                StringBuilder sb = new StringBuilder();
                sb.append("1");
                for (int j = i+1; j < split.length; j++) {
                    sb.append(split[j]);
                    if (sb.length()>20){
                        break;
                    }
                    if (split[j].equals("2")){
                        System.out.println("Alice碰到Bob了,中间是"+sb.toString()+"长度是:"+sb.length());
                        count++;
                    }
                }
            }

            if (split[i].equals("2")){
                StringBuilder sb = new StringBuilder();
                sb.append("2");
                for (int j = i+1; j < split.length; j++) {
                    sb.append(split[j]);
                    if (sb.length()>20){
                        break;
                    }
                    if (split[j].equals("1")){
                        System.out.println("Bob碰到Alice,中间是"+sb.toString()+"长度是:"+sb.length());
                        count++;
                    }
                }
            }


        }




        return count;
    }
}

