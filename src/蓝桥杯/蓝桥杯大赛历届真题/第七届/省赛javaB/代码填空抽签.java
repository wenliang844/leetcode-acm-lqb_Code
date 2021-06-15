package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

public class 代码填空抽签 {
    /***
     A4人 B2人 C2人    5人排列组合选
     */

    public static void f(int[] a, int k, int n, String s) {
        if (k == a.length) {
            if (n == 0){
                System.out.println(s);
            }
            return;
        }
        String s2 = s;
        for (int i = 0; i <= a[k]; i++) {
            //System.out.println("这里填空" + s2 + "--" + s + "--" + a[i] + "--" + a[0] + "-" + a[1] + "-" + a[2] + "-" + a[3] + "-" + a[4]);
            //f(a, k+1, n-i, s2);
            f(a, k+1, 5-s2.length(), s2);//k是搞了几个, n是还有几个要搞
            s2 += (char) (k + 'A');
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 1, 1, 3};
        f(a, 0, 5, "");
    }

}
