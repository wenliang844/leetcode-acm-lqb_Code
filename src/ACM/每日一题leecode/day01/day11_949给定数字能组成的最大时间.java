package ACM.每日一题leecode.day01;
/*
给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。

24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。

以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。

 

示例 1：

输入：arr = [1,2,3,4]
输出："23:41"
解释：有效的 24 小时制时间是 "12:34"，"12:43"，"13:24"，"13:42"，"14:23"，"14:32"，"21:34"，"21:43"，"23:14" 和 "23:41" 。这些时间中，"23:41" 是最大时间。
示例 2：

输入：arr = [5,5,5,5]
输出：""
解释：不存在有效的 24 小时制时间，因为 "55:55" 无效。
示例 3：

输入：arr = [0,0,0,0]
输出："00:00"
示例 4：

输入：arr = [0,0,1,0]
输出："10:00"
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 2  3-1   5-1   9-1
 * <p>
 * 1  9-1   5-1   9-1
 * 0  9-1   5-1   9-1
 */
public class day11_949给定数字能组成的最大时间 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("这是最终答案===" + largestTimeFromDigits3(arr));
        int[] arr2 = {5, 5, 5, 5};
        System.out.println("这是最终答案===" + largestTimeFromDigits3(arr2));
        int[] arr3 = {0, 0, 0, 0};
        System.out.println("这是最终答案===" + largestTimeFromDigits3(arr3));
        int[] arr4 = {0, 0, 1, 0};
        System.out.println("这是最终答案===" + largestTimeFromDigits3(arr4));
        int[] arr5 = {0, 4, 0, 0};
        System.out.println("这是最终答案===" + largestTimeFromDigits3(arr5));


    }

    public static String largestTimeFromDigits(int[] arr) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        list1.add(arr[0]);
        list1.add(arr[1]);
        list1.add(arr[2]);
        list1.add(arr[3]);
        System.out.println(list1);
        for (int i = 0; i < arr.length; i++) {

            if (list1.get(i) == 2) {
                list2.add(list1.get(i));
                list1.remove(i);

                for (int j = 0; j < list1.size(); j++) {
                    if (list1.get(j) == 3) { //第2个数
                        list2.add(list1.get(j));
                        list1.remove(j);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                        } else {
                            return "";
                        }
                    }


                    if (list1.get(j) == 2) {
                        list2.add(list1.get(j));
                        list1.remove(j);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                            list2.add(maxNum);
                            list2.add(list1.get(1));
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                            list2.add(maxNum);
                            list2.add(list1.get(0));
                        } else {
                            return "";
                        }
                    } else if (list1.get(j) == 1) {
                        list2.add(list1.get(j));
                        list1.remove(j);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                            list2.add(maxNum);
                            list2.add(list1.get(1));
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                            list2.add(maxNum);
                            list2.add(list1.get(0));
                        } else {
                            return "";
                        }
                    } else if (list1.get(j) == 0) { //第2个数
                        list2.add(list1.get(j));
                        list1.remove(j);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                            list2.add(maxNum);
                            list2.add(list1.get(1));
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                            list2.add(maxNum);
                            list2.add(list1.get(0));
                        } else {
                            return "";
                        }
                    }
                }
            } else if (list1.get(i) == 1) {
                list2.add(list1.get(i));
                list1.remove(i);

                //int maxNum=0;
                for (int j = 0; j < list1.size(); j++) {
                    if (list1.get(0) >= list1.get(2) && list1.get(0) >= list1.get(2)) {
                        list2.add(list1.get(0));
                        list1.remove(0);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                            list2.add(maxNum);
                            list2.add(list1.get(1));
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                            list2.add(maxNum);
                            list2.add(list1.get(0));
                        } else {
                            return "";
                        }
                    } else if (list1.get(1) >= list1.get(0) && list1.get(1) >= list1.get(2)) {
                        list2.add(list1.get(1));
                        list1.remove(1);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                            list2.add(maxNum);
                            list2.add(list1.get(1));
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                            list2.add(maxNum);
                            list2.add(list1.get(0));
                        } else {
                            return "";
                        }
                    } else if (list1.get(2) >= list1.get(1) && list1.get(2) >= list1.get(0)) {
                        list2.add(list1.get(2));
                        list1.remove(2);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                            list2.add(maxNum);
                            list2.add(list1.get(1));
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                            list2.add(maxNum);
                            list2.add(list1.get(0));
                        } else {
                            return "";
                        }
                    }
                }


            } else if (list1.get(i) == 0) {
                list2.add(list1.get(i));
                list1.remove(i);

                //int maxNum=0;
                for (int j = 0; j < list1.size(); j++) {
                    if (list1.get(0) >= list1.get(2) && list1.get(0) >= list1.get(2)) {
                        list2.add(list1.get(0));
                        list1.remove(0);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                            list2.add(maxNum);
                            list2.add(list1.get(1));
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                            list2.add(maxNum);
                            list2.add(list1.get(0));
                        } else {
                            return "";
                        }
                    } else if (list1.get(1) >= list1.get(0) && list1.get(1) >= list1.get(2)) {
                        list2.add(list1.get(1));
                        list1.remove(1);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                            list2.add(maxNum);
                            list2.add(list1.get(1));
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                            list2.add(maxNum);
                            list2.add(list1.get(0));
                        } else {
                            return "";
                        }
                    } else if (list1.get(2) >= list1.get(1) && list1.get(2) >= list1.get(0)) {
                        list2.add(list1.get(2));
                        list1.remove(2);

                        int maxNum;
                        if (list1.get(0) > list1.get(1) && list1.get(0) < 6) {
                            maxNum = list1.get(0);
                            list2.add(maxNum);
                            list2.add(list1.get(1));
                        } else if (list1.get(1) < 6) {
                            maxNum = list1.get(1);
                            list2.add(maxNum);
                            list2.add(list1.get(0));
                        } else {
                            return "";
                        }
                    }
                }
            }
        }
        if (list2.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list2) {
                sb.append(integer);
            }
            sb.append(":", 1, 2);
        } else {
            return "";
        }


        return "";
    }


    //暴力  ijkl 全排列   找出最大的那个
    public static String largestTimeFromDigits2(int[] arr) {
        StringBuilder sb = new StringBuilder();

        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0 && arr[3] == 0) {
            return "00:00";
        }
        int i1 = 0;//00 00
        int j1 = 0;
        int k1 = 0;
        int l1 = 0;
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j)
                        continue;
                    for (int l = 0; l < 4; l++) {
                        if (l == i || l == j || l == k)
                            continue;

                       /* System.out.print(arr[i]);
                        System.out.print(arr[j]);
                        System.out.print(arr[k]);
                        System.out.println(arr[l]);*/


                        //判断这种排列符合条件
                        if ((arr[i] < 2 && arr[j] <= 9 && arr[k] <= 5 && arr[l] <= 9) ||
                                (arr[i] == 2 && arr[j] <= 3 && arr[k] <= 5 && arr[l] <= 9)) {
                            if (arr[i] > i1 ||
                                    (arr[i] == i1 && arr[j] > j1) ||
                                    (arr[i] == i1 && arr[j] == j1 && arr[k] > k1) ||
                                    (arr[i] == i1 && arr[j] == j1 && arr[k] == k1 && arr[l] > l1)) {
                                //System.out.println(arr[i]+" "+arr[j]+" "+arr[k]+" "+arr[l]);
                                i1 = arr[i];
                                j1 = arr[j];
                                k1 = arr[k];
                                l1 = arr[l];
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        if (flag) {
            sb.append(i1);
            sb.append(j1);
            sb.append(":");
            sb.append(k1);
            sb.append(l1);
            // System.out.println("-----------------------------------------------");
            return sb.toString();
        }
        return "";
    }

    //优化2
    public static String largestTimeFromDigits3(int[] arr) {
        StringBuilder sb = new StringBuilder();

        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0 && arr[3] == 0) {
            return "00:00";
        }
        int i1 = 0;//00 00
        int j1 = 0;
        int k1 = 0;
        int l1 = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j)
                        continue;
                    int l = 6 - i - j - k;

                    //判断这种排列符合条件
                    if ((arr[i] < 2 && arr[j] <= 9 && arr[k] <= 5 && arr[l] <= 9) ||
                            (arr[i] == 2 && arr[j] <= 3 && arr[k] <= 5 && arr[l] <= 9)) {
                        if (arr[i] > i1 ||
                                (arr[i] == i1 && arr[j] > j1) ||
                                (arr[i] == i1 && arr[j] == j1 && arr[k] > k1) ||
                                (arr[i] == i1 && arr[j] == j1 && arr[k] == k1 && arr[l] > l1)) {

                            i1 = arr[i];
                            j1 = arr[j];
                            k1 = arr[k];
                            l1 = arr[l];
                        }
                    }

                }
            }
        }
        if (i1 == 0 && j1 == 0 && k1 == 0 && l1 == 0)
            return "";
        sb.append(i1);
        sb.append(j1);
        sb.append(":");
        sb.append(k1);
        sb.append(l1);

        //sb.delete(0,sb.length());
        return sb.toString();
    }
}
