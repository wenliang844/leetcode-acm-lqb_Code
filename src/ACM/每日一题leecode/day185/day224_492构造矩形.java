package ACM.每日一题leecode.day185;

import java.util.Arrays;

/***
 1.网上查询社保是10几个人
 2.入职的公司 做的产品
 3.开发
 */
public class day224_492构造矩形 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(4)));
        System.out.println(Arrays.toString(constructRectangle(37)));
    }

    //W从根号area开始找,直到1  找到了一个直接返回 100|72
    public static int[] constructRectangle(int area) {

        int res[] = new int[2];
        for (int i = (int) Math.sqrt(area); i >= 1; i--) {
            int L = area / i;
            int temp = area % i;
            if (temp == 0) {
                System.out.println("[" + L + ", " + i + "]");
                res[0] = L;
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
