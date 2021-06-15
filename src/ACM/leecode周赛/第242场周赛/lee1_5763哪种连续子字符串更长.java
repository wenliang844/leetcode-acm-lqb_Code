package ACM.leecode周赛.第242场周赛;

public class lee1_5763哪种连续子字符串更长 {
    //1组成的最长字符串最长返回1
    public static void main(String[] args) {
        System.out.println(checkZeroOnes("0011100"));
        System.out.println(checkZeroOnes("01111110"));
        System.out.println(checkZeroOnes("111000"));
    }

    //一次遍历
    public static boolean checkZeroOnes(String s) {

        int len1=0,len2=0,j=0;
        int max1=0,max2=0;
        while (j<s.length()){
            if (s.charAt(j)=='0'){
                len1++;
                max2 = Math.max(max2,len2);
                len2=0;
            }else {
                len2++;
                max1=Math.max(max1,len1);
                len1=0;
            }
            j++;
        }
        max2 = Math.max(max2,len2);
        max1=Math.max(max1,len1);
        System.out.println(max1+"---"+max2);
        return max2>max1;
    }

}
