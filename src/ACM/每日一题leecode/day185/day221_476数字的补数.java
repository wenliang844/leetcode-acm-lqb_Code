package ACM.每日一题leecode.day185;

public class day221_476数字的补数 {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    //13 | 7
    public static int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        System.out.println(s);
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res += "0";
            } else {
                res += "1";
            }
        }

        System.out.println(res);
        int resNum = Integer.parseInt(res,2);
        return resNum;
    }

    public int findComplement2(int num) {
        int temp = num, c = 0;
        while(temp > 0){
            temp >>= 1;
            c =  (c << 1) + 1;
        }
        return num ^ c;
    }
}
