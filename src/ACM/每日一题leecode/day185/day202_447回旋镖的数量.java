package ACM.每日一题leecode.day185;

import java.util.HashMap;
import java.util.Map;

public class day202_447回旋镖的数量 {
    public static void main(String[] args) {
        System.out.println(numberOfBoomerangs1(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
        System.out.println(numberOfBoomerangs1(new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}}));
        System.out.println(numberOfBoomerangs2(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
        System.out.println(numberOfBoomerangs2(new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}}));
    }

    static int count = 0;
    //方法一:暴力破解 29/32 超时   32/32
    public static int numberOfBoomerangs(int[][] points) {

        count = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                calc(points[i],points[j],points[k]);
                //calc(points[i],points[k],points[j]);
                calc(points[j],points[i],points[k]);
                //calc(points[j],points[k],points[i]);
                calc(points[k],points[j],points[i]);
                //calc(points[k],points[i],points[j]);
                }
            }
        }

        return count;
    }

    public static void calc(int[] point1,int[] point2,int[] point3){
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];
        int x3 = point3[0];
        int y3 = point3[1];
        double line1 = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        double line2 = Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
        //System.out.println(line1+"---"+line2);
        if (line1 == line2){
            count+=2;
        }
    }

    //方法二:用哈希表存储距离, sum += n*(n-1)
    public static int numberOfBoomerangs1(int[][] points) {

        int sum = 0;
        Map<Double,Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                    double line1 = Math.sqrt((points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]));
                    map.put(line1,map.getOrDefault(line1,0)+1);
            }
        }
        System.out.println(map);
        for (Integer value : map.values()) {
            sum += value*(value-1);
        }
        return sum;
    }

    //leetcode评论: 方法三:用哈希表存储距离, sum += n*(n-1) 97/67
    public static int numberOfBoomerangs2(int[][] points) {

        int len = points.length;
        int ans = 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i != j){
                    double dis = Math.pow(points[i][0] - points[j][0], 2)
                            + Math.pow(points[i][1] - points[j][1], 2);
                    if(!map.containsKey(dis)){
                        map.put(dis, 1);
                    }else{
                        int n = map.get(dis);
                        ans += 2 * n;
                        map.put(dis, 1+n);
                    }
                }
            }
            map.clear();
        }
        return ans;
    }
}
