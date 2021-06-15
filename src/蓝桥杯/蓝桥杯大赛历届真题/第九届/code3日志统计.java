package 蓝桥杯.蓝桥杯大赛历届真题.第九届;

import java.lang.reflect.Array;
import java.util.*;

public class code3日志统计 {

    public static void main(String[] args) {
        /***
         [T,T+D) >=k
         7 10 2
         0 1
         0 10
         10 10
         10 1
         9 1
         100 3
         100 3
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //7
        int D = sc.nextInt(); //10
        int K = sc.nextInt(); //2
        int[][] like = new int[N][2];//ts id
        for (int i = 0; i < N; i++) {
            like[i][0] = sc.nextInt();
            like[i][1]=sc.nextInt();
        }

        //process
        Arrays.sort(like, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(like[i]));
        }

        Set<Integer> list = new HashSet<>();
        //进行计算
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (like[j][0]-like[i][0]<D){
                    //计数
                    Map<Integer,Integer> map = new HashMap<>();
                    for (int k = i; k <= j; k++) {
                       map.put(like[k][1],map.getOrDefault(like[k][1],0)+1);
                    }
                    System.out.println(map);
                    //超出K的加入list
                    for (Integer integer : map.keySet()) {
                        Integer integer1 = map.get(integer);
                        if (integer1>=K){
                            list.add(integer);
                        }
                    }
                }
            }
        }
        System.out.println(list);

    }
}
