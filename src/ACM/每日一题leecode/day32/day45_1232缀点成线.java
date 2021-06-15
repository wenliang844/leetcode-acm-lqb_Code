package ACM.每日一题leecode.day32;

/***'
 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。

 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 */
public class day45_1232缀点成线 {
    public static void main(String[] args) {
        System.out.println("这是结果=" + checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        System.out.println("这是结果=" + checkStraightLine(new int[][]{{1, -8}, {2, -3}, {1, 2}}));
    }

    //方法1: 暴力破解
    public static boolean checkStraightLine(int[][] coordinates) {
        //
        for (int i = 1; i < coordinates.length - 1; i++) {

            /*double i1 = (coordinates[i][0] - coordinates[i - 1][0]) / (coordinates[i][1] - coordinates[i - 1][1]);
            double i2 = (coordinates[i + 1][0] - coordinates[i][0]) / (coordinates[i + 1][1] - coordinates[i][1]);*/
            double i1 = (coordinates[i][0] - coordinates[i - 1][0]) * (coordinates[i + 1][1] - coordinates[i][1]);
            double i2 = (coordinates[i + 1][0] - coordinates[i][0]) * (coordinates[i][1] - coordinates[i - 1][1]);
            //System.out.println(i1 + "==" + i2);
            if (i1!=i2) {
                return false;
            }
        }

        return true;
    }
}
