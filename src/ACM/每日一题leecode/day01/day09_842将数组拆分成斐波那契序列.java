package ACM.每日一题leecode.day01;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;







/**
 * 方法一：回溯 + 剪枝
 * 将给定的字符串拆分成斐波那契式序列，可以通过回溯的方法实现。
 *
 * 使用列表存储拆分出的数，回溯过程中维护该列表的元素，列表初始为空。遍历字符串的所有可能的前缀，作为当前被拆分出的数，然后对剩余部分继续拆分，直到整个字符串拆分完毕。
 *
 * 根据斐波那契式序列的要求，从第 33 个数开始，每个数都等于前 22 个数的和，因此从第 33 个数开始，需要判断拆分出的数是否等于前 22 个数的和，只有满足要求时才进行拆分，否则不进行拆分。
 *
 * 回溯过程中，还有三处可以进行剪枝操作。
 *
 * 拆分出的数如果不是 00，则不能以 00 开头，因此如果字符串剩下的部分以 00 开头，就不需要考虑拆分出长度大于 11 的数，因为长度大于 11 的数以 00 开头是不符合要求的，不可能继续拆分得到斐波那契式序列；
 *
 * 拆分出的数必须符合 3232 位有符号整数类型，即每个数必须在 [0,2^{31}-1][0,2
 * 31
 *  −1] 的范围内，如果拆分出的数大于 2^{31}-12
 * 31
 *  −1，则不符合要求，长度更大的数的数值也一定更大，一定也大于 2^{31}-12
 * 31
 *  −1，因此不可能继续拆分得到斐波那契式序列；
 *
 * 如果列表中至少有 22 个数，并且拆分出的数已经大于最后 22 个数的和，就不需要继续尝试拆分了。
 *
 * 当整个字符串拆分完毕时，如果列表中至少有 33 个数，则得到一个符合要求的斐波那契式序列，返回列表。如果没有找到符合要求的斐波那契式序列，则返回空列表。
 *
 * 实现方面，回溯需要带返回值，表示是否存在符合要求的斐波那契式序列
 *
 */


public class day09_842将数组拆分成斐波那契序列 {
    /*
    给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。

    形式上，斐波那契式序列是一个非负整数列表 F，且满足：

    0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
    F.length >= 3；
    对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
    另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。

    返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。

     

    示例 1：

    输入："123456579"
    输出：[123,456,579]
    示例 2：

    输入: "11235813"
    输出: [1,1,2,3,5,8,13]
    示例 3：

    输入: "112358130"
    输出: []
    解释: 这项任务无法完成。
    示例 4：

    输入："0123"
    输出：[]
    解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
    示例 5：

    输入: "1101111"
    输出: [110, 1, 111]
    解释: 输出 [11,0,11,11] 也同样被接受。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 思路
     * 1.确定前两个数字即可   枚举前两位数字搭配情况
     * 2.数据结构的选择:list   int[]
     */
    public static void main(String[] args) {
        String S = "123456579";
        //System.out.println("result-----------===========------------============-------============------==="+splitIntoFibonacci(S));
        //System.out.println("result-----------===========------------============-------============------==="+splitIntoFibonacci("11235813"));
        //System.out.println("result-----------===========------------============-------============------==="+splitIntoFibonacci("112358130"));
        //System.out.println("result-----------===========------------============-------============------==="+splitIntoFibonacci("0123"));

        /**
         输入: "1101111"
         输出: [110, 1, 111]
         解释: 输出 [11,0,11,11] 也同样被接受。
         */
        System.out.println("result-----------===========------------============-------============------===" + splitIntoFibonacci2("1101111"));
        System.out.println("result-----------===========------------============-------============------===" + splitIntoFibonacci2("17522"));
        System.out.println("result-----------===========------------============-------============------===" + splitIntoFibonacci2("0123"));//首字母是0第一个只能是0
        System.out.println("result-----------===========------------============-------============------===" + splitIntoFibonacci2("0000"));
        System.out.println("result-----------===========------------============-------============------===" + splitIntoFibonacci2("26680333094522122405874374286875202793245124106023438638154307674529081118998476463547521258509819378850611547943714168887018710248914570324093142954155261448272417373604331561828074147927642892139798"));
        System.out.println("result-----------===========------------============-------============------===" + splitIntoFibonacci2("3611537383985343591834441270352104793375145479938855071433500231900737525076071514982402115895535257195564161509167334647108949738176284385285234123461518508746752631120827113919550237703163294909"));
    }

    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<Integer>();
        /*if (S.charAt(0)=='0'){
            System.out.println(S.charAt(0));
            System.out.println('0');
            return list;
        }*/
        int[] a = new int[S.length()];
        int[] numbers = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            numbers[i] = S.charAt(i) - 48;
            System.out.print(numbers[i] + "\t");
        }
        System.out.println("\n-----------------------------");
        int lens = numbers.length;


        for (int fLen = 1; fLen <= lens;) {//长度从1开始
            //for (int i = 0; i < lens/3; i += fLen) {
            int sum11 = 0;
            int sum1 = 0;
            int i = 0;
            for (; i < fLen; ) {//取第一个数
                for (i = 0; i < fLen; i++) {//取第一个数
                    sum11 += numbers[i] * Math.pow(10, fLen - i - 1);
                    System.out.println("numbers[i]:===" + numbers[i]);
                    System.out.println("Math.pow(10, fLen - i - 1)==" + Math.pow(10, fLen - i - 1));
                }
                //list.add(sum11);
                System.out.println("这是第一个数:====================" + sum11);

                for (int sLen = 1; sLen <= (lens - fLen) / 2; sLen++) {//第二个数长度从fLen开始
                    int sum2 = 0;
                    int j;
                    for (j = i; j < sLen + i; j++) {//取第二个数
                        sum2 += numbers[j] * Math.pow(10, sLen - j + i - 1);
                    }
                    //list.add(sum2);
                    System.out.println("这是第2个数:==========================" + sum2);
                    //List<Integer> list1 = new ArrayList<Integer>();
                   /* for (int k = 0; k < list.size(); k++) {
                        list1.add(list.get(k));
                    }*/
                    //System.out.println("这是list:==="+list);
                    //System.out.println("这是list1:==="+list1);

                    sum1 = sum11;
                    a[0] = sum11;
                    a[1] = sum2;
                    int a1 = 2;
                    int count = 2;//计数器 运行了几次就加几
                    for (int k = j; k < lens; ) {
                        count++;
                        //list1.add(sum1+sum2);
                        int sum3 = sum1 + sum2;
                        System.out.println("这是第三个数:================================" + sum3);
                        a[a1] = sum3;
                        a1++;
                        int length = String.valueOf(sum3).length();
                        System.out.println("这是第三个数的长度:===" + length);
                        if (lens - k < length) {
                            //list1.clear();
                            break;
                        }
                        int temp = 0;
                        int k1;
                        for (k1 = k; k1 < k + length; k1++) {
                            temp += numbers[k1] * Math.pow(10, length - k1 + k - 1);
                            System.out.println("这是number[k1]:===" + numbers[k1]);
                            System.out.println("这是Math.pow(10,length+k1-k-1)==" + Math.pow(10, length - k1 + k - 1));
                        }
                        System.out.println("这是temp:==================================" + temp);
                        if (temp != sum3) {
                            break;
                        }
                        System.out.println("--------------k1===" + k1);
                        System.out.println("--------------lens===" + lens);
                        if (k1 == lens) {
                            //for (int a2 : a) {
                            for (int l = 0; l < count; l++) {
                                //if (a2 != 0)
                                list.add(a[l]);
                                System.out.println("--------a2==" + a[l]);
                            }
                            return list;
                        }
                        sum1 = sum2;
                        sum2 = temp;
                        k = k1;
                    }
                }
            }
            if (S.charAt(0)!='0'){
                fLen++;
            }else {
                fLen=lens+1;
            }

        }
        return list;
    }


    public static List<Integer> splitIntoFibonacci2(String S) {
        List<Integer> list = new ArrayList<Integer>();
        /*if (S.charAt(0)=='0'){
            System.out.println(S.charAt(0));
            System.out.println('0');
            return list;
        }*/
        int[] a = new int[S.length()];
        int[] numbers = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            numbers[i] = S.charAt(i) - 48;
            //System.out.print(numbers[i] + "\t");
        }
        //System.out.println("\n-----------------------------");
        int lens = numbers.length;


        for (int fLen = 1; fLen <= lens;) {//长度从1开始
            //for (int i = 0; i < lens/3; i += fLen) {
            int sum11 = 0;
            int sum1 = 0;
            int i = 0;
            for (; i < fLen; ) {//取第一个数
                for (i = 0; i < fLen; i++) {//取第一个数
                    sum11 += numbers[i] * Math.pow(10, fLen - i - 1);
                    //System.out.println("numbers[i]:===" + numbers[i]);
                    //System.out.println("Math.pow(10, fLen - i - 1)==" + Math.pow(10, fLen - i - 1));
                }
                //list.add(sum11);
                //System.out.println("这是第一个数:====================" + sum11);

                for (int sLen = 1; sLen <= (lens - fLen) / 2; sLen++) {//第二个数长度从fLen开始
                    int sum2 = 0;
                    int j;
                    for (j = i; j < sLen + i; j++) {//取第二个数
                        sum2 += numbers[j] * Math.pow(10, sLen - j + i - 1);
                    }
                    //list.add(sum2);
                    //System.out.println("这是第2个数:==========================" + sum2);
                    //List<Integer> list1 = new ArrayList<Integer>();
                   /* for (int k = 0; k < list.size(); k++) {
                        list1.add(list.get(k));
                    }*/
                    //System.out.println("这是list:==="+list);
                    //System.out.println("这是list1:==="+list1);

                    sum1 = sum11;
                    a[0] = sum11;
                    a[1] = sum2;
                    int a1 = 2;
                    int count = 2;//计数器 运行了几次就加几
                    for (int k = j; k < lens; ) {
                        count++;
                        //list1.add(sum1+sum2);
                        int sum3 = sum1 + sum2;
                        if (sum3>=2147483647){
                            break;
                        }
                        //System.out.println("这是第三个数:================================" + sum3);
                        a[a1] = sum3;
                        a1++;
                        int length = String.valueOf(sum3).length();
                        //System.out.println("这是第三个数的长度:===" + length);
                        if (lens - k < length) {
                            //list1.clear();
                            break;
                        }
                        int temp = 0;
                        int k1;
                        for (k1 = k; k1 < k + length; k1++) {
                            temp += numbers[k1] * Math.pow(10, length - k1 + k - 1);
                            //System.out.println("这是number[k1]:===" + numbers[k1]);
                            //System.out.println("这是Math.pow(10,length+k1-k-1)==" + Math.pow(10, length - k1 + k - 1));
                        }
                        //System.out.println("这是temp:==================================" + temp);
                        if (temp != sum3) {
                            break;
                        }
                        //System.out.println("--------------k1===" + k1);
                        //System.out.println("--------------lens===" + lens);
                        if (k1 == lens) {
                            //for (int a2 : a) {
                            for (int l = 0; l < count; l++) {
                                //if (a2 != 0)
                                list.add(a[l]);
                                //System.out.println("--------a2==" + a[l]);
                            }
                            return list;
                        }
                        sum1 = sum2;
                        sum2 = temp;
                        k = k1;
                    }
                }
            }
            if (S.charAt(0)!='0'){
                fLen++;
            }else {
                fLen=lens+1;
            }

        }
        return list;
    }
}























