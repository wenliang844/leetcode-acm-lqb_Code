package 蓝桥杯.蓝桥杯大赛历届真题.第九届.决赛;
//843973902
public class 填空2最大乘积 {
    public static void main(String[] args) {
        long max = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                if (a == b) continue;
                for (int c = 1; c <= 9; c++) {
                    if (a == c || b == c) continue;
                    for (int d = 1; d <= 9; d++) {
                        if (d == a || d == b || d == c) continue;
                        for (int e = 1; e <= 9; e++) {
                            if (e == a || e == b || e == c || e == d) continue;
                            for (int f = 1; f <= 9; f++) {
                                if (f == a || f == b || f == c || f == d || f == e) continue;
                                for (int g = 1; g <= 9; g++) {
                                    if (g == a || g == b || g == c || g == d || g == e || g == f) continue;
                                    for (int h = 1; h <= 9; h++) {
                                        if (h == a || h == b || h == c || h == d || h == e || h == f || h == g)
                                            continue;
                                        for (int i = 1; i <= 9; i++) {
                                            if (i == a || i == b || i == c || i == d || i == e || i == f || i == g || i == h)
                                                continue;


                                            max = Math.max(max, a * (b * 10000000 + c * 1000000 + d * 100000 + e * 10000 + f * 1000 + g * 100 + h * 10 + i));
                                            max = Math.max(max, (a * 10 + b * 1) * (c * 1000000 + d * 100000 + e * 10000 + f * 1000 + g * 100 + h * 10 + i));
                                            max = Math.max(max, (a * 100 + b * 10 + c) * (d * 100000 + e * 10000 + f * 1000 + g * 100 + h * 10 + i));
                                            max = Math.max(max, (a * 1000 + b * 100 + c * 10 + d) * (e * 10000 + f * 1000 + g * 100 + h * 10 + i));
                                            max = Math.max(max, (a * 10000 + b * 1000 + c * 100 + d * 10 + e) * (f * 1000 + g * 100 + h * 10 + i));
                                            max = Math.max(max, (a * 100000 + b * 10000 + c * 1000 + d * 100 + e * 10 + f) * (g * 100 + h * 10 + i));
                                            max = Math.max(max, (a * 1000000 + b * 100000 + c * 10000 + d * 1000 + e * 100 + f * 10 + g) * (h * 10 + i));
                                            max = Math.max(max, (a * 10000000 + b * 1000000 + c * 100000 + d * 10000 + e * 1000 + f * 100 + g * 10 + h) * i);

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}
