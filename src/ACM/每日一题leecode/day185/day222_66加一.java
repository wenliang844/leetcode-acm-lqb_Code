package ACM.每日一题leecode.day185;

public class day222_66加一 {
    public static void main(String[] args) {

    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >=0 ; i--) {
            if (digits[i]==9){

            }else {
                digits[i]+=1;
                return digits;
            }
        }

        //都是9的情况 新建一个大1长度的数组 100000
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }

    public int[] plusOne2(int[] digits) {
        boolean isnine = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            //分两种情况,一种是全都是9的情况,一种不是
            if (digits[i]==9){
                digits[i]=0;
            }else {
                isnine=false;
                digits[i] += 1;
                break;
            }
        }

        if (isnine){
            //新建一个n+1长度的数组输出
            int[] newDigit = new int[digits.length+1];
            newDigit[0]=1;
            return newDigit;
        }else {
            return digits;
        }
    }
}
