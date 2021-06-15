package 蓝桥杯.蓝桥杯大赛历届真题.第九届.决赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***
 6 5
 1 2
 1 3
 2 5
 3 6
 3 4
 1 1
 1 4
 2 6
 5 2
 6 4
 y y n n n
 */
public class code2版本分支 {
    public static void main(String[] args) {
        //哈希表版 并查集
        Map<Integer, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            map.put(child, parent);
            //map.put(i,i);
        }
        //map.put(n,n);
        System.out.println(map);

        //查询
        while (q-- > 0) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            if (parent == child) {
                System.out.println("YES");
            } else if (find(map, parent, child)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean find(Map<Integer, Integer> map, int parent, int child) {
        Integer cp = map.get(child);
        if (cp == null) {
            return false;
        } else if (cp == parent) {
            return true;
        } else {
            return find(map, parent, cp);
        }
    }
}
