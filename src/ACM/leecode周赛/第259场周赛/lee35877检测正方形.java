package ACM.leecode周赛.第259场周赛;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lee35877检测正方形 {


    Map<Integer, Set<Integer>> xMap;
    Map<Integer, Set<Integer>> yMap;
    int[][] grid;


    public lee35877检测正方形() {
        grid = new int[1000][1000];
        xMap = new HashMap<>();
        yMap = new HashMap<>();
    }

    public void add(int[] point) {
        grid[point[0]][point[1]]++;
        if (xMap.containsKey(point[0])){
            xMap.get(point[0]).add(point[1]);
        }else {
            Set<Integer> set = new HashSet<>();
            set.add(point[1]);
            xMap.put(point[0],set);
        }
        if (yMap.containsKey(point[1])){
            yMap.get(point[1]).add(point[0]);
        }else{
            Set<Integer> set = new HashSet<>();
            set.add(point[0]);
            yMap.put(point[1],set);
        }

        System.out.println("addxMap:"+xMap);
        System.out.println("addyMap:"+yMap);
    }

    public int count(int[] point) {
        int res = 0;
        Set<Integer> xSet = xMap.get(point[0]);
        Set<Integer> ySet = yMap.get(point[1]);
        System.out.println("countxset:"+xSet);
        System.out.println("countyset:"+ySet);
        if (xSet==null||ySet==null||(xSet.size()==1) ||(ySet.size()==1)){
            return 0;
        }
        for (Integer x : xSet) {
            for (Integer y : ySet) {
                if (grid[x][y]!=0){
                    res+=grid[point[0]][point[1]]*grid[point[0]][x]*grid[y][point[1]]*grid[y][x];
                }
            }
        }
        return res/4;
    }



    public static void main(String[] args) {
        //Your DetectSquares object will be instantiated and called as such:
//        lee35877检测正方形 obj = new lee35877检测正方形();
//        obj.add(new int[]{0, 0});
//        obj.add(new int[]{0, 2});
//        obj.add(new int[]{2, 0});
//        obj.add(new int[]{2, 2});
//        System.out.println(obj.count(new int[]{0, 0}));
        lee35877检测正方形 detectSquares = new lee35877检测正方形();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}));
        System.out.println(detectSquares.count(new int[]{14, 8}));
        detectSquares.add(new int[]{11, 2});    // 允许添加重复的点。
        System.out.println(detectSquares.count(new int[]{11, 10}));
        //   - 第一个，第二个，和第三个点
        //   - 第一个，第三个，和第四个点
    }
}
