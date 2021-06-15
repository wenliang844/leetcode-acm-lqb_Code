package ACM.每日一题leecode.day100;

import java.util.Arrays;

public class day100_179最大数 {
    /***
     给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     示例 1：
     输入：nums = [10,2]
     输出："210"
     */
    //方法一:按照每个数字的第一位进行排序,谁大谁谁前面 5 5
    public static String largestNumber(int[] nums) {
        mySort(nums);
        System.out.println(Arrays.toString(nums));
        //对nums进行字符串拼接
        String res = "";
        for (int i = 0; i < nums.length; i++) {
            //if (nums[i] != 0){
            res += nums[i];
            //}
        }
        //res += nums[nums.length-1];
        //加完之后再去掉前导0
        int index = 0;
        for (int i = 0; i < res.length() - 1; i++) {
            if (res.charAt(i) == '0') {
                index++;
            } else {
                break;
            }
        }
        res = res.substring(index);
        return res;
    }

    //这个方法对数组进行自定义的字典序排序 --冒泡
    public static void mySort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!myCompare(nums[i] + "", nums[j] + "")) {
                    mySwap(nums, i, j);
                }
            }
        }
    }

    //交换函数
    public static void mySwap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //这个方法比较两个数的字典序
    public static boolean myCompare(/*int num1, int num2*/String s1, String s2) {
        /**
         从第一位开始比较,谁大谁的字典序大.如果是有一位后面没有数字的,他的大
         */
        //String s1 = num1 + "";
        //String s2 = num2 + "";
        int p1 = 0;
        int p2 = 0;
        while (p1 < s1.length() && p2 < s2.length()) {
            if (s1.charAt(p1) > s2.charAt(p2)) {
                return true;
            } else if (s1.charAt(p1) < s2.charAt(p2)) {
                return false;
            }
            //如果相等的话就比较下一个
            p1++;
            p2++;

        }

        if (p1 >= s1.length() && p2 >= s2.length()) {//两者相同,都出界了
            return true;
        }
        /* if (p2 >= s2.length()) {//p2出界了,前缀相同,比较p2的前一个数和p1出界数
            if (s1.charAt(p1) > s2.charAt(0))//8308 830         8308308  8308830
                return true;
            else return false;
        } else {
            if (s2.charAt(p2) < s1.charAt(0))
                return true;
            else return false;
        }*/
        return myCompare(s1 + s2, s2 + s1);
    }

    //方法一的优化,直接利用系统的compare进行字典序排序
    public String largestNumber1_1(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    //排序思路,直接使用(num1+num2) -(num2+num1)
    public String largestNumber1_3(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long x1 = Long.parseLong(x.toString() + y.toString());
            long y1 = Long.parseLong(y.toString() + x.toString());
            return (int) (y1 - x1);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(myCompare(9 + "", 98 + ""));//true
        System.out.println(myCompare(998 + "", 997 + ""));//true
        System.out.println("myProblem----------");
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{10, 2}));
        System.out.println(largestNumber(new int[]{1}));
        System.out.println(largestNumber(new int[]{10}));
        System.out.println("error case--------------");
        System.out.println(largestNumber(new int[]{8308, 8308, 830}));
        System.out.println(largestNumber(new int[]{999999991, 9}));
        System.out.println(largestNumber(new int[]{0, 0}));//225/229
        System.out.println(largestNumber(new int[]{1, 0, 0}));//227/229
    }
}
