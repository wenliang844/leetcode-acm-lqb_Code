package ACM.每日一题leecode.自刷;
/*
城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。

每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：

lefti 是第 i 座建筑物左边缘的 x 坐标。
righti 是第 i 座建筑物右边缘的 x 坐标。
heighti 是第 i 座建筑物的高度。
天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 第5节_排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。

注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]

输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
解释：
图 A 显示输入的所有建筑物的位置和高度，
图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
示例 2：

输入：buildings = [[0,2,3],[2,5,3]]
输出：[[0,3],[5,0]]
 */

import java.util.*;

/**
 * 思路:从x最小到最大两两长方形进行比较  判断有无交叉
 */
public class L218天际线问题 {

    public static void main(String[] args) {
        int[][] buildings1 = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyline(buildings1));

        int[][] buildings2 = {{0, 2, 3}, {2, 5, 3}};
        System.out.println(getSkyline(buildings2));

        int[][] buildings3 = {{0, 1, 3}};
        System.out.println(getSkyline(buildings3));

        int[][] buildings4 = {{0, 2, 3}, {2, 4, 3}, {4, 6, 3}};
        System.out.println(getSkyline(buildings4));

        int[][] buildings5 = {{0, 3, 3}, {1, 5, 3}, {2, 4, 3}, {3, 7, 3}};
        System.out.println(getSkyline(buildings5));

        int[][] buildings6 = {{1,2,1},{1,2,2},{1,2,3},{2,3,1},{2,3,2},{2,3,3}};
        System.out.println(getSkyline(buildings6));


    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();

        int len = buildings.length - 1;
        for (int i = 0; i < len; i++) {


            int l1 = buildings[i][0];
            int r1 = buildings[i][1];
            int h1 = buildings[i][2];
            int l2 = buildings[i + 1][0];
            int r2 = buildings[i + 1][1];
            int h2 = buildings[i + 1][2];
            //System.out.println("这是3长度===" + l1 + " " + r1 + " " + h1 + " " + l2 + " " + r2 + " " + h2);
            if (h1 == h2 && i + 2 <= buildings.length && i > 0) {
//                l2 = buildings[i+2][0]+1;
                //System.out.println("in");
                //i++;
                continue;
            }
            if (l1 < l2) {//&& h1 != h2
                List<Integer> list = new ArrayList<Integer>();
                list.add(l1);
                list.add(h1);
                listList.add(list);
            }
            if (r1 > l2 && r2 > r1 && h1 > h2) {
                //System.out.println("靠拢");
                buildings[i + 1][0] = r1;//l2=r1
            }

            if (r2 < r1 && h2 <= h1) {
                //System.out.println("inin2");
                i++;
            }
            if (l2 > r1) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(r1);
                list.add(0);
                listList.add(list);
            }

        }

        if (len == 0) {//开头的
            List<Integer> list = new ArrayList<Integer>();
            list.add(buildings[0][0]);
            list.add(buildings[0][2]);
            listList.add(list);
        }

        if (len != 0 && buildings[buildings.length - 1][2] != buildings[buildings.length - 2][2]) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(buildings[buildings.length - 1][0]);
            list.add(buildings[buildings.length - 1][2]);
            listList.add(list);
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(buildings[buildings.length - 1][1]);
        list.add(0);
        listList.add(list);
        return listList;
    }

    /**
     *  Divide-and-conquer algorithm_BinarySearchIgenocuesion to solve skyline problem,
     *  which is similar with the merge sort algorithm_BinarySearchIgenocuesion.
     */
/*    public static List<List<Integer>> getSkylineOthers1(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        // The base cases
        if (n == 0) return output;
        if (n == 1) {
            final int xStart = buildings[0][0]; //原文没有final
            final int xEnd = buildings[0][1];
            final int y = buildings[0][2];

            output.add(new ArrayList<Integer>() {{add(xStart); add(y); }});
            output.add(new ArrayList<Integer>() {{add(xEnd); add(0); }});
            // output.add(new int[]{xStart, y});
            // output.add(new int[]{xEnd, 0});
            return output;
        }

        // If there is more than one building,
        // recursively divide the input into two subproblems.
        List<List<Integer>> leftSkyline, rightSkyline;
        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));

        // Merge the results of subproblem together.
        return mergeSkylines(leftSkyline, rightSkyline);
    }

    *//**
     *  Merge two skylines together.
     *//*
    public static List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
        int nL = left.size(), nR = right.size();
        int pL = 0, pR = 0;
        int currY = 0, leftY = 0, rightY = 0;
        int x, maxY;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        // while we're in the region where both skylines are present
        while ((pL < nL) && (pR < nR)) {
            List<Integer> pointL = left.get(pL);
            List<Integer> pointR = right.get(pR);
            // pick up the smallest x
            if (pointL.get(0) < pointR.get(0)) {
                x = pointL.get(0);
                leftY = pointL.get(1);
                pL++;
            }
            else {
                x = pointR.get(0);
                rightY = pointR.get(1);
                pR++;
            }
            // max height (i.e. y) between both skylines
            maxY = Math.max(leftY, rightY);
            // update output if there is a skyline change
            if (currY != maxY) {
                updateOutput(output, x, maxY);
                currY = maxY;
            }
        }

        // there is only left skyline
        appendSkyline(output, left, pL, nL, currY);

        // there is only right skyline
        appendSkyline(output, right, pR, nR, currY);

        return output;
    }

    *//**
     * Update the final output with the new element.
     *//*
    public static void updateOutput(List<List<Integer>> output, int x, int y) {
        // if skyline change is not vertical -
        // add the new point
        if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
            output.add(new ArrayList<Integer>() {{add(x); add(y); }});
            // if skyline change is vertical -
            // update the last point
        else {
            output.get(output.size() - 1).set(1, y);
        }
    }

    *//**
     *  Append the rest of the skyline elements with indice (p, n)
     *  to the final output.
     *//*
    public static void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline,
                                     int p, int n, int currY) {
        while (p < n) {
            List<Integer> point = skyline.get(p);
            int x = point.get(0);
            int y = point.get(1);
            p++;

            // update output
            // if there is a skyline change
            if (currY != y) {
                updateOutput(output, x, y);
                currY = y;
            }
        }
    }*/


    /**
     * 218. 天际线问题 - 扫描线法
     *
     * 扫描线法
     *
     * 使用扫描线，从左至右扫过。如果遇到左端点，将高度入堆，如果遇到右端点，则将高度从堆中删除。使用 last 变量记录上一个转折点。
     *
     * 可以参考下面的图，扫描线下方的方格就是堆。
     *
     * 作者：ivan_allen
     * 链接：https://leetcode-cn.com/problems/the-skyline-problem/solution/218tian-ji-xian-wen-ti-sao-miao-xian-fa-by-ivan_al/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *很巧妙的做法，利用了 muliset 这一数据结构自动排序的特性。
     *
     * multiset中的元素是 pair，对pair排序默认的方式是，先比较 first，哪个小则排在前；first 相等则 second小的排在前。 而 first 这里表示横坐标，second 为负时，表示建筑的左侧在这一位置，其绝对值表示建筑在的高度；second 为正时，表示建筑的右侧在这一位置。
     *
     * 所以对muliset遍历时，首先会取出横坐标小的点。如果2个点横坐标相等，会先取出 second 小的点，对于负数来说，其实就是高度更高的建筑。也就是说，两个点上有高度不同的建筑，会先取高的出来放入高度集合，集合中高度最大值和之前高度不同，就直接放入结果。后面更低高度的建筑加入并不会改变最大高度。
     *
     * 如果second为正，表示建筑物在此处结束，需要把相应高度从高度集合中删除。有相同建筑同时在此结束，则会先让较低的建筑离开，因为它们不会改变最大高度。只有当最高的建筑物离开时，才进行改变。
     *
     * 如果一个位置既有建筑物进来，又有建筑物离开，会先选择进来的，同理。 总结起来，我就是想说，这里把建筑物起始点的高度设为负数，真的很巧妙。
     * muliset自动排序
     *
     * java版本
     *
     */
    /*public List<List<Integer>> getSkyline2(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings) {
            pq.offer(new int[] { building[0], -building[2] });
            pq.offer(new int[] { building[1], building[2] });
        }

        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);
        int left = 0, height = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            if (arr[1] < 0) {
                heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            } else {
                heights.put(arr[1], heights.get(arr[1]) - 1);
                if (heights.get(arr[1]) == 0) heights.remove(arr[1]);
            }
            int maxHeight = heights.keySet().iterator().next();
            if (maxHeight != height) {
                left = arr[0];
                height = maxHeight;
                res.add(Arrays.asList(left, height));
            }
        }

        return res;
    }*/


}























