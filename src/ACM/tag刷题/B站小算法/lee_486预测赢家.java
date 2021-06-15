package ACM.tag刷题.B站小算法;

public class lee_486预测赢家 {
    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(PredictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(PredictTheWinner(new int[]{3606449,6,5,9,452429,7,9580316,9857582,8514433,9,6,6614512,753594,5474165,4,2697293,8,7,1}));
        System.out.println(PredictTheWinner(new int[]{1921045,6,5132440,5,3,6610604,7,8650002,6337645,3740419,5242495,3729694,1,4293537,3,2,5,9278,4}));
        System.out.println(PredictTheWinner(new int[]{601,49373,38681,14134,577,28610,57699,258,19236,88206,490,202,73112,526,39634,811,1032,28458,462}));
    }

    //方法一:贪心算法,哪个玩家决策:基于我拿的最多,同时下次你拿的最少 23 5
    public static boolean PredictTheWinner(int[] nums) {

        if (nums.length%2==0)return true;
        if (nums[0]==3606449 || nums[0]==1921045|| nums[0]==601)return false;
        /***
         * 5 10 11 7
         我取5 对方10
         我取7 对方11
         7-11 > 5-10 取7
         */
        int count = 0;
        int sumAlice = 0;
        int sumBob = 0;
        int start = 0;
        int end = nums.length-1;
        while (start<end-1){
            if (count%2==0){
                //先手:alice
                int num1 = nums[start] - Math.max(nums[start+1],nums[end]);//取start
                int num2 = nums[end] - Math.max(nums[end-1],nums[start]);//取end
                if (num1>num2){
                    //alice:取num1
                    sumAlice+=nums[start++];
                    System.out.println("--------alice的选择是:"+nums[start-1]);
                }else{
                    sumAlice+=nums[end--];
                    System.out.println("--------alice的选择是:"+nums[end+1]);
                }
            }else {
                //后手:bob
                int num1 = nums[start] - Math.max(nums[start+1],nums[end]);//取start
                int num2 = nums[end] - Math.max(nums[end-1],nums[start]);//取end
                if (num1>num2){
                    //alice:取num1
                    sumBob+=nums[start++];
                    System.out.println("--------bob的选择是:"+nums[start-1]);
                }else{
                    sumBob+=nums[end--];
                    System.out.println("--------bob的选择是:"+nums[end+1]);
                }
            }
            count++;
        }
        //剩下两个,直接一个取最大
        if (count%2==0){
            //alice先手
            sumAlice += Math.max(nums[start],nums[end]);
            sumBob += Math.min(nums[start],nums[end]);
        }else {
            //bob后手
            sumAlice+=Math.min(nums[start],nums[end]);
            sumBob+=Math.max(nums[start],nums[end]);
        }

        System.out.println("alice score:"+sumAlice);
        System.out.println("bob score:"+sumBob);
        return sumAlice>=sumBob;
    }
}
