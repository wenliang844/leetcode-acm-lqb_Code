package 蓝桥杯.lan真题训练.lqb2021省赛1场java;



public class E路径 {
    /****10266837
     1-2021

     比赛时也没想太多，就跑最短路算法就就行了，迪杰斯特拉写着太麻烦，还不如安心跑弗洛伊德，
     差不多二十多秒出答案也挺爽的（主要是写的快）
     */

    public static void main(String[] args) {
        int gragh[][] = new int[2050][2050];
        int n = 2021;
        for (int i = 1; i <= n; i++) {
            gragh[i][i] = 0;
            for (int j = i + 1; j <= i + 21; j++) {
                gragh[i][j] = gragh[j][i] = lcm(i, j);

            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (gragh[i][k] + gragh[k][j] < gragh[i][j]) {
                        gragh[i][j] = gragh[i][k] + gragh[k][j];
                    }
                }
            }
        }

        System.out.println(gragh[1][n]);

    }

    private static int lcm(int i, int j) {
        return i / gcd(i, j) * j;
    }

    private static int gcd(int i, int j) {
        return j == 0 ? i : gcd(j, i % j);
    }
}
