package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.Arrays;

/**
 * @author 陈文亮
 * @date 2023/5/17 15:22
 */
public class day49_2446判断两个事件是否存在冲突 {
    public static void main(String[] args) {

        System.out.println(haveConflict(new String[]{"01:15","02:00"},new String[]{"02:00","03:00"}));
        System.out.println(haveConflict(new String[]{"01:00","02:00"},new String[]{"01:20","03:00"}));
        System.out.println(haveConflict(new String[]{"10:00","11:00"},new String[]{"14:00","15:00"}));
        System.out.println(haveConflict(new String[]{"14:13","22:08"},new String[]{"02:40","08:08"}));

    }

    //排序 判断大小
    public static boolean haveConflict(String[] event1, String[] event2) {

        return event2[1].compareTo(event1[0]) >= 0 && event1[1].compareTo(event2[0]) >=0;
    }
}
