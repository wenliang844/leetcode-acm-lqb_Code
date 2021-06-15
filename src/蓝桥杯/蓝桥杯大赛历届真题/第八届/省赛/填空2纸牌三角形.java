package 蓝桥杯.蓝桥杯大赛历届真题.第八届.省赛;

public class 填空2纸牌三角形 {

    public static void main(String[] args) {
        /***
         1-9排成三角形,每4张牌相等,有多少种,旋转3,镜像2算一种,res/6

         枚举,9个for循环,judgement{ 1 2 3 4 == 4 5 6 7 == 7 8 9 1  }
         */
        int count=0;
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
                                    if (i7 == i6 || i7 == i5 || i7 == i4 || i7 == i3 || i7 == i2 || i7 == i1) continue;
                                    for (int i8 = 1; i8 <= 9; i8++) {
                                        if (i8 == i7 || i8 == i6 || i8 == i5 || i8 == i4 || i8 == i3 || i8 == i2 || i8 == i1)
                                            continue;
                                        for (int i9 = 1; i9 <= 9; i9++) {
                                            if (i9 == i8 || i9 == i7 || i9 == i6 || i9 == i5 || i9 == i4 || i9 == i3 || i9 == i2 || i9 == i1)
                                                continue;

                                            //在都不相等的情况下,如果1234 == 4567 == 7891count++
                                            if ((i1 + i2 + i3 + i4 == i4 + i5 + i6 + i7) && (i1 + i2 + i3 + i4 == i7 + i8 + i9 + i1))
                                            {
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
        System.out.println(count/6);
    }
}
