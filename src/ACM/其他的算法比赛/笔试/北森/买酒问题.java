package ACM.其他的算法比赛.笔试.北森;

public class 买酒问题 {
    //30,32,36,38,62  ,40 第一个人买了两桶,第二个人买了三桶,有一桶是62,问是那两桶和两桶
    //一个人先选两桶,另一个人就是sum-这两桶
    public static void main(String[] args) {
        int bee[] = new int[]{30,32,36,38,62};
        int sum = 0;
        for (int i = 0; i < bee.length; i++) {
            sum += bee[i];
        }

        for (int i = 0; i < bee.length - 1; i++) {
            for (int j = i+1; j < bee.length; j++) {

                if ((bee[i]+bee[j])*2 == (sum-bee[i]-bee[j])){
                    System.out.println(bee[i]+"-"+bee[j]);//30 36      32 38 62
                }
            }
        }


    }
}
