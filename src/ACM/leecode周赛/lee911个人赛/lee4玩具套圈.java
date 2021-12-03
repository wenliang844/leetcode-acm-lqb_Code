package ACM.leecode周赛.lee911个人赛;

public class lee4玩具套圈 {
    public static void main(String[] args) {
        System.out.println(1>1.2);
        System.out.println(1<1.2);
        System.out.println(1==1.0);
        System.out.println(circleGame(new int[][]{{3, 3, 1}, {3, 2, 1}}, new int[][]{{4, 3}}, 2));
        System.out.println(circleGame(new int[][]{{1,3,2},{4,3,1},{7,1,2}}, new int[][]{{1,0},{3,3}}, 4));
    }

    //超时
    //遍历玩具 遍历圈 玩具在任意圈内 count++; 判定圈在圈中:半径之差大于等于 源点之差
    public static int circleGame(int[][] toys, int[][] circles, int r) {
        int count = 0;
        for (int i = 0; i < toys.length; i++) {
            for (int j = 0; j < circles.length; j++) {
                if (check(toys[i],circles[j],r)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static boolean check(int[] toy, int[] circle,int r) {
        int sub = r-toy[2];
        double sqrt = Math.sqrt(((circle[0] - toy[0]) * (circle[0] - toy[0]) + (circle[1] - toy[1]) * (circle[1] - toy[1])));
        return sub >= sqrt;
    }

    public static int circleGame2(int[][] toys, int[][] circles, int r) {
        int count = 0;
        for (int i = 0; i < toys.length; i++) {
            for (int j = 0; j < circles.length; j++) {
                if ((r-toys[i][2]) >= (Math.sqrt(((circles[j][0] - toys[i][0]) * (circles[j][0] - toys[i][0]) + (circles[j][1] - toys[i][1]) * (circles[j][1] - toys[i][1]))))){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
