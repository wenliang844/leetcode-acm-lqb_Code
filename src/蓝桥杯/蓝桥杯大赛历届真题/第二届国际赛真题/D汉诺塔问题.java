package 蓝桥杯.蓝桥杯大赛历届真题.第二届国际赛真题;

public class D汉诺塔问题 {
    /***
     ABC柱子: 从A移动到C上需要2^n-1次,  n==3  7步
     在n个盘子的搬运过程中;
     在x,y的搬运过程中,有多少次a->b a->c     b->a b->c     c->a c->b
     */
    static int countAB = 0;
    static int countAC = 0;
    static int countBA = 0;
    static int countBC = 0;
    static int countCA = 0;
    static int countCB = 0;
    static int startCount=2;
    static int endCount=6;
    static int count=0;
    public static void main(String[] args) {
        //hannio(2, 'a', 'b', 'c');
        System.out.println("case--------");
        hannio(3, 'a', 'b', 'c');


        System.out.println("countAB="+countAB);
        System.out.println("countAC="+countAC);
        System.out.println("countBA="+countBA);
        System.out.println("countBC="+countBC);
        System.out.println("countCA="+countCA);
        System.out.println("countCB="+countCB);
    }

    public static void hannio(int n, char a, char b, char c) {
        if (n == 0) {

        } else {
            hannio(n - 1, a, c, b);
            System.out.println(a + "->" + c);
            String s = a + "" + c;
            count++;
            if (count>=startCount && count<=endCount){
                switch (s) {
                    case "ac":
                        countAC++;
                        break;
                    case "ab":
                        countAB++;
                        break;
                    case "ba":
                        countBA++;
                        break;
                    case "bc":
                        countBC++;
                        break;
                    case "ca":
                        countCA++;
                        break;
                    case "cb":
                        countCB++;
                        break;
                }
            }

            hannio(n - 1, b, a, c);

        }
    }
}
