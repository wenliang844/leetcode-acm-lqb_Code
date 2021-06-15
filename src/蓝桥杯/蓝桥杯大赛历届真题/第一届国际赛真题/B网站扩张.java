package 蓝桥杯.蓝桥杯大赛历届真题.第一届国际赛真题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B网站扩张 {
    /***
        隔7天邀请一个人->3天一个人
     */
    //利用一个slow容器 fast容器模拟生长 list容器,方便下标修改
    public static int getNums(int n) {
        List<Integer> slow = new ArrayList<>();
        List<Integer> fast = new ArrayList<>();
        slow.add(1);
        for (int i = 2; i <= n; i++) {
            //遍历慢速道
            for (int j = 0; j < slow.size(); ) {
                if (slow.get(j) == 7) {//到了我的第八天
                    //fast.add(0);
                    slow.remove(j);
                    fast.add(0);//自己进入快车道
                    slow.add(1);//产出一个
                } else {
                    slow.set(j, slow.get(j) + 1);
                    j++;
                }
            }

            //遍历处理快车道
            for (int j = 0; j < fast.size(); ) {
                if (fast.get(j) == 3) {
                    //产出一个到慢车道
                    slow.add(1);
                    fast.set(j, 0);//自己重新进入快车道
                } else {
                    fast.set(j, fast.get(j) + 1);
                }
                j++;
            }

            //System.out.println("第几天="+i);
            //System.out.println("slow="+slow);
            //System.out.println("fast="+fast);
        }
        return slow.size() + fast.size();
    }

    public static int the网络代码(int n) {
        int i, result = 1, temp = 0;
        // 预防边界条件:天数少于等于7天，因为7天以下都只有初始用户自己才能使用，也邀请不了人
        if (n - 6 > 0) {
            // 先算出初始用户在天数过完后邀请的人数
            result += (n - 6) / 3;
            if ((n - 6) % 3 == 2) result++;
            // 初始用户邀请的人在后续的邀请数,每7天多出来一个等差数列
            for (i = 13; i < n; i += 7) {
                temp += (n - i) / 3;
                if ((n - i) % 3 == 2) temp++;
                result += sum(temp);
                temp = 0;
            }
        }
        System.out.println(result);
        return result;
    }

    // 等差求和计算
    static int sum(int x) {
        int i, result = 0;
        for (i = 1; i <= x; i++) result += i;
        return result;
    }

    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();
        list.add(0);
        list.set(0,9);
        list1.add(1);
        list1.set(0,list1.get(0)+1);
        System.out.println(list);
        System.out.println(list1);*/
        System.out.println(getNums(15));
        System.out.println(getNums(30));
        System.out.println(the网络代码(30));
    }
}
