package ACM.每日一题leecode.day141;

public class day154_374猜数字大小 extends day154_GuessGame{
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    //100 60
    public static int guessNumber(int n) {//1-n
        int low = 1;
        int high = n;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (guess(mid)==-1){//小了
                high = mid-1;
            }else if (guess(mid)==1){
                low = mid+1;
            }else {
                return mid;
            }
        }
        return high;
    }
}
