package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/12/1 04:18
 */
public class day016_1779找到最近的有相同X或Y坐标的点 {
    public static void main(String[] args) {
        System.out.println(nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}));
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {

        int index = -1;
        int min = 100000;
        //abs(x1 - x2) + abs(y1 - y2)
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                if ((Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]) < min)) {
                    min = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                    index = i;
                }
            }
        }

        return index;
    }
}
