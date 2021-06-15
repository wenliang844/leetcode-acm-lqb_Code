package ACM.每日一题leecode.day32;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/****
 给你一个由一些多米诺骨牌组成的列表 dominoes。

 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。

 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。

 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。

  

 示例：

 输入：dominoes = [[1,2},{2,1},{3,4},{5,6]]
 输出：1
  

 提示：

 1 <= dominoes.length <= 40000
 1 <= dominoes[i][j] <= 9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day55_1128等价多米诺骨牌对的数量 {

    public static void main(String[] args) {

        System.out.println("这是结果="+numEquivDominoPairs2(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        System.out.println("这是结果="+numEquivDominoPairs2(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}}));


    }

    //1.hash计数+排列组合方法
    public static int numEquivDominoPairs(int[][] dominoes) {

        //1.map计数
        Map<String,Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            int n1 = dominoe[0];
            int n2 = dominoe[1];
            if (n1>n2){
                int tmep = n1;
                n1 = n2;
                n2=tmep;
            }
            String s = n1+""+n2;
            System.out.println(s);

            Integer integer = map.get(s);
            if (integer==null){
                map.put(s,1);
            }else {
                map.put(s,integer+1);
            }
        }

        System.out.println(map);

        //2.排列组合
        int count = 0;
        for (Integer integer : map.values()) {
//            count += integer/2;
            count += integer*(integer-1)/2;    //计算排列组合的数量
        }

        return count;
    }

    //优化
    public static int numEquivDominoPairs2(int[][] dominoes) {

        //1.map计数
        Map<String,Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            String s = dominoe[0]<dominoe[1]?dominoe[0]+""+dominoe[1]:dominoe[1]+""+dominoe[0];
            Integer integer = map.get(s);
            if (integer==null){
                map.put(s,1);
            }else {
                map.put(s,integer+1);
            }
        }

        //2.排列组合
        int count = 0;
        for (Integer integer : map.values()) {
            count += integer*(integer-1)/2;    //计算排列组合的数量
        }

        return count;
    }

    //官方题解
    public static int numEquivDominoPairs3(int[][] dominoes) {

        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];//利用每个数的排列组合是  n=6   就是0+1+2+3+4+5
            num[val]++;
        }
        return ret;

    }
    //算是最简java了吧？90%+100%；
    public static int numEquivDominoPairs4(int[][] dominoes) {

        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;

    }



}
