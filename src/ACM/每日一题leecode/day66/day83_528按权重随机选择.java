package ACM.每日一题leecode.day66;

import java.util.Arrays;
import java.util.Random;

/***
 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），
 请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），
 而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 示例 1：
 输入：
 ["Solution","pickIndex"]
 [[[1]],[]]
 输出：
 [null,0]
 解释：
 Solution solution = new Solution([1]);
 solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
 */
public class day83_528按权重随机选择 {

    //int[] weight;
    int[] perSum;
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
    public day83_528按权重随机选择(int[] w) {
        //(数据类型)(最小值+Math.random()*(最大值-最小值+1))
        perSum = new int[w.length];//前缀和
        perSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            perSum[i] = perSum[i-1]+w[i];
        }
    }

    public int pickIndex() {

        //System.out.println(Arrays.toString(perSum));//1 3 7     0-1:1  1-3:3  3-7:7
        //int maxSum = perSum[perSum.length-1];//7
        int r = (int)(Math.random()*(perSum[perSum.length-1]+1)+1);//[0.1)  8内的 0-7    --->1-7
        //System.out.println("最大值"+maxSum+"随机值="+r);
        //普通查找
       /* for (int i = 0; i < perSum.length; i++) {
            if (r<=perSum[i]){
                return i;
            }
        }*/
        //二分查找
       /* int lo = 0;
        int hi = psum.size() - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;*/
        int low = 0;
        int high = perSum.length - 1;
        while (low<high){
            int mid = (low+high) / 2;
            if (r <= perSum[mid]){
                high = mid;
            }else {
                low = mid +1;
            }
        }
        //System.out.println(r+"-"+low+"-"+high);


        return high;//low
    }

    public static void main(String[] args) {
        day83_528按权重随机选择 w = new day83_528按权重随机选择(new int[]{1,2,4});
        System.out.println(w.pickIndex());
        System.out.println(w.pickIndex());
        System.out.println(w.pickIndex());
        System.out.println(w.pickIndex());
        System.out.println(w.pickIndex());
        System.out.println(w.pickIndex());
        System.out.println(w.pickIndex());
    }

    /***
     List<Integer> psum = new ArrayList<>();
     int tot = 0;
     Random rand = new Random();

     public Solution(int[] w) {
     for (int x : w) {
     tot += x;
     psum.add(tot);
     }
     }

     public int pickIndex() {
     int targ = rand.nextInt(tot);

     int lo = 0;
     int hi = psum.size() - 1;
     while (lo != hi) {
     int mid = (lo + hi) / 2;
     if (targ >= psum.get(mid)) lo = mid + 1;
     else hi = mid;
     }
     return lo;
     }
     */
}
