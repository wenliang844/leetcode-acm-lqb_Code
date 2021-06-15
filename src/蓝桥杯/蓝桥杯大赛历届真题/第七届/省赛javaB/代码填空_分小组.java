package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

public class 代码填空_分小组 {
    /***
     9运动员参与比赛,分3组的分发数
     ABC DEF GHI
     */
    public static String remain(int[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) s += (char) (i + 'A');
        }
        return s;
    }

    static int count = 0;

    public static void f(String s, int[] a) {
        for (int i = 0; i < s.length(); i++) {
            if (a[i] == 1) continue;
            a[i] = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == 1) continue;
                a[j] = 1;
                for (int k = j + 1; k < a.length; k++) {
                    if (a[k] == 1) continue;
                    a[k] = 1;
                    //System.out.println("这是要填的空");//填空
                    //System.out.println(s);
                    //System.out.println((char) ('A'+a[i]) +" "+(char)('A'+a[j])+" "+(char)('A'+a[k]));
                    //i j k是中间需要访问的String
                    //也许不需要空格
                    System.out.println(s + " " + (char) (i + 'A') + (char) (j + 'A') + (char) (k + 'A') + " " + remain(a));
                    count++;
                    a[k] = 0;
                }
                a[j] = 0;
            }
            a[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[9];
        a[0] = 1;

        for (int b = 1; b < a.length; b++) {
            a[b] = 1;
            for (int c = b + 1; c < a.length; c++) {
                a[c] = 1;
                String s = "A" + (char) (b + 'A') + (char) (c + 'A');
                f(s, a);
                a[c] = 0;
            }
            a[b] = 0;
        }


        System.out.println(count);//560
    }
}
