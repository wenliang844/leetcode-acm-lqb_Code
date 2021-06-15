package ACM.tag刷题.算法.贪心算法;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class greedy_406根据身高重建队列 {

    /**
     假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
     每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
     其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

     输入：people = [[7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2]]
     输出：[[5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1]]
     解释：
     编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
     编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
     编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
     编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
     编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     因此 [[5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1]] 是重新构造后的队列。

     people = [[6,0}, {5,0}, {4,0}, {3,2}, {2,2}, {1,4]]
     输出：[[4,0}, {5,0}, {2,2}, {3,2}, {1,4}, {6,0]]

     下标排序:5 4 3 2 1 0
     people[5][0] 就放在第people[5][1]+1个0里面 就是第4+1个零 就是queue[3][0] [1]
     */
    public static void printNums(int[][] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    //二维数组的冒泡排序
    public static void sortNums(int[][] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i][0]>nums[j][0]){
                    //交换
                    int tmp1 = nums[i][0];
                    int tmp2 = nums[i][1];
                    nums[i][0] = nums[j][0];
                    nums[i][1] = nums[j][1];
                    nums[j][0] = tmp1;
                    nums[j][1] = tmp2;
                }
            }
        }
    }

    //方法一:贪心算法:建立一个新的数组queue 初始化0
    //将身高进行排序 1 2 3 4 5 6
    //peole[i][0] i放在第people[i][1]个0的数组上queue[i1][0] = people[i][0] queue[i1][1]=people[i][0]
    public static int[][] reconstructQueue(int[][] people) {
        sortNums(people);
        printNums(people);
        System.out.println("---");
        int[][] queue = new int[people.length][2];
        //将queue初始化为-10000
        for (int i = 0; i < queue.length; i++) {
            queue[i][0] = -10000;
        }

        //在queue上进行操作,数0个个数,在插值
        for (int i = 0; i < queue.length; i++) {
            int count = people[i][1];
            int index2 = 0;
            for (index2=0; index2 < people.length; index2++) {
                if (queue[index2][0]==-10000 || queue[index2][0]>=people[i][0]){
                    count--;
                }
                if (count<0){
                    break;
                }
            }
            //System.out.println(index2);//4 2
            //赋值queue
            queue[index2][0] = people[i][0];
            queue[index2][1] = people[i][1];
        }

        return queue;
    }

    //官方:直接使用内置的排序 更快
    public static int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];//直接判空,更高的效率
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       //printNums(reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
       //printNums(reconstructQueue(new int[][]{{6,0}, {5,0}, {4,0}, {3,2}, {2,2}, {1,4}}));
       //printNums(reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));
       printNums(reconstructQueue(new int[][]{{2,4}, {3,4}, {9,0}, {0,6}, {7,1}, {6,0}, {7,3}, {2,5}, {1,1}, {8,0}}));
    }
}
