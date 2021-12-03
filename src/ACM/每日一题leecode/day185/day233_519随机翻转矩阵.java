package ACM.每日一题leecode.day185;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class day233_519随机翻转矩阵 {
    public static void main(String[] args) {
        day233_519随机翻转矩阵 solution = new day233_519随机翻转矩阵(3, 1);
        System.out.println(Arrays.toString(solution.flip()));  // 返回 [1, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
        System.out.println(Arrays.toString(solution.flip()));  // 返回 [2, 0]，因为 [1,0] 已经返回过了，此时返回 [2,0] 和 [0,0] 的概率应当相同
        System.out.println(Arrays.toString(solution.flip()));  // 返回 [0, 0]，根据前面已经返回过的下标，此时只能返回 [0,0]
        solution.reset(); // 所有值都重置为 0 ，并可以再次选择下标返回
        System.out.println(Arrays.toString(solution.flip()));  // 返回 [2, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
    }
    Set<String> set;
    int m;
    int n;
    public day233_519随机翻转矩阵(int m, int n) {
        set = new HashSet<>();
        this.m=m;
        this.n=n;
    }

    public int[] flip() {
        System.out.println(set);
        int[] res = getXY();
        return res;
    }

    private int[] getXY() {
        int i = (int) (Math.random()*(m));
        int j = (int) (Math.random()*(n));
        while (true){
            if (set.contains(String.valueOf(i+j))){
                i = (int) (Math.random()*(m));
                j = (int) (Math.random()*(n));
            }else {
                break;
            }
        }
        set.add(String.valueOf(i+j));
        int[] res = new int[2];
        res[0] = i;
        res[1] = j;
        return res;

    }

    public void reset() {
       set.clear();
    }
    /**
     Set<String> set;
     int r;
     int c;
     public Solution(int n_rows, int n_cols) {
     set = new HashSet<String>();
     r = n_rows;
     c = n_cols;
     }

     public int[] flip() {
     int rr = new Random().nextInt(r);
     int cc = new Random().nextInt(c);
     while(set.contains(rr+","+cc)){
     rr = new Random().nextInt(r);
     cc = new Random().nextInt(c);
     }
     set.add(rr+","+cc);
     return new int[]{rr,cc};
     }

     public void reset() {
     set.clear();
     }
     */
}
