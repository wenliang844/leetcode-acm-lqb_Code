package ACM.每日一题leecode.自刷;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lee_Tension_89格雷编码 {
    /***
     格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
     给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
     格雷编码序列必须以 0 开头。
     示例 1
     输入: 2
     输出: [0,1,3,2]
     解释:
     00 - 0
     01 - 1
     11 - 3
     10 - 2
     对于给定的 n，其格雷编码序列并不唯一。
     例如，[0,2,3,1] 也是一个有效的格雷编码序列。
     00 - 0
     10 - 2
     11 - 3
     01 - 1
     */
    //方法一:尝试规律:给几位的话就是2的几次方  相邻字符有限制
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int len = (int) Math.pow(2, n);
        for (int i = 0; i < len; i++) {
            list.add(i);
        }

        return list;
    }

    //方法二:镜像构造和翻转最低位得到
    //镜像构造:一个stack 一个list   20 87
    public static List<Integer> grayCode2(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        //int len = (int) Math.pow(2, n);
        for (int i = 1; i < n; i++) {
            int pow = (int) Math.pow(2, i);
            Stack<Integer> stack = new Stack<>();
            stack.addAll(list);
            while (!stack.isEmpty()) {
                list.add((stack.pop() + pow));
            }
        }

        return list;
    }

    //镜像反射法 67 54
    public static List<Integer> grayCode3(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int pow = (int) Math.pow(2, i);
            for (int j = list.size()-1; j >=0; j--) {
                list.add(list.get(j)+pow);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(grayCode3(1));
        System.out.println(grayCode3(2));
        System.out.println(grayCode3(3));
    }
}
