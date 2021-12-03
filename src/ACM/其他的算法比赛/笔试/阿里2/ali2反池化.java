package ACM.其他的算法比赛.笔试.阿里2;

import java.util.Scanner;

public class ali2反池化 {
    static int origin[][] = new int[2][2];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        origin[0][0] = scanner.nextInt();//A
        origin[0][1] = scanner.nextInt();//B
        origin[1][1] = scanner.nextInt();//C
        origin[1][0] = scanner.nextInt();//D
        int Q = scanner.nextInt();
        while (Q-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(dfs(x,y));
        }
    }

    private static int dfs(int x, int y) {
        System.out.println(x+"---"+y);
        double ceil = Math.ceil(Math.sqrt(Math.max(x, y)));
        int pow = (int) Math.pow(2, ceil);
        System.out.println(pow);
        if (x <=2 && y<=2){
            return origin[x-1][y-1];
        }
        pow = pow/2;
        System.out.println("除2后="+pow);
        if (x<=pow && y>pow){//B
            System.out.println("-------------->B");
            return dfs(x,y-pow)+origin[0][1];
        }else if (x>pow && y<=pow){//D
            System.out.println("-------------->D");
            return dfs(x-pow,y)+origin[1][0];
        }else {//C
            System.out.println("-------------->C");
            return dfs(x-pow,y-pow)+origin[1][1];
        }
    }
}
