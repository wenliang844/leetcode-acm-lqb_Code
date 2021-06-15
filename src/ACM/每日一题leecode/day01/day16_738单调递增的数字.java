package ACM.每日一题leecode.day01;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/*
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/monotone-increasing-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day16_738单调递增的数字 {
    public static void main(String[] args) {

        System.out.println("这是结果==========="+monotoneIncreasingDigits2(223));
        System.out.println("这是结果==========="+monotoneIncreasingDigits2(332));
        /*System.out.println("这是结果==========="+monotoneIncreasingDigits2(10));
        System.out.println("这是结果==========="+monotoneIncreasingDigits2(332));
        System.out.println("这是结果==========="+monotoneIncreasingDigits2(1234));
        System.out.println("这是结果==========="+monotoneIncreasingDigits2(0));
        System.out.println("这是结果==========="+monotoneIncreasingDigits2(1));
        System.out.println("这是结果==========="+monotoneIncreasingDigits2(747131058));
        System.out.println("这是结果==========="+monotoneIncreasingDigits2(232));*/
    }

    //方法1-暴力解法  每一个进行测试   符合条件返回
    public static int monotoneIncreasingDigits(int N) {

        while (N>0){
            int n = N;
            int num=n%10;
            n=n/10;
            boolean flag = true;
            while (n>0){
                if (num>=n%10){

                    //System.out.println("这是num  n:-->"+num+"--"+n+"--"+n%10);
                    num=n%10;
                    n=n/10;
                    continue;
                }else{
                    //System.out.println("不符合情况---");
                    flag=false;
                    break;
                }
            }
            if (flag){
                break;
            }
            else{
                N--;
            }
        }

        return N;
    }

    /*
    从前开始遍历
    -49

    从左到右扫描,有不符合条件的自己-1,后面的数都变9,在判断一下前面有没有重复的数
    有重复的数 i向后面移动
     */
    public static int monotoneIncreasingDigits2(int N) {

        int sum = 0;
        String s = String.valueOf(N);
        System.out.println(s);
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)>s.charAt(i+1)){
                //int j=i;
                for (int j = i-1; j >=0; j--) {
                    System.out.println("这是i   j   的比较======"+s.charAt(j)+"---"+s.charAt(i));
                    if (s.charAt(j)==s.charAt(i)){
                        i=j;
                    }else {
                        break;
                    }
                }
                System.out.println("i是==="+i);

                int sum1 = 0;
                for (int j = 0; j < i; j++) {
                    sum1 += (s.charAt(j)-48) * Math.pow(10,s.length()-1-j);
                    System.out.println("这是前面的大数==="+(s.charAt(j)-48) * Math.pow(10,s.length()-1-j));
                }

//                sum1+=9;
                System.out.println(s.charAt(i)+"---"+i);
                System.out.println(s.charAt(i)+1);
                sum1 += (s.charAt(i)-49) * Math.pow(10,s.length()-1-i);
                System.out.println("这是后面的数==="+(s.charAt(i)-49) * Math.pow(10,s.length()-1-i));
                i++;
                while (i<s.length()){
                    sum1 += 9 * Math.pow(10,s.length()-1-i);
                    System.out.println("这是后面的9==="+9 * Math.pow(10,s.length()-1-i));
                    i++;
                }
                return sum1;
            }else {
                sum += (s.charAt(i)-48) * Math.pow(10,s.length()-1-i);
                System.out.println("-----"+(s.charAt(i)-48) * Math.pow(10,s.length()-1-i));
                continue;
            }
        }

        return sum+N%10;
    }

    /*
    用char[] 从后向前比较
    从右向左扫描数字，不符合条件的话就赋值为9
     */
    public static int monotoneIncreasingDigits3(int N) {

        int sum = 0;
        String s = String.valueOf(N);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]-48);
        }

        //标记一个i  自己-1  后面全变9
        int num = 0;

        for (int i = chars.length-1; i > 0; i++) {
            if (chars[i]<chars[i+1]){

            }
        }

        return sum+N%10;
    }
}
