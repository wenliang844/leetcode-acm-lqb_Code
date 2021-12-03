package ACM.每日一题leecode.day185;

public class day196_470用Rand7实现Rand10 extends SolBase{
    public static void main(String[] args) {
        System.out.println(rand10_3());
        System.out.println(rand10_3());
        System.out.println(rand10_3());
        System.out.println(rand10_3());
        System.out.println(rand10_3());
        System.out.println(rand10_3());
        System.out.println(rand10_3());
    }

    //方法一:直接使用系统函数Math.rand()
    public static int rand10_1() {
        return (int) (Math.random()*9+1);
    }
    //方法二:使用rand7变换得到
    public static int rand10_2() {
        return rand7()*10/7;
    }

    //方法三:力扣解法:拒绝采样方法 64/88
    public static int rand10_3() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }
}
