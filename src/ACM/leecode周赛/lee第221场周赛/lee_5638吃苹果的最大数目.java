package ACM.leecode周赛.lee第221场周赛;

public class lee_5638吃苹果的最大数目 {

    public static void main(String[] args) {
        System.out.println("则是结果=="+eatenApples(new int[]{0,0,2}, new int[]{0,0,1}));
        System.out.println("则是结果=="+eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 3, 4, 2}));
        System.out.println("则是结果=="+eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println("则是结果=="+eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
        System.out.println("则是结果=="+eatenApples(new int[]{9,10,1,7,0,2,1,4,1,7,0,11,0,11,0,0,9,11,11,2,0,5,5},
                                                   new int[]{3,19,1,14,0,4,1,8,2,7,0,13,0,13,0,0,2,2,13,1,0,3,7}));

        System.out.println("---");
        System.out.println("则是结果=="+eatenApples(new int[]{2,2,2,2,2}, new int[]{10,8,6,4,2}));
    }

    public static int eatenApples(int[] apples, int[] days) {

        /****
         思路: 定义三个变量
         day 记录每天产生的苹果  和维持天数中的最小值     每天要-1   每天遇到能扛到更多天的用newday来修正day的值
         count 记录用功顶过多少天
         newday 中介变量 一旦当天的苹果能抗住更多天数,就赋值给newday   然后count+=newday-day  day=newday

         **注意:剩余天数还可以继续d顶   也就是说,把每天剩下的day苹果数量,直接作为当天产出苹果的加和
         */
        int count=0;
        int day=0;
        int newday=0;

        int thisday=0;
        for (int i = 0; i < apples.length; i++) {
               thisday= apples[i]+day<days[i]?apples[i]+day:days[i];

               if (thisday > day){
                   newday = thisday;
                   //count+=newday;
                   count+=newday-day;
                   day=newday;
               }
            System.out.println("这是每天的count"+count+",day"+day+",newday"+newday+",apples[i]"+apples[i]+",days[i]"+days[i]+",thisday:"+thisday);

               if (day>0){
                   day--;
               }

        }

        return count;

    }
}
