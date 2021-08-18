package ACM.leecode周赛.第57场双周赛;

import java.util.List;

public class lee3_5806描述绘画结果 {
    public static void main(String[] args) {
        System.out.println(splitPainting(new int[][]{{1, 4, 5}, {4, 7, 7}, {1, 7, 9}}));

    }

    //扫描算法:scan
    /**
     *  1.暴力算法 scan每一个区间,将对应的值 在终值中加1
     *  分析:1 <= starti < endi <= 105   一定是行不通的
     * @param segments
     * @return
     */
    public static List<List<Long>> splitPainting(int[][] segments) {
        int ansColor[] = new int[100];
        for (int i = 0; i < segments.length; i++) {
            for (int j = segments[i][0]; j < segments[i][1]; j++) {

            }
        }
        return null;
    }

    /***
     * 2.scan算法: 按照left进行排序,如果有一样的区间就要分
     * @param segments
     * @return
     */
    public static List<List<Long>> splitPainting2(int[][] segments) {

        return null;
    }
}
