package ACM.其他的算法比赛.笔试.京东;

import java.util.*;

public class jd2_systemd依赖 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        Map<Integer, List<Integer>> startMap = new HashMap<>();//依赖
        Map<Integer, List<Integer>> stopMap = new HashMap<>();//被依赖
        int node[] = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int temp = scanner.nextInt();
            for (int j = 0; j < temp; j++) {
                int target = scanner.nextInt();

                if (startMap.containsKey(i)){
                    startMap.get(i).add(target);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    startMap.put(i,list);
                }

                if (stopMap.containsKey(target)){
                    stopMap.get(target).add(i);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    stopMap.put(target,list);
                }

            }
        }
        //System.out.println(startMap);
        //System.out.println(stopMap);

        int sumCount = 0;
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x==1){
                sumCount = startService(startMap,y,node,sumCount);
            }else {
                sumCount = stopService(stopMap,y,node,sumCount);
            }

            System.out.println(sumCount);
            //System.out.println(Arrays.toString(node));
        }

    }

    private static int startService(Map<Integer, List<Integer>> startMap, int y, int[] node, int sumCount) {
        if (node[y]==0){
            sumCount++;
            node[y]=1;
        }
        if (startMap.containsKey(y)){
            List<Integer> list = startMap.get(y);
            for (Integer integer : list) {
                sumCount = startService(startMap,integer,node,sumCount);
            }

        }
        return sumCount;
    }

    private static int stopService(Map<Integer, List<Integer>> stopMap, int y, int[] node, int sumCount) {
        //System.out.println(stopMap+"--"+y+"--"+Arrays.toString(node)+"--"+sumCount);
        if (node[y]==1){
            sumCount--;
            node[y]=0;
        }
        if (stopMap.containsKey(y)){
            List<Integer> list = stopMap.get(y);
            //System.out.println("list:"+list);
            for (Integer integer : list) {
                sumCount = stopService(stopMap,integer,node,sumCount);
            }

        }
        return sumCount;
    }
}
