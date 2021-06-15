package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

public class 填空4方格填数 {
    /***
     0 1 2
     3 4 5 6
     7 8 9

     相邻不能重复的填法
     左右,上下,对角是相邻
     */

    public static void main(String[] args) {
        int count = 0;
        for (int i0 = 0; i0 <= 9; i0++) {
            for (int i1 = 0; i1 <= 9; i1++) {
                if (Math.abs(i1 - i0) <= 1) continue;//制约条件,相邻不可相等,不可连续
                for (int i2 = 0; i2 <= 9; i2++) {
                    if (Math.abs(i2 - i1) <= 1 || i2 == i0) continue;
                    for (int i3 = 0; i3 <= 9; i3++) {
                        if (Math.abs(i3 - i0) <= 1|| i3 == i1 || i3 == i2) continue;
                        for (int i4 = 0; i4 <= 9; i4++) {
                            if (Math.abs(i4 - i3) <= 1 || Math.abs(i4 - i0) <= 1 || Math.abs(i4 - i1) <= 1 || i4 == i2) continue;
                            for (int i5 = 0; i5 <= 9; i5++) {
                                if (Math.abs(i5 - i4) <= 1 || Math.abs(i5 - i1) <= 1 ||Math.abs(i5 - i0) <= 1 || Math.abs(i5 - i2) <= 1 || i5 == i3)
                                    continue;
                                for (int i6 = 0; i6 <= 9; i6++) {
                                    if (Math.abs(i6 - i2) <= 1 || Math.abs(i6 - i5) <= 1 || i6 == i0 || Math.abs(i6 - i1) <= 1|| i6 == i3 || i6 == i4)
                                        continue;
                                    for (int i7 = 0; i7 <= 9; i7++) {
                                        if (Math.abs(i7 - i3) <= 1 || i7 == i0 || i7 == i1 || i7 == i2 ||Math.abs(i7 - i4) <= 1 || i7 == i5 || i7 == i6)
                                            continue;
                                        for (int i8 = 0; i8 <= 9; i8++) {
                                            if (Math.abs(i8 - i4) <= 1 || Math.abs(i8 - i7) <= 1 || i8 == i0 || i8 == i1 || i8 == i2 || Math.abs(i8 - i3) <= 1 || Math.abs(i8 - i5) <= 1 || i8 == i6)
                                                continue;
                                            for (int i9 = 0; i9 <= 9; i9++) {
                                                if (Math.abs(i9 - i8) <= 1 || Math.abs(i9 - i5) <= 1 || i9 == i0 || i9 == i1 || i9 == i2 || i9 == i3 || Math.abs(i9 - i4) <= 1 || Math.abs(i9 - i6) <= 1 || i9 == i7)
                                                    continue;

                                                System.out.println(i0 + "--" + i1 + "--" + i2 + "--" + i3 + "--" + i4 + "--" + i5 + "--" + i6 + "--" + i7 + "--" + i8 + "--" + i9);
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

        System.out.println("answerIs==="+count);//143412
    }
}
