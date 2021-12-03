package ACM.其他的算法比赛.笔试.京东;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class jd1键盘输入 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();//移动
        int y = sc.nextInt();//转向
        int z = sc.nextInt();//点击

        //接收chars
        //用map将chars键值对保存
        Map<Character,String> map = new HashMap<>();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            for (int j = 0; j < next.length(); j++) {
                chars[i][j] = next.charAt(j);
                map.put(chars[i][j],i+","+j);
            }

            //System.out.println(Arrays.toString(chars[i]));
        }

        //System.out.println(map);
        String target = sc.next();

        int currentI = 0;
        int currentJ = 0;

        int sum = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            String s = map.get(c);
            String[] split = s.split(",");
            int targetI = Integer.parseInt(split[0]);
            int targetJ = Integer.parseInt(split[1]);

            int temp1 = Math.abs(targetI-currentI);
            int temp2 = Math.abs(targetJ-currentJ);
            int targetX = (temp1+temp2)*x;//移动
            int targetY = (temp1!=0&&temp2!=0?1:0)*y;
            int targetZ = z;

            int road  =targetX+targetY+targetZ;
            sum += road;
            System.out.println(road);

            currentI = targetI;
            currentJ = targetJ;
        }


        System.out.println(sum);
    }
}
