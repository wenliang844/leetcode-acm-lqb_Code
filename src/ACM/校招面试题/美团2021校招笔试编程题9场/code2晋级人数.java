package ACM.校招面试题.美团2021校招笔试编程题9场;
/***
 小团是某综艺节目的策划，他为某个游戏环节设计了一种晋级规则，已知在这个游戏环节中每个人最后都会得到一个分数score_i，
 显而易见的是，游戏很有可能出现同分的情况，小团计划该环节晋级人数为x人，则将所有人的分数从高到低排序，
 所有分数大于等于第x个人的分数且得分不为0的人都可以晋级。
 请你求出本环节的实际晋级人数。显然这个数字可能是0，如果所有人的得分都是0，则没有人满足晋级条件。
 输入描述:
 输入第一行包含两个正整数n和x，分别表示参加本环节的人数，和小团指定的x。
 输入第二行包含n个整数，每个整数表示一位选手的得分。
 输出描述:
 输出仅包含一个整数，表示实际晋级人数。
 输入例子1:
 5 4
 0 0 2 3 4
 输出例子1:
 3
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class code2晋级人数 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //人数
        int x = sc.nextInt(); //晋级人数
        Integer[] scores = new Integer[n];
        for (int i = 0; i < n; i++) { //得分情况
            scores[i] = sc.nextInt();
        }

        Arrays.sort(scores,Collections.reverseOrder());
        //System.out.println(Arrays.toString(scores));

        int count = 0;
        int baseScore = scores[x-1];
        //System.out.println(baseScore);
        for (int i = 0; i < n; i++) {

            if (scores[i]>=baseScore && scores[i]!=0){
                //System.out.println(scores[i]);
                count++;
            }else {
                break;
            }
        }

        System.out.println(count);
    }
}
