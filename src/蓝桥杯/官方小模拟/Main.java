package 蓝桥杯.官方小模拟;


/*import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double l = sc.nextDouble();
        double h = sc.nextDouble();
        if ((l*h)%2==0){
            System.out.printf("%.0f",(l*h)/2);
        }else{
            System.out.printf("%.1f",(l*h)/2);
        }
    }
}*/


/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();


        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day>=1 &&day<=31){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day>=1 && day<=30){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
                break;
            case 2:
                if (day>=1 && day<=28){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
                break;
            default:
                System.out.println("no");
        }
    }
}*/






/*import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = sc.nextInt();
        int cur = count;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i==0)continue;
            for (int j = i-1; j >=0 ; j--) {
                if (chars[j]==1){
                    continue;
                }
                if (chars[j]>chars[i]){
                    chars[j]=1;
                    count--;
                }else {
                    break;
                }
                if (count==0){
                    break;
                }
            }

            if (count==0){
                break;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==1){
                continue;
            }
            sb.append(chars[i]);
        }
        String s = sb.toString();
        if (s.length()>chars.length-cur){
            s = s.substring(0, chars.length - cur);
        }

        System.out.println(s);
    }
}*/






/*

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i]=sc.nextInt();
        }
        int maxNum = 0;
        for (int i = 0; i < len-1; i++) {
            if (nums[i+1]-nums[i]>maxNum){
                maxNum=nums[i+1]-nums[i];
            }
        }
        System.out.println(maxNum);
    }
}
*/





/*


import java.util.*;
public class Main {
    public static void main(String[] args) {
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
                //System.out.println(i + " " + j + " " + k);
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
        //System.out.println(lists1);
        // }

        List<List<Integer>> lists2 = new ArrayList<List<Integer>>();
        // if (G!=0){
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(G);
        lists2.add(l2);
        for (int i = 0; i <= G; i++) {
            for (int j = i + 1; j <= G - i; j++) {
                int k = G - i - j;
                //System.out.println(i + " " + j + " " + k);
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
        // System.out.println(lists2);
        //}

        List<List<Integer>> lists3 = new ArrayList<List<Integer>>();
        //if (B!=0){
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(B);
        lists3.add(l3);
        for (int i = 0; i <= B; i++) {
            for (int j = i + 1; j <= B - i; j++) {
                int k = B - i - j;
                //System.out.println(i + " " + j + " " + k);
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
        // System.out.println(lists3);
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
                        //System.out.println("这是set" + set);

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
                            //System.out.println("这是满足条件的set" + set);
                        }

                    }
                }
            }
        System.out.println(count);
    }
}


*/





