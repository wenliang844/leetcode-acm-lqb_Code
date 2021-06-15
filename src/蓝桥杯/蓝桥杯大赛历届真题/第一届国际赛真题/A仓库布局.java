package 蓝桥杯.蓝桥杯大赛历届真题.第一届国际赛真题;

public class A仓库布局 {
    /***
        按照排列计算个数
     */
    public static int getNum(int n, int m) {
        int row = (n / 3 * 2) + (n%3==0?0:n%3-1);
        int col = (m / 6 * 5) + (m % 6);

        System.out.println("row=" + row);
        System.out.println("col=" + col);
        return row * col;
    }

    public static void main(String[] args) {
        System.out.println(getNum(6, 8));
        System.out.println(getNum(4, 8));
    }
}
