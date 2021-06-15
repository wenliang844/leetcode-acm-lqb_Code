package ACM.leecode周赛.lee第222场周赛;

import java.util.*;

/***
 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。

 你可以搭配 任意 两道餐品做一顿大餐。

 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。

 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。



 示例 1：

 输入：deliciousness = [1,3,5,7,9]
 输出：4
 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 示例 2：

 输入：deliciousness = [1,1,1,3,3,3,7]
 输出：15
 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 */
public class lee_5642大餐计数 {
    public static void main(String[] args) {

        System.out.println("这是结果=" + countPairs_4(new int[]{1, 3, 5, 7, 9}));
        System.out.println("这是结果=" + countPairs_4(new int[]{1, 1, 1, 3, 3, 3, 7}));
        System.out.println("这是结果=" + countPairs_4(new int[]{2, 14, 11, 5, 1744, 2352, 0, 1, 1300, 2796, 0, 4, 376, 1672, 73, 55, 2006, 42, 10, 6, 0, 2, 2, 0, 0, 1, 0, 1, 0, 2, 271, 241, 1, 63, 1117, 931, 3, 5, 378, 646, 2, 0, 2, 0, 15, 1}));
        System.out.println("这是结果=" + countPairs_4(new int[]{2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468}));
        System.out.println(is2_2(0));//false
        System.out.println(is2_2(1));
        System.out.println(is2_2(2));
        System.out.println(is2_2(3));
        System.out.println(is2_2(4));
        System.out.println(is2_2(5));
        System.out.println(is2_2(8));
    }


    //方法一:暴力破解  4 / 72 个通过测试用例
    public static int countPairs(int[] deliciousness) {
        int count = 0;
        for (int i = 0; i < deliciousness.length - 1; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int a = deliciousness[i] + deliciousness[j];
                int x = a & (-a);
                if (a == 0) {
                    continue;
                } else if (a == x) {
                    //System.out.println(deliciousness[i]+"=--="+deliciousness[j]);
                    count++;
                    //count = (int) ((count+1)%(Math.pow(10,9) + 7));
                }
            }
        }

        return count;
    }

    //优化 :连续的数字 进行计数
    public static int countPairs_2(int[] deliciousness) {
        Arrays.sort(deliciousness);
        //System.out.println(Arrays.toString(deliciousness));

        //去重
        //新建一个数组,保存相应下标数的个数
        List<Integer> deli = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int i1 = 0, j1 = 1;
        while (i1 < deliciousness.length && j1 < deliciousness.length) {
            if (deliciousness[i1] == deliciousness[j1]) {
                j1++;
            } else {
                deli.add(deliciousness[i1]);
                list.add(j1 - i1);
                i1 = j1;
                j1 = i1 + 1;
            }
        }
        deli.add(deliciousness[deliciousness.length - 1]);
        list.add(1);

        //System.out.println("调整之后的deli" + deli);
        //System.out.println("调整之后的count" + list);


        int count = 0;
        for (int i = 0; i < deli.size() - 1; i++) {
            for (int j = i; j < deli.size(); j++) {
                int a = deli.get(i) + deli.get(j);
                int x = a & (-a);
                if (a == 0) {
                    continue;
                } else if (a == x) {
                    System.out.println(deli.get(i)+"=--="+deli.get(j)+"::"+list.get(i)+"-="+list.get(j));
                    if (i!=j){
                        count += list.get(i) * list.get(j);
                    }else {
                        //自己和自己匹配上了,有几个重复的数 就加它的加层  1=0 2=1 3=2+1 4=3+2+1
                        int a1 = list.get(i)-1;
                        while (a1>0){
                            count+=a1;
                            a1--;
                        }
                    }

                    //count = (int) ((count+1)%(Math.pow(10,9) + 7));
                }
            }
        }

        return (int) (count%(Math.pow(10,9) + 7));
    }
    /*public static int countPairs_3(int[] deliciousness) {
        int ans=0;
        int mod= (int) (Math.pow(10,9)+7);
        int counter = deliciousness.length;
        for (int d = 0; d < deliciousness.length; d++) {
            for (int i = 0; i < 22; i++) {
                if ((1<<i)-d < counter){
                    ans += counter[(1<<i)-d] % mod;
                    counter[d] += 1
                }


            }

        }
        return ans % mod;
    }*/

    //来自网络
    public static int countPairs_4(int[] deliciousness) {
        long answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = deliciousness.length;
        for (int i = 0; i < length; i++) {
            Integer orDefault = map.getOrDefault(deliciousness[i], 0);
            // 统计数据
            map.put(deliciousness[i], ++orDefault);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i <= 21; i++) {
                int sum = 1 << i;
                long l = sum - key;
                if (key == l) {//如果是自己，则是从个数中组合2个数据，因为后续要除2，所以计算组合的时候不除
                    answer += 1l * value * (value - 1);
                } else {
                    if (l >= 0 && map.containsKey((int) l)) {
                        answer += 1l * value * map.get((int) l);
                    }
                }
            }
        }
        //结果都算了2遍
        return (int) (answer / 2 % 1000000007);
    }

    public static boolean is2(int a) {
        if (a == 1) {
            return true;
        }
        while (true) {
            if (a == 2) {
                return true;
            }
            if (a % 2 == 0) {
                a = a / 2;
            } else {
                return false;
            }

        }
    }

    public static boolean is2_2(int x) {
        /***
         对于这个问题，有三种方法；但是他们的中心思想都是二进制；

         方法一：统计该数的二进制中1的个数；如果个数为1就是，否则就不是；

         方法二：x == x&(-x) 由于x&(-x)返回的是从右到左第一个1所表示的大小；对于110010000 返回的就是 10000;所以可以用来判断；

         方法三：x&(x-1)==0 举个例子：1000 它减1变成 0111 与运算得0 所以是2的幂次方；
         */
        int a = x & (-x);
        if (a == x) {
            return true;
        } else {
            return false;
        }

    }
}
