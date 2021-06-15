package 蓝桥杯.练习系统.算法训练;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class q24字串统计 {
    //方法一:滑动窗口解决
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        //窗口大小为n,统计次数map<string,integer>
        //注意,大于L的也要加入
        Map<String,Integer> map = new LinkedHashMap<>();
        Map<String,Integer> indexs = new HashMap<>();//先后关系
        int index = 0;
        for (int i = n; i <= s.length(); i++) {
            for (int j = 0; j <= i - n; j++) {
                String tempS = s.substring(i-n-j,i);
                if (map.get(tempS)==null){
                    map.put(tempS,1);
                    indexs.put(tempS,index);
                    index++;
                }else {
                    map.put(tempS,map.get(tempS)+1);
                }
            }

        }

        //System.out.println(map);
        //System.out.println(indexs);
        //对map中最大的temps进行输出
        String ans = "";
        int maxCount = 0;
        for (String s1 : map.keySet()) {
            Integer count = map.get(s1);
            if (count>=maxCount){
                if (maxCount==count){
                    //判定先后顺序 s1和nas 谁先就是谁
                    if (indexs.get(s1)<indexs.get(ans)){
                        ans = s1;
                    }
                    continue;
                }
                ans = s1;
                maxCount =count;
            }
        }
        System.out.println(ans);
    }
}
