package ACM.其他的算法比赛.笔试.安恒信息;

import java.util.Scanner;

public class ah3_合并递增链表 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        s1=s1.substring(0,s1.length()-1);
        String s2 = sc.next();
        //String[] split = s.split(", ");
        String[] split1 = s1.split("->");
        String[] split2 = s2.split("->");
        int len1 = split1.length;
        int len2 = split2.length;
        String[] res = new String[len1 + len2];

        int index1 = 0, index2 = 0, index = 0;
        while (index1 < len1 && index2 < len2) {
            if (Integer.parseInt(split1[index1]) < Integer.parseInt(split2[index2])) {
                res[index] = split1[index1];
                index1++;
            } else {
                res[index] = split2[index2];
                index2++;
            }
            index++;
        }

        while (index1<len1){
            res[index++] = split1[index1++];
        }
        while (index2<len2){
            res[index++] = split2[index2++];
        }

        for (int i = 0; i < res.length-1; i++) {
            System.out.print(res[i]+"->");//1->1->2->3->4->4
        }
        System.out.print(res[res.length-1]);
    }
}
