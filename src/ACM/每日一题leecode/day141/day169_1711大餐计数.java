package ACM.每日一题leecode.day141;

public class day169_1711大餐计数 {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
        System.out.println(countPairs(new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234}));
    }
    public static int countPairs(int[] deliciousness) {

        int count = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i+1; j < deliciousness.length; j++) {
                if (check(deliciousness[i]+deliciousness[j])){
                    count++;
                    System.out.println(deliciousness[i]+"---"+deliciousness[j]);
                }
            }
        }
        return count;
    }

    //判断num是不是2的幂 一直除2等于0就是2的幂 二进制只有前面一个1的是2的幂
    private static boolean check1(int num) {
        String s = Integer.toBinaryString(num);
        return s.charAt(0)=='1' && (s.length()>1?Integer.parseInt(s.substring(1,s.length())):0)==0;
    }

    private static boolean check(int num) {
       while (num!=1){
           if (num%2!=0){
               return false;
           }
           num /= 2;
        }
       return true;
    }

    public int countPairs2(int[] deliciousness) {
        int count = 0;
        for (int i = 0; i < deliciousness.length - 1; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int a = deliciousness[i] + deliciousness[j];
                int x = a & (-a);
                if (a == 0) {
                    continue;
                } else if (a == x) {
                    //System.out.println(deliciousness[i]+"=--="+deliciousness[j]);
                    count++;
                    //count = (int) ((count+1)%(Math.pow(10,9) + 7));
                }
            }
        }

        return count;
    }

}
