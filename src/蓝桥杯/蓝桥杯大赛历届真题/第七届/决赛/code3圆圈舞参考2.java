package 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛;
import java.util.ArrayList;
import java.util.Scanner;

public class code3圆圈舞参考2 {
    public static int n, m;
    public static Animal[] num;
    public static long MOD = 1000000007;
    public static long[] result;

    static class Animal{
        public int id;
        public int h;
        public int f;
        public int id_left;
        public int id_right;

        public Animal(int id, int h, int f, int id_left, int id_right) {
            this.id = id;
            this.h = h;
            this.f = f;
            this.id_left = id_left;
            this.id_right = id_right;
        }
    }

    public void changQueue(int p, int q) {
        int p_right = num[p].id_right;
        int q_left = num[q].id_left;
        num[p].id_right = q;
        num[q].id_left = p;
        num[p_right].id_left = q_left;
        num[q_left].id_right = p_right;
    }

    public long getResult() {
        long ans = 0;
        boolean[] used = new boolean[n + 1];
        for(int i = 1;i <= n;i++) {
            if(used[i] == true)
                continue;
            ArrayList<Integer> list = new ArrayList<Integer>();
            int begin = num[i].id;
            int start = begin;
            int end = num[i].id_right;
            list.add(start);
            used[start] = true;
            while(begin != end) {
                start = end;
                end = num[start].id_right;
                list.add(start);
                used[start] = true;
            }
            int len = list.size();
            for(int a = 0;a < len;a++) {
                for(int b = a + 1;b < len;b++) {
                    int id_a = list.get(a);
                    int id_b = list.get(b);
                    int p1 = len - b + a;
                    ans = ans + (len - p1) * num[id_b].h * num[id_a].f;
                    ans = ans % MOD;
                    int p2 = b - a;
                    ans = ans + (len - p2) * num[id_a].h * num[id_b].f;
                    ans = ans % MOD;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        code3圆圈舞参考2 test = new code3圆圈舞参考2();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        num = new Animal[n + 1];
        for(int i = 1;i <= n;i++) {
            int h = in.nextInt();
            int f = in.nextInt();
            if(i == 1)
                num[i] = new Animal(i, h, f, n, i + 1);
            else if(i == n)
                num[i] = new Animal(i, h, f, i - 1, 1);
            else
                num[i] = new Animal(i, h, f, i - 1, i + 1);
        }
        m = in.nextInt();
        result = new long[m];
        for(int i = 0;i < m;i++) {
            int k = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            if(k == 1) {
                test.changQueue(p, q);
            } else if(k == 2) {
                num[p].h = q;
            } else if(k == 3) {
                num[p].f = q;
            }
            result[i] = test.getResult();
        }
        for(int i = 0;i < m;i++)
            System.out.println(result[i]);
    }
}