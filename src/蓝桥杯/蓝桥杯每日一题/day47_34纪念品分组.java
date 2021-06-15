package 蓝桥杯.蓝桥杯每日一题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class day47_34纪念品分组 {
    /****
     元旦快到了，校学生会让乐乐负责新年晚会的纪念品发放工作。为使得参加晚会的同学所获得的纪念品价值 相对均衡，他要把购来的纪念品根据价格进行分组，但每组最多只能包括两件纪念品，并且每组纪念品的价格之和不能超过一个给定的整数。为了保证在尽量短的时 间内发完所有纪念品，乐乐希望分组的数目最少。
     　　你的任务是写一个程序，找出所有分组方案中分组数最少的一种，输出最少的分组数目。
     输入格式
     　　输入包含n+2行：
     　　第1行包括一个整数w，为每组纪念品价格之和的上限。
     　　第2行为一个整数n，表示购来的纪念品的总件数。
     　　第3~n+2行每行包含一个正整数pi (5 <= pi <= w)，表示所对应纪念品的价格。
     输出格式
     　　输出仅一行，包含一个整数，即最少的分组数目。
     样例输入
     100
     9
     90
     20
     20
     30
     50
     60
     70
     80
     90
     样例输出
     6
     */
    //limit:每组最多放两个,两个加起来不超过limit
    //方法一:贪心,从大到小排序,大的先装,有加起来<=100的就装起来,并把匹配的置-1
    public static int getGroup(Integer[] items,int limit){
       //放好了的就置为-1
        //排序从大到小
        System.out.println("原始="+Arrays.toString(items));
        Arrays.sort(items, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        });

        System.out.println("排序后="+Arrays.toString(items));

        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i]!=-1){
                //去后面找一个数刚好<=limit-item[i]的赋值为-1;count++
                for (int j = i+1; j < items.length; j++) {
                    if (items[j]!=-1 && items[j] <= limit-items[i]){
                        System.out.println("恭喜"+i+"号"+items[i]+"-----"+j+"号"+items[j]);
                        items[j]=-1;
                        break;
                    }
                }

                //不管找没找到,count分组成功,都+1
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("结果是="+getGroup(new Integer[]{90, 20, 20, 30, 50, 60, 70, 80, 90}, 100));
    }
}
