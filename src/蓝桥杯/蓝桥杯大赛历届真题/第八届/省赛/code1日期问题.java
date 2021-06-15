package 蓝桥杯.蓝桥杯大赛历届真题.第八届.省赛;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code1日期问题 {

    public static void main(String[] args) {
        /****
         1960,1,1 - 2059,12,31

         02/03/04
         */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        //解析成3个数字
        String[] split = s.split("/");
        int num1 = Integer.parseInt(split[0]);
        int num2 = Integer.parseInt(split[1]);
        int num3 = Integer.parseInt(split[2]);
        //System.out.println(num1);
        //System.out.println(num2);
        //System.out.println(num3);
        /*int a[]= {num1,num2,num3};
        Arrays.sort(a);*/
        //System.out.println(a);
        /*if (judgeYear(a[0])){
            if (judgeMonth(a[1])){
                if (judgeDay(a[2])){

                }
            }
            if (judgeMonth(a[2])){
                if (judgeDay(a[0])){

                }
            }
        } if (judgeYear(a[1])){
            if (judgeMonth(a[0])){
                if (judgeDay(a[2])){

                }
            }
            if (judgeMonth(a[2])){
                if (judgeDay(a[0])){

                }
            }
        } if (judgeYear(a[2])){
            if (judgeMonth(a[0])){
                if (judgeDay(a[1])){

                }
            }
            if (judgeMonth(a[1])){
                if (judgeDay(a[ 0])){

                }
            }
        }*/
        List<List<Integer>> list = new ArrayList<>();

        //只有三种情况 年n1 月n2 日n3   月n3日n1年n2  日n3月n2年n1
        if (judge(num1, num2, num3)) {
            List<Integer> temp = new ArrayList<>();
            if (num1 >= 60) {
                temp.add(num1 + 1900);
            } else {
                temp.add(num1 + 2000);
            }
            temp.add(num2);
            temp.add(num3);
            list.add(temp);
        }/* if (judge(num1,num3,num2)){
            List<Integer> temp = new ArrayList<>();
            if (num1>=60){
                temp.add(num1+1900);
            }else {
                temp.add(num1+2000);
            }
            temp.add(num3);
            temp.add(num2);list.add(temp);
        } */
       /* if (judge(num2, num1, num3)) {
            List<Integer> temp = new ArrayList<>();
            if (num2 >= 60) {
                temp.add(num2 + 1900);
            } else {
                temp.add(num2 + 2000);
            }
            temp.add(num1);
            temp.add(num3);
            list.add(temp);
        }*/
       /* if (judge(num2, num3, num1)) {
            List<Integer> temp = new ArrayList<>();
            if (num2 >= 60) {
                temp.add(num2 + 1900);
            } else {
                temp.add(num2 + 2000);
            }
            temp.add(num3);
            temp.add(num1);
            list.add(temp);
        }*/
        if (judge(num3, num2, num1)) {
            List<Integer> temp = new ArrayList<>();
            if (num3 >= 60) {
                temp.add(num3 + 1900);
            } else {
                temp.add(num3 + 2000);
            }
            temp.add(num2);
            temp.add(num1);
            list.add(temp);
        }
        if (judge(num3, num1, num2)) {
            List<Integer> temp = new ArrayList<>();
            if (num3 >= 60) {
                temp.add(num3 + 1900);
            } else {
                temp.add(num3 + 2000);
            }
            temp.add(num1);
            temp.add(num2);
            list.add(temp);
        }

        //System.out.println(list);
        //对list进行排序 冒泡
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int n1 = list.get(i).get(0);
                int n2 = list.get(i).get(1);
                int n3 = list.get(i).get(2);
                int m1 = list.get(j).get(0);
                int m2 = list.get(j).get(1);
                int m3 = list.get(j).get(2);
                if (n1 > m1) {
                    swap(list, i, j);
                } else if (n1 == m1) {
                    if (n2 > m2) {
                        swap(list, i, j);
                    } else if (n2 == m2) {
                        if (n3 > m3) {
                            swap(list, i, j);
                        }else if (n3==m3){//需要去重复了
                            list.remove(j);
                            j--;
                        }
                    }
                }
            }
        }

        //System.out.println("sort------" + list);

        for (int i = 0; i < list.size(); i++) {
            String res = "";
            res += list.get(i).get(0) + "-";
            int n1 = list.get(i).get(1);
            int n2 = list.get(i).get(2);
            if (n1 >= 1 && n1 <= 9) {
                res += "0";
            }
            res += n1 + "-";

            if (n2 >= 1 && n2 <= 9) {
                res += "0";
            }
            res += n2;

            System.out.println(res);
        }

    }

    private static void swap(List<List<Integer>> list, int i, int j) {
        int n1 = list.get(i).get(0);
        int n2 = list.get(i).get(1);
        int n3 = list.get(i).get(2);
        list.get(i).set(0, list.get(j).get(0));
        list.get(i).set(1, list.get(j).get(1));
        list.get(i).set(2, list.get(j).get(2));
        list.get(j).set(0, n1);
        list.get(j).set(1, n2);
        list.get(j).set(2, n3);
    }

    private static boolean judge(int year, int mouth, int day) {
        boolean isleap = false;//闰年29天
        int leap = 0;
        if (year >= 60) {
            leap = year + 1900;
        } else {
            leap = year + 2000;
        }

        if (leap % 4 == 0 && leap % 400 != 0 || leap % 400 == 0)
            isleap = true;
        else
            isleap = false;

        if (mouth >= 1 && mouth <= 12) {
            switch (mouth) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    //大月:31天
                    if (day >= 0 && day <= 31) return true;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day >= 0 && day <= 30) return true;
                case 2:
                    if (isleap) {
                        if (day >= 0 && day <= 29) return true;
                    } else {
                        if (day >= 0 && day <= 28) return true;
                    }
            }
        }
        return false;
    }


}
