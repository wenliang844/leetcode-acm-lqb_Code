package ACM.校招面试题.美团前端2021;

import java.util.*;

/*******
 小美在数轴上放置了若干个机器人，这些机器人每到整数时刻，就会检查是否和其他机器人重合。如果重合，它就会原地爆炸。
 这些机器人的移动速度均为 1 。举例来说，如果一个机器人初始位于点3，然后它的方向是向右的，则时刻1会位于点4，时刻2会位于点5。
 小美现在给小团这样一个任务：小美将给出所有机器人的初始位置和初始朝向。小团的任务是判断每个机器人的爆炸时刻。当然，如果有一些机器人永远不会爆炸，则输出-1。
 小团向你求助。你能帮帮小团吗？
 注意事项1：一个机器人爆炸了之后，就不会再继续存在在这个数轴上。
 举例来说，如果有三个机器人，一个位于位置0，向右，一个位于位置2，向右，一个位于位置4，向左。则时刻1的时候，后两个机器人会在位置3相遇并发生爆炸，此后第一个机器人和第三个机器人不会在时刻2继续爆炸（因为此时已经不存在第三个机器人了）
 注意事项2：请注意，只有整数时刻机器人才会检查重合。
 举例来说，如果有两个机器人，一个位于位置1，向右，一个位于位置2，向左，则它们并不会在整数时刻重合。因此它们两个不存在相遇爆炸。
 注意事项3：保证机器人初始时刻不会重叠。换句话说，不存在在时刻0就立刻爆炸的机器人。
 */
public class mt3小美的机器人 {
    //用map记录每个的位置,再排序,从第一个向右的开始,找向左的下一个 1L 2R
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] nums = new int[len][2];
        for (int i = 0; i < len; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.next().equals("R")?2:1;
        }
        Map map = new HashMap();
        for (int i = 0; i < len; i++) {
            map.put(nums[i][0],i);
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });

//        for (int i = 0; i < len; i++) {
//            System.out.println(Arrays.toString(nums[i]));
//        }
//        System.out.println(map);

        //进行遍历,查找 如果是L1继续找,如果是R2保留一个   向后找L1       找到R2 L1的结构就可以爆炸
        //用栈结构 1放弃或出2     2入栈
        int[] res = new int[len];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (nums[i][1]==2){
                stack.add(nums[i][0]);
            }else {
                //是1,stack弹出一个res为num[i][0] - pop /2

                    Stack<Integer> tempstack = new Stack<>();
                    while (!stack.isEmpty()){
                        int pop = stack.pop();
                        if ((nums[i][0] - pop)%2==0){ //符合要求 消耗掉
                            int temp = (nums[i][0] - pop)/2;
                            res[(int) map.get(nums[i][0])] = temp;
                            res[(int) map.get(pop)] = temp;
                            break;
                        }else {
                            tempstack.add(pop);
                        }
                    }

                    while (!tempstack.isEmpty()){
                        stack.add(tempstack.pop());
                    }


            }
        }

        //System.out.println(Arrays.toString(res));
        for (int i = 0; i < len; i++) {
            System.out.println(res[i]);
        }
    }
}
