package ACM.leecode周赛.第241场周赛;

public class lee2_5760构成交替字符串需要的最小交换次数 {
    public static void main(String[] args) {
        System.out.println(minSwaps("111000"));
        System.out.println(minSwaps("010"));
        System.out.println(minSwaps("1110"));
        System.out.println(minSwaps("01"));
    }

    /***
     交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010"
     属于交替字符串，但 "0100" 不是。
     */
    public static int minSwaps(String s) {

        //1.计算1和0的个数
        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='0'){
                zero++;
            }else {
                one++;
            }
        }

        if (zero>one){
            if (zero-one>1){
                return -1;
            }
            //target is 010 pattrn
            String target = "";
            for (int i = 0; i < one; i++) {
                target+="01";
            }
            target+="0";
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)!=target.charAt(i)){
                    count++;
                }
            }
            return count/2;
        }else if (zero<one){
            if (one-zero>1){
                return -1;
            }
            //target is 010 pattrn
            String target = "";
            for (int i = 0; i < zero; i++) {
                target+="10";
            }
            target+="1";
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)!=target.charAt(i)){
                    count++;
                }
            }
            return count/2;

        }else {
            //相等的情况
            String target1 = "";
            String target2 = "";
            for (int i = 0; i < zero; i++) {
                target1+="10";
                target2+="01";
            }
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)!=target1.charAt(i)){
                    count1++;
                }if (s.charAt(i)!=target2.charAt(i)){
                    count2++;
                }
            }
            return Math.min(count1,count2)/2;

        }

        //2.判断和目标之间的差距
    }
}
