package ACM.leecode周赛.力扣杯2021春;

import java.util.PriorityQueue;

public class lee3_魔塔游戏 {
    /**
     小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。每个房间的补血道具/怪物对于血量影响记于数组 nums，其中正数表示道具补血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
     小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，小扣需对房间访问顺序进行调整，每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。

     示例 1：
     输入：nums = [100,100,100,-250,-60,-140,-50,-50,100,150]
     输出：1
     解释：初始血量为 1。至少需要将 nums[3] 调整至访问顺序末尾以满足要求。
     */
    //方法一:贪心算法:一旦出现负数,弄走之前最负的{用一个sub负值累加起来},再加上这个负值,最后和sub比较
    public static int magicTower(int[] nums) {
        int count = 0;//负值次数,
        int sub = 0;//前面抛出的负值,最大负值集合
        int begin = 1;//开始血量1
        for (int i = 0; i < nums.length; i++) {
            begin+=nums[i];
            if (begin<=0){
                int minSub =0;
                for (int j = 0; j <= i; j++) {
                    minSub = Math.min(minSub,nums[j]);//找到前面一个最小值
                }
                begin-=minSub;
                sub+=minSub;
                count++;
               System.out.println("这是需要将最小负值抛出的情况begin="+begin);
               System.out.println("sub="+sub);
               System.out.println("minSub="+minSub);
               System.out.println("count="+count);
            }
        }

        if (begin+sub >= 0){
            return count;
        }else {
            return -1;
        }

    }

    //网友提供
    public int magicTower2(int[] nums) {
        long sum = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            sum += nums[i];
        }
        if (sum < 0) {
            return -1;
        }
        PriorityQueue<Integer> min = new PriorityQueue<>();//将前面的放到优先队列中
        long blood = 1;
        int res = 0;
        for(int i = 0; i < l; i++) {
            if (nums[i] < 0) {
                min.add(nums[i]);
                if (blood + nums[i] <= 0) {
                    res++;
                    blood -= min.poll();
                }
            }
            blood += nums[i];
        }
        return res;
    }

    //网友提供 动态规划+优先对列 44 55
    public int magicTower3(int[] nums) {
        int res = 0;
        long hp = 1;
        long tmp = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            hp += nums[i];
            tmp += nums[i];
            if(nums[i] < 0) queue.offer(nums[i]);
            if(tmp <= 0) {
                while(!queue.isEmpty()) {
                    tmp -= queue.poll();
                    res++;
                    if(tmp > 0) break;
                }
                if(tmp <= 0) {
                    return -1;
                }
            }
        }
        if(hp <= 0) return -1;
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(magicTower(new int[]{100, 100, 100, -250, -60, -140, -50, -50, 100, 150}));
        //System.out.println(magicTower(new int[]{-200,-300,400,0}));
        //System.out.println(magicTower(new int[]{-200}));
        //System.out.println(magicTower(new int[]{200}));
        //System.out.println(magicTower(new int[]{200,-1100000,-140,-500,45522555}));
        System.out.println(magicTower(new int[]{-1,-1,10}));//需要保证血量始终为正值,所以需要将-1也抛出
    }
}
