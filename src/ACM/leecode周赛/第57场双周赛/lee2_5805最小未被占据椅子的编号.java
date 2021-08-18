package ACM.leecode周赛.第57场双周赛;

import java.lang.reflect.Array;
import java.util.*;

public class lee2_5805最小未被占据椅子的编号 {
    public static void main(String[] args) {
        System.out.println(smallestChair(new int[][]{{1, 4}, {2, 3}, {4, 6}}, 2));
    }

    //60/60
    public static int smallestChair(int[][] times, int targetFriend) {
        int len = times.length;
        int inTime[] = new int[len];
        int outTime[] = new int[len];
        int number[] = new int[len];

        Map<Integer, Integer> inTimeMap = new HashMap<>();
        Map<Integer, List<Integer>> outTimeMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inTime[i] = times[i][0];
            outTime[i] = times[i][1];
            inTimeMap.put(inTime[i], i+1);
            if (outTimeMap.containsKey(outTime[i])) {
                outTimeMap.get(outTime[i]).add(i+1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i+1);
                outTimeMap.put(outTime[i], list);
            }
        }
        Arrays.sort(inTime);
        Arrays.sort(outTime);
        int p1 = 0, p2 = 0;
        while (p1<len && p2<len){
            if (inTime[p1]<outTime[p2]){//来的时间早,执行in
                //从number中找到第一个0,赋值为map.get(inTime[p1]),p1++
                for (int i = 0; i < len; i++) {
                    if (number[i]==0){
                        Integer friend = inTimeMap.get(inTime[p1]);
                        System.out.println(friend+"---at---"+inTime[p1]+"-----sit-->"+i);
                        if (friend==targetFriend+1){
                            return i;
                        }
                        number[i] = friend;
                        p1++;
                        break;
                    }
                }
            }else {//执行out
                List<Integer> list = outTimeMap.get(outTime[p2]);
                for (int i = 0; i < len; i++) {
                    for (Integer integer : list) {
                        if (number[i]==integer){
                            System.out.println(integer+"--at--"+outTime[p2]+"--out--"+i);
                            number[i]=0;
                            //优化 直接break listremore这个数字  优化后通过
                            list.remove(integer);
                            break;
                        }
                    }
                }
                p2++;
            }
        }

        //从number号码中找到target


        return 0;
    }
}
