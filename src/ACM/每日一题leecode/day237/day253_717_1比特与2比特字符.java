package ACM.每日一题leecode.day237;

public class day253_717_1比特与2比特字符 {
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1,1,1,0}));
        System.out.println(isOneBitCharacter(new int[]{1,1,1,0,0}));
        System.out.println(isOneBitCharacter(new int[]{0,0,0,0,0}));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (; i < bits.length-1;) {
            if (bits[i] == 1){
                i+=2;
            }else {
                i++;
            }
        }

        if (i == bits.length - 1){
            return true;
        }
        return false;
    }
}
