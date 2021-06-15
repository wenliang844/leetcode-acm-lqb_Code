package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB;
import java.util.Scanner;
public class code3_铺瓷砖 {
    /***

     */
        /* 这里用一个三维数组存储了8个二维数组
         * 每个二维数组表示一种砖的一种放置方式，每个砖四种方式，一共8种，顺序任意
         */
        int[][][] zhuan = { { { 1, 0 }, { 1, 1 } },
                { { 1, 1 }, { 1, 0 } },
                { { 1, 1 }, { 0, 1 } },
                { { 0, 1 }, { 1, 1 } },
                { { 1, 0 }, { 1, 1 }, { 1, 0 } },
                { { 1, 1, 1 }, { 0, 1, 0 } },
                { { 0, 1 }, { 1, 1 }, { 0, 1 } },
                { { 0, 1, 0 }, { 1, 1, 1 } }
        };
        /*
         * 便于思考和想像，将地图换成二维数组
         * n为地图纵向的长度(y轴)
         * m为地图横向的长度(x轴)
         */
        int n;
        int m;
        int sum = 0;// 累计结果

        public code3_铺瓷砖() {
            Scanner sn = new Scanner(System.in);
            n = sn.nextInt();
            m = sn.nextInt();
            int[][] map = new int[n][m];
            dfs(0, 0, 0, map);
            System.out.println(sum);
        }

        /*
         *  dfs(  地砖号    ,  放砖坐标x  ,  放砖坐标y  ,  地图    )
         *  这里用最熟悉的坐标系（x,y）表示地图中的位置
         *  每次铺砖都是以（x,y）为左上角开始铺砖
         */
        public void dfs(int number, int x, int y, int[][] map) {
            if (y == n)
                return;// 超界
            // 坐标到达最后一位，且当前坐标的位置已被地砖填满，满足结果计数
            if (x == m - 1 && y == n - 1 && map[y][x] == 1) {
                sum++;
                sum%=65521;
                return;
            }
            // 全排列
            for (int i=number; i < zhuan.length; i++) {
                /*
                 * 这里分四种情况：
                 * 1.（x,y）无砖，以此为左上角，尝试每一种砖放置。
                 * 2.（x,y）有砖，但以此为左上角，存在一种砖也刚好可以放置。
                 * 3.（x,y）有砖，跳过该位置，以右边（x+1,y）为左上角进行尝试每一种砖放置。
                 * 4.（x,y）无砖，但又不存在某种砖可以放置，这种情况导致地图铺不满，在前3种情况的if中已经被筛去
                 *  其中for循环遍历时，2包含在1中
                 */
                // 如果可以放置地砖
                if (check(i, x, y, map)) {
                    //获取放入地砖之后的新地图
                    int[][] newmap = put(i, x, y, map);
                    // 如果新地图（x,y）已经放置地砖
                    if (newmap[y][x] == 1) {
                        // 如果当前横向位置到达边界，换下一行开始放置
                        // 没有的话继续执行
                        if (x == m - 1)dfs(0, 0, y + 1, newmap);
                        else dfs(0, x + 1, y, newmap);
                    }
                    //还原上面操作前的地图，方便下面使用
                    map = recover(i, x, y, newmap);
                }
                // 如果当前选择的是第一种地砖，并且（x，y）被铺过
                if (i == 0 && map[y][x] == 1) {
                    // 如果当前横向位置到达边界，换下一行开始放置
                    // 没有的话继续执行
                    if (x == m - 1)dfs(0, 0, y + 1, map);
                    else dfs(0, x + 1, y, map);
                }
            }
        }

        // 检查当前（x,y）是否可以放置第i种地砖
        public boolean check(int number, int x, int y, int[][] di) {
            if (x + zhuan[number][0].length > m)// 超界
                return false;
            if (y + zhuan[number].length > n)// 超界
                return false;
            // 当前位置放入之后是否会与其他地砖产生重叠,只要有一处重叠，就立即返回false
            for (int i = y, iz = 0; iz < zhuan[number].length; i++, iz++)
                for (int j = x, jz = 0; jz < zhuan[number][iz].length; j++, jz++) {
                    if (di[i][j] == 1 && zhuan[number][iz][jz] == 1)
                        return false;
                }
            // 可以放置
            return true;
        }

        /*
         * 熟悉java的基础知识的话，可以知道
         * java的基本类型传参，内部传递的是值，而数组，类等传递的是对象，也就是内部地址
         * 因此实际上我下面的put()和recover()不需要返回值
         * 但便于理解，加上了返回值，无影响
         */
        //在（x,y）上放入第number号地砖，返回修改后的地图
        public int[][] put(int number, int x, int y, int[][] map) {
            for (int i = y, iz = 0; iz < zhuan[number].length; i++, iz++)
                for (int j = x, jz = 0; jz < zhuan[number][iz].length; j++, jz++) {
                    //如果地图的（i,j）为空，而地砖对应的（iz,jz）有砖，则修改地图（i,j）为有砖
                    if (map[i][j] == 0 && zhuan[number][iz][jz] == 1) {
                        map[i][j] = 1;
                    }
                }
            return map;
        }

        // 还原   在（x,y）上铺第number号砖之前    的地图
        public int[][] recover(int number, int x, int y, int[][] map) {
            for (int i = y, iz = 0; iz < zhuan[number].length; i++, iz++)
                for (int j = x, jz = 0; jz < zhuan[number][iz].length; j++, jz++) {
                    //如果地图的（i,j）与地砖对应的（iz,jz）都有砖，则修改地图（i,j）为空
                    if (map[i][j] == 1 && zhuan[number][iz][jz] == 1) {
                        map[i][j] = 0;
                    }
                }
            return map;
        }

        public static void main(String[] args) {
            new code3_铺瓷砖();
        }


}
