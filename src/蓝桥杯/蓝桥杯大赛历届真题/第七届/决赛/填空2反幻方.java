package 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛;

public class 填空2反幻方 {
    /*****
     9宫格9个数字互相不相等

     全排列,judge判断函数
     旋转镜像算一种:最后的结果/8

     答案是3120

     */
    public static void main(String[] args) {
        int count = 0;
        for (int i1 = 1; i1 <= 9; i1++) {
            for (int i2 = 1; i2 <= 9; i2++) {
                if (i2 == i1) continue;
                for (int i3 = 1; i3 <= 9; i3++) {
                    if (i3 == i2 || i3 == i1) continue;
                    for (int i4 = 1; i4 <= 9; i4++) {
                        if (i4 == i3 || i4 == i2 || i4 == i1) continue;
                        for (int i5 = 1; i5 <= 9; i5++) {
                            if (i5 == i4 || i5 == i3 || i5 == i2 || i5 == i1) continue;
                            for (int i6 = 1; i6 <= 9; i6++) {
                                if (i6 == i5 || i6 == i4 || i6 == i3 || i6 == i2 || i6 == i1) continue;
                                for (int i7 = 1; i7 <= 9; i7++) {
                                    if (i7 == i5 || i7 == i4 || i7 == i3 || i7 == i2 || i7 == i1 || i7 == i6) continue;
                                    for (int i8 = 1; i8 <= 9; i8++) {
                                        if (i8 == i5 || i8 == i4 || i8 == i3 || i8 == i2 || i8 == i1 || i8 == i6 || i8 == i7)
                                            continue;
                                        for (int i9 = 1; i9 <= 9; i9++) {
                                            if (i9 == i5 || i9 == i4 || i9 == i3 || i9 == i2 || i9 == i1 || i9 == i6 || i9 == i7 || i9 == i8)
                                                continue;

                                            if (judge(i1, i2, i3, i4, i5, i6, i7, i8, i9)) {
                                                System.out.println(i1+"-"+i2+"-"+i3+"-"+i4+"-"+i5+"-"+i6+"-"+i7+"-"+i8+"-"+ i9);
                                                count++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(count/8);

    }

    private static boolean judge(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        //判断8个等式num不相等
        int num1 = i1 + i2 + i3;
        int num2 = i4 + i5 + i6;
        int num3 = i7 + i8 + i9;
        int num4 = i1 + i4 + i7;
        int num5 = i2 + i5 + i8;
        int num6 = i3 + i6 + i9;
        int num7 = i3 + i5 + i7;
        int num8 = i1 + i5 + i9;
        if (num1 == num2 || num1 == num3 || num1 == num4 || num1 == num5 || num1 == num6 || num1 == num7 || num1 == num8
                || num2 == num3 || num2 == num4 || num2 == num5 || num2 == num6 || num2 == num7 || num2 == num8
                || num3 == num4 || num3 == num5 || num3 == num6 | num3 == num7 || num3 == num8
                || num4 == num5 || num4 == num6 || num4 == num7 || num4 == num8
                || num5 == num6 || num5 == num7 || num5 == num8
                || num6 == num7 || num6 == num8
                || num7 == num8){
            return false;
        }

        return true;
    }
}
