package 蓝桥杯.蓝桥杯每日一题;

import sun.rmi.transport.proxy.CGIHandler;

import java.util.*;

public class day43_基因工程_字符串处理 {

    /***
     小Hi和小Ho正在进行一项基因工程实验。他们要修改一段长度为N的DNA序列，使得这段DNA上最前面的K个碱基组成的序列与最后面的K个碱基组成的序列完全一致。
     例如对于序列"ATCGATAC"和K=2,可以通过将第二个碱基修改为"C"使得最前面2个碱基与最后面两个碱基都为"AC"。当然还存在其他修改方法，例如将最后一个碱基改为"T"，或者直接将最前面两个和最后面两个碱基都修改为"GG"。
     小Hi和小Ho希望知道在所有方法中，修改碱基最少的方法需要修改多少个碱基。
     输入
     第一行包含一个整数T(1 <= T <= 10)，代表测试数据的数量。
     每组测试数据包含2行，第一行是一个由"ATCG"4个大写字母组成的长度为N(1 <= N <= 1000)的字符串。第二行是一个整数K(1 <= K <= N)。
     输出
     对于每组数据输出最少需要修改的碱基数量。
     样例输入
     2
     ATCGATAC
     2
     ATACGTCT
     6
     样例输出
     1
     3

     */

    //特殊情况:有交叉的情况,往往让最重复的字符不变
    //方法一:i从0开始  j从i开始,step=len-匹配的长度 将j全部收集起来,不同的字母多少个count+多少 用set集合
    public static int str_编辑距离_让字符相等的操作次数(String s,int equalLen){
        int len = s.length();
        int step = len-equalLen;
        int count = 0;
        char[] chars = s.toCharArray();
        System.out.println("这是step"+step);
        for (int i = 0; i < equalLen; i++) {
            Map<Character,Integer> map = new HashMap<>();//计数,谁字母出现的评率最高
            for (int j = i; j < len; j+=step) {
                Integer integer = map.get(chars[j]);
                if (integer==null){
                   map.put(chars[j],1);
               }else {
                   map.put(chars[j],integer+1);
               }
            }
            char ch = 0;
            int maxCount=0;
            int countTemp = 0;
            for (Character character : map.keySet()) {//找出最多的ch 次数maxCount
                Integer integer = map.get(character);
                if ( integer > maxCount){
                   maxCount = map.get(character);
                   ch = character;
               }
                countTemp += integer;
            }
            //将所有的字符=ch ,并计数

            for (int j = i; j < len; j+=step) {
                chars[j] = ch;
            }

            count += countTemp - maxCount;
            System.out.println("这是每次的count变化"+count+"这是map"+map+"这是map数量"+countTemp+"这是最大数量"+maxCount);
            //System.out.println(Arrays.toString(chars));
        }
        System.out.println(Arrays.toString(chars));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(str_编辑距离_让字符相等的操作次数("ATCGATAC", 2));//1
        System.out.println(str_编辑距离_让字符相等的操作次数("ATACGTCT", 6));//3
        System.out.println(str_编辑距离_让字符相等的操作次数("AAAAA", 2));//0
        System.out.println(str_编辑距离_让字符相等的操作次数("ATCATC", 5));//4
        System.out.println(str_编辑距离_让字符相等的操作次数("ATACGTCT", 5));//3
    }
}
