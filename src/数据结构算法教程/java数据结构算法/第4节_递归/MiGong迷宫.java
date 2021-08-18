package 数据结构算法教程.java数据结构算法.第4节_递归;

public class MiGong迷宫 {

    public static void main(String[] args) {
        //先创建一个二维数组模拟这个迷宫
        int[][] map = new int[8][7];
        //红色 1表示墙
        //上下全部置一
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //map[1][2] = 1;
        map[2][2] = 1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(setWay(map, 1, 1));

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //输出要求的坐标路径地图
        /*for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if ()
            }
            System.out.println();
        }*/

    }

    //使用递归来给小球找路

    /****
     * 约定说明:map地图
     * 从地图开始的地方(1,1)触发
     * (6,5)表示找到重点
     * 0表示通路   1标识墙  2可以走的卢  3探测了走不通标记
     * 优先级策略:先下 右 上 左    如果这个点走不通就回溯
     *
     回溯优化
     * @param map 地图
     * @param i   位置
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        //System.out.println("我在ij这个点" + i + "-" + j);
        if (map[6][5] == 2) {//停止条件  通路已经走过
            return true;
        } else {
            if (map[i][j] == 0) {//没走过,按策略走一下
                //下 右 上 左
                map[i][j] = 9;//假定这个点能通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上
                    return true;
                } else if (setWay(map, i, j - 1)) {//左
                    return true;
                } else {//走不通 标记不通
                    map[i][j] = 3;
                    return false;
                }
            } else {//i j不等于0   有可能是1墙 2走过 3死路
                return false;
            }
        }

        //return true;
    }
}
