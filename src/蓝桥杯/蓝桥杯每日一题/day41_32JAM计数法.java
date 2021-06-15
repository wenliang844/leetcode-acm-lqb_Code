package 蓝桥杯.蓝桥杯每日一题;

import java.util.Arrays;

public class day41_32JAM计数法 {
    /****
     Jam是个喜欢标新立异的科学怪人。他不使用阿拉伯数字计数，而是使用小写英文字母计数，他觉得这样做，会使世界更加丰富多彩。在他的计数法中，每个数字的位数都是相同的（使用相同个数的字母），英文字母按原先的顺序，排在前面的字母小于排在它后面的字母。我们把这样的“数字”称为Jam数字。在Jam数字中，每个字母互不相同，而且从左到右是严格递增的。每次，Jam还指定使用字母的范围，例如，从2到10，表示只能使用{b,c,d,e,f,g,h,i,j}这些字母。如果再规定位数为5，那么，紧接在Jam数字“bdfij”之后的数字应该是“bdghi”。（如果我们用U、V依次表示Jam数字“bdfij”与“bdghi”，则U<V< span>，且不存在Jam数字P，使U<P<V< span>）。你的任务是：对于从文件读入的一个Jam数字，按顺序输出紧接在后面的5个Jam数字，如果后面没有那么多Jam数字，那么有几个就输出几个。

     输入格式
     　　有2行，第1行为3个正整数，用一个空格隔开：
     　　s t w
     　　（其中s为所使用的最小的字母的序号，t为所使用的最大的字母的序号。w为数字的位数，这3个数满足：1≤s<T≤26, 2≤w≤t-s ）
     　　第2行为具有w个小写字母的字符串，为一个符合要求的Jam数字。
     　　所给的数据都是正确的，不必验证。
     输出格式
     　　最多为5行，为紧接在输入的Jam数字后面的5个Jam数字，如果后面没有那么多Jam数字，那么有几个就输出几个。每行只输出一个Jam数字，是由w个小写字母组成的字符串，不要有多余的空格。

     样例输入
     2 10 5
     bdfij
     样例输出
     bdghi
     bdghj
     bdgij
     bdhij
     befgh

     */
    public static int get5JamNums(int small,int large,int w,String start){
        /**
         从后向前,如果已经是这个位置了,就不动,
         如果小于当前最大位置,向前+1,后面的依次是+2 +3   然后用这个字符串继续搞事情
         1a 2b 3c
         a-97
         a-96就是对应的值
         'chs'-96 <large 那么这里进行+1 后面+2 +3...........
         */
        char[] chs = start.toCharArray();
        System.out.println("start-------"+Arrays.toString(chs));
        while (w-- >0){
            for (int i = chs.length-1; i >=0 ; i--) {
                if (chs[i]-96<large-chs.length+1+i){
                    chs[i]= (char) (chs[i]+1);
                    i++;
                    while (i<chs.length){
                        chs[i]= (char) (chs[i-1]+1);
                        i++;
                    }
                    System.out.println("这是w==="+w+"--"+Arrays.toString(chs));
                    break;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(get5JamNums(2, 10, 5, "bdfij"));//5
    }
}
