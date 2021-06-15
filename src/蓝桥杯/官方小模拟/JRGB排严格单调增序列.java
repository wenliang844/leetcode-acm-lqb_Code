package 蓝桥杯.官方小模拟;

import java.util.*;

/*
问题描述
　　小蓝有黄绿蓝三种颜色的小球，分别为 R, G, B 个。同样颜色的小球没有区别。
　　小蓝将这些小球从左到右排成一排，排完后，将最左边的连续同色小球个数记为 t_1，将接下来的连续小球个数记为 t_2，以此类推直到最右边的小球。
　　请问，总共有多少总摆放小球的方案，使得 t_1, t_2, ... 为严格单调递增序列，即 t_1 < t_2 < t_3 < ...
输入格式
　　输入一行包含三个整数 R, G, B。
输出格式
　　输出一个整数，表示答案。
样例输入
3 6 0
样例输出
3
样例说明
　　用 r 表示红球，g 表示绿球，可能的方案包括：
　　rrrgggggg
　　grrrggggg
　　ggrrrgggg
样例输入
2 4 6
样例输出
3
样例说明
　　用 r 表示红球，g 表示绿球，b 表示蓝球，可能的方案包括：
　　rrggggbbbbbb
　　grrgggbbbbbb
　　brrggggbbbbb
 */
public class JRGB排严格单调增序列 {
    public static void main(String[] args) {
        RGB();


    }


    //method1 对RGB进行材分
    public static void RGB() {

        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int G = sc.nextInt();
        int B = sc.nextInt();

        if (R + G + B == R ||
                R + G + B == G ||
                R + G + B == B) {
            System.out.println(1);
            return;
        }

        List<List<Integer>> lists1 = new ArrayList<List<Integer>>();
        //if (R!=0){
        List<Integer> l = new ArrayList<Integer>();
        l.add(R);
        lists1.add(l);
        for (int i = 0; i <= R; i++) {
            for (int j = i + 1; j <= R - i; j++) {
                int k = R - i - j;
                System.out.println(i + " " + j + " " + k);
                if (k <= j || k <= i) {
                    continue;
                }
                List<Integer> list = new ArrayList<Integer>();
                if (i != 0) {
                    list.add(i);
                }
                if (j != 0) {
                    list.add(j);
                }
                if (k != 0) {
                    list.add(k);
                }
                lists1.add(list);

            }
        }
        System.out.println(lists1);
        // }

        List<List<Integer>> lists2 = new ArrayList<List<Integer>>();
        // if (G!=0){
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(G);
        lists2.add(l2);
        for (int i = 0; i <= G; i++) {
            for (int j = i + 1; j <= G - i; j++) {
                int k = G - i - j;
                System.out.println(i + " " + j + " " + k);
                if (k <= j || k <= i) {
                    continue;
                }
                List<Integer> list = new ArrayList<Integer>();
                if (i != 0) {
                    list.add(i);
                }
                if (j != 0) {
                    list.add(j);
                }
                if (k != 0) {
                    list.add(k);
                }
                lists2.add(list);

            }
        }
        System.out.println(lists2);
        //}

        List<List<Integer>> lists3 = new ArrayList<List<Integer>>();
        //if (B!=0){
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(B);
        lists3.add(l3);
        for (int i = 0; i <= B; i++) {
            for (int j = i + 1; j <= B - i; j++) {
                int k = B - i - j;
                System.out.println(i + " " + j + " " + k);
                if (k <= j || k <= i) {
                    continue;
                }
                List<Integer> list = new ArrayList<Integer>();
                if (i != 0) {
                    list.add(i);
                }
                if (j != 0) {
                    list.add(j);
                }
                if (k != 0) {
                    list.add(k);
                }
                lists3.add(list);

            }
        }
        System.out.println(lists3);
        //}


        int count = 0;
        if (lists1 != null)
            for (List<Integer> li1 : lists1) {
                //System.out.println("这是第一");
                for (List<Integer> li2 : lists2) {
                    //System.out.println("这是第二");
                    for (List<Integer> li3 : lists3) {
                        //System.out.println("这是第三");
                        Set<Integer> set = new HashSet<Integer>();
                        for (Integer integer : li1) {
                            set.add(integer);
                        }
                        for (Integer integer : li2) {
                            set.add(integer);
                        }
                        for (Integer integer : li3) {
                            set.add(integer);
                        }
                        System.out.println("这是set" + set);

                        List<Integer> setList = new ArrayList<Integer>();
                        for (Integer integer : set) {
                            setList.add(integer);
                        }
                        boolean flag = true;
                        for (int i = 0; i < setList.size()-1; i++) {
                            for (int j = 0; j < li1.size()-1; j++) {
                                if (setList.get(i)==li1.get(j)&&setList.get(i+1)==li1.get(j+1)){
                                    flag=false;
                                    break;
                                }
                            }
                            if (flag==false)break;
                        }
                        if (flag==false){
                            continue;
                        }
                        if (set.size() == li1.size() + li2.size() + li3.size() &&
                                (li1.size() <= (li2.size() + li3.size() + 1)) &&
                                (li2.size() <= (li1.size() + li3.size() + 1)) &&
                                (li3.size() <= (li1.size() + li2.size() + 1))) {
                            count++;
                            System.out.println("这是满足条件的set" + set);
                        }

                    }
                }
            }
        System.out.println(count);


    }
}
