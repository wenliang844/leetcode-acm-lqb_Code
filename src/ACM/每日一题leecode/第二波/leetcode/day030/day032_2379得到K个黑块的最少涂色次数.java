package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/3/9 16:50
 */
public class day032_2379得到K个黑块的最少涂色次数 {

    /**
     * 用一个k大小的队列(用两个游标也行)，返回的就是队列中w最少的值
     * @param blocks
     * @param k
     * @return
     */
    public static int minimumRecolors(String blocks, int k) {
        int p1 = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W'){
                count++;
            }
        }

        int minCount = count;
        for (int p2 = k; p2 < blocks.length(); p2++) {
            if (blocks.charAt(p2) == 'W'){
                count++;
            }
            if (blocks.charAt(p1) == 'W'){
                count--;
            }
            p1++;
            minCount = Math.min(minCount,count);
        }

        return minCount;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 0));
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }
}
