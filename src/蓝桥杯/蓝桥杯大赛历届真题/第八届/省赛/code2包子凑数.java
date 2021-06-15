package 蓝桥杯.蓝桥杯大赛历届真题.第八届.省赛;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code2包子凑数 {
    public static void main(String[] args) {
        /***
         a[n]个包子笼,问不能凑出多少数,使用丑数的指针法
         2
         4
         5
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num[] = new int[n];
        int pmin = 0;
        boolean inf = true;
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            if (num[i] < num[pmin]) {
                pmin = i;
            }
            if (num[i]%2!=0){
                inf=false;//但凡有一个奇数,直接false
            }
        }
        int p[] = new int[n];
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);

        //System.out.println("最小指针值下标" + pmin);
        //如果都是偶数的话,直接return INF
        if (n==1 || inf){
            System.out.println("INF");
            return;
        }
        int maxCount=0;

        while (true) {
            maxCount++;
            if (maxCount>=10000){
                inf=true;
                break;
            }
            //System.out.println(list);
            //将最小的数加入list,同时这个最小的数指针p++;
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < n; i++) {
                int temp = list.get(p[i]) + num[i];
                if (temp < min) {
                    min = temp;
                    index = i;
                }
            }

            p[index]++;
            //只有当你这个最小值会大于我的后面数,我才加入你到我的队列
            if (min > list.get(list.size() - 1)) {
                list.add(min);
            }

            //判断list是否达标,就是list的size-1  到pmin{num的最小值的下标] 是否连续&&长度>
            //if (list.size()-1 - p[pmin]>=num[pmin]){
            int len = list.size() - 1;
            if (len > num[pmin]) {
                boolean flag = true;
                //判断是否连续
                for (int i = len; i >= 1 && i >= len - num[pmin]; i--) {
                    if (list.get(i) - list.get(i - 1) != 1) {
                        flag = false;
                        break;
                    }
                }

                if (flag) break;
            }
        }

        if (inf){
            System.out.println("INF");
        }else {
            //System.out.println(list);
            //判断list中有多少是不能表示的
            int count = list.get(list.size() - 1) - list.size();
            System.out.println(count + 1);//0这个数需要加上
        }



    }
}
