package 蓝桥杯.lan真题训练.第十届2020决赛;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E序列求和 {

    public static void main(String[] args) {//101449

        test();
        int s[] = new int[61];//1-60
        int n = 60;
        for (int i = 1; i <= 2; i++) {//只有i个约数的最小数
            int count = 0;
            //从1开始找,找到了约数为i的数,就让s[i]=这个数

            int j = 1;
            while (true) {
                count = find(j);//找到j有多少约数
                if (count == i) {
                    break;
                }
                j++;
            }

            s[i] = j;

        }

        System.out.println(Arrays.toString(s));

        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum += s[i];
        }
        System.out.println(sum);
        System.out.println("----------优化,直接从1开始,==taeget就让s[target] = j");

       /* int target = 1;
        for (int i = 1; target != 61; i++) {
            if (find(i) == target) {
                s[target] = i;
                target++;
            }
        }
        System.out.println(Arrays.toString(s));

        sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum += s[i];
        }
        System.out.println(sum);*/
    }

    private static int find(int j) {
        //找约数
        int count = 0;
        for (int i = 1; i <= j; i++) {
            if (j % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void test() {
        //用list集合去装每次的值
        List<Integer> list = new ArrayList();
        int sum = 0;
        //遍历循环60次，即S60
        for (int i = 1; i <= 60; i++) {
            //每次都进行爆破
            for (int j = 1; ; j++) {
                //在每次进入时清除list集合，下步使用
                list.clear();
                //寻找约数
                for (int k = 1; k <= j; k++) {
                    //判断约数
                    if (j % k == 0) {
                        //如果是把约数加进list集合
                        list.add(k);
                    }

                    //判断因数个数是否等于i
                    if (list.size() == i) {
                        sum += j;
                        break;
                    }
                }
                //如果等于i即跳出循环
                if (list.size() == i) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
