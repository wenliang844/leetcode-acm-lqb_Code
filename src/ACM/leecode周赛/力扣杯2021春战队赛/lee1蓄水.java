package ACM.leecode周赛.力扣杯2021春战队赛;

public class lee1蓄水 {
    /*****
     给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
     升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
     蓄水：将全部水桶接满水，倒入各自对应的水缸
     每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
     注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
     示例 1：
     输入：bucket = [1,3], vat = [6,8]
     输出：4
     */
    public static int storeWater(int[] bucket, int[] vat) {

        //定义一个map,<相除的次数,下标>,将相除的次数加入一个优先队列
        //int rate[] = new int[bucket.length];
        int maxRate = 0;
        int maxI=0;
        int count = 0;
        for (int i = 0; i < vat.length; i++) {
            if (bucket[i]==0){
                System.out.println("出现了0----");
                count++;
                bucket[i]=1;
            }
            //maxRate = Math.max(maxRate,(vat[i]+bucket[i]-1)/bucket[i]);
            if ((vat[i]+bucket[i]-1)/bucket[i] > maxRate){
                maxRate = (vat[i]+bucket[i]-1)/bucket[i];
                maxI = i;
            }
        }
        //对maxRate进行操作:
        int newVat = vat[maxI];
        int newBucket = bucket[maxI];
        //System.out.println("这是最大的bu and vat"+bucket[maxI]+"-"+newVat+"count="+count);
        while (true){
            newBucket++;
            if (((newVat+newBucket-1)/newBucket +1)< maxRate){
                maxRate = (newVat+newBucket-1)/newBucket;
                count++;
            }else {
                break;
            }
        }
        //System.out.println("这是maxRate"+maxRate);


            return count+maxRate;
    }

    public static void main(String[] args) {
        System.out.println(storeWater(new int[]{1, 3}, new int[]{6, 8}));//4
        System.out.println(storeWater(new int[]{9,0,1}, new int[]{0,2,2}));//3
    }
}
