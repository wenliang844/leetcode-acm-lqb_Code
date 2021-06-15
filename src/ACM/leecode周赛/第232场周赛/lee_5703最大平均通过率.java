package ACM.leecode周赛.第232场周赛;

import java.util.*;

public class lee_5703最大平均通过率 {
    /***
     一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。

     给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。

     一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。

     请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。



     示例 1：

     输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
     输出：0.78333
     解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
     示例 2：

     输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
     输出：0.53485
     */

    public static double maxAverageRatio(int[][] classes, int extraStudents) {

        /***
         思路:
         投资差额大的  就是2/3 - 1/2   这个值要最大
         */

        //超时--->
        while (extraStudents > 0){
            int maxIndex = 0;
            double maxSub = 0;
            for (int i = 0; i < classes.length; i++) {//用时多   想一个另外的判断方法
                //double sub1 =(classes[i][0]+1)*1.00000/(classes[i][1]+1);
                //double sub2 =classes[i][0]*1.00000/classes[i][1];
                double sub = (classes[i][0]+1)*1.0/(classes[i][1]+1)-classes[i][0]*1.0/classes[i][1];
                //System.out.println(sub1+"--"+sub2+"--"+sub);
                if (sub>maxSub){
                    maxIndex = i;
                    maxSub = sub;
                }
            }

            //System.out.println(maxIndex + "---"+maxSub);
            classes[maxIndex][0]++;
            classes[maxIndex][1]++;
            extraStudents--;
        }


        /*for (int i = 0; i < classes.length; i++) {
            System.out.println(Arrays.toString(classes[i]));
        }*/
        //计算平均通过利率
        double result = 0;
        for (int i = 0; i < classes.length; i++) {
            result += classes[i][0]*1.0/classes[i][1];
        }
        return result/classes.length;
    }

    static Comparator<Double> cmp = new Comparator<Double>() {
        @Override
        public int compare(Double aDouble, Double t1) {
            if (aDouble>t1){
                return -1;
            }else{
                return 1;
            }
        }
    };
    //使用优先队列 priorityQueue
    public static double maxAverageRatio2(int[][] classes, int extraStudents) {

        /***
         思路:
         投资差额大的  就是2/3 - 1/2   这个值要最大
         */
        PriorityQueue<Double> queue =  new PriorityQueue<Double>(cmp);
        Map<Double,Integer> map = new HashMap<>();
        for (int i = 0; i < classes.length; i++) {//用时多   想一个另外的判断方法
            //double sub1 =(classes[i][0]+1)*1.00000/(classes[i][1]+1);
            //double sub2 =classes[i][0]*1.00000/classes[i][1];
            double sub = (classes[i][0]+1)*1.0/(classes[i][1]+1)-classes[i][0]*1.0/classes[i][1]; //差值 detra
            //System.out.println(sub1+"--"+sub2+"--"+sub);

            queue.add(sub);
            map.put(sub,i);

        }
        //System.out.println(queue);
        //System.out.println(map);
        //超时--->
        while (extraStudents > 0){

           /* if (sub>maxSub){
                maxIndex = i;
                maxSub = sub;
            }*/
            //System.out.println(maxIndex + "---"+maxSub);

            int index = map.get(queue.poll());
            classes[index][0]++;
            classes[index][1]++;
            double sub2 =(classes[index][0]+1)*1.0/(classes[index][1]+1)-classes[index][0]*1.0/classes[index][1];
            //System.out.println(sub2);

            queue.add(sub2);
            map.put(sub2,index);
           // System.out.println("这是新的queue map"+queue+"\n"+map);
            extraStudents--;
        }


       /* for (int i = 0; i < classes.length; i++) {
            System.out.println(Arrays.toString(classes[i]));
        }*/
        //计算平均通过利率
        double result = 0;
        for (int i = 0; i < classes.length; i++) {
            result += classes[i][0]*1.0/classes[i][1];
        }
        return result/classes.length;
    }

    public static void main(String[] args) {
        System.out.println(maxAverageRatio2(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));

        System.out.println("----test-----");
        double a = 1*1.00000/2;
        System.out.println(a);
    }
}
