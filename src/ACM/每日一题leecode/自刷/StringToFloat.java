package ACM.每日一题leecode.自刷;

import java.util.Arrays;

public class StringToFloat {
    //字符串转浮点数

    //方法一:使用内置方法
    public static float stof1(String s) {
        return Float.parseFloat(s);
    }

    //方法二:分割小数点 前面的从后开始*10 后面的从前开始*0.1 相加得到result
    public static float stof2(String s) {
        //System.out.println(s);
        String[] split = s.split("\\.");
        float result = 0f;
        float step = 1f;
        System.out.println(Arrays.toString(split));
        for (int i = split[0].length()-1; i >=0; i--) {
            result += (split[0].charAt(i)-48)*step;
            //System.out.println("这是charAt"+(split[0].charAt(i)));
            step *= 10;
        }
        System.out.println("这是result"+result);

        float step2 =  0.1f;
        for (int i = 0; i < split[1].length(); i++) {
            System.out.println("这是charAt"+(split[1].charAt(i)));
            result += (split[1].charAt(i)-48)*step2;
            System.out.println("这是48后"+(split[1].charAt(i)-48)*step2);
            step2 *= 0.1;
        }
        System.out.println("这是result"+result);
        return result;
    }

    public static void main(String[] args) {
        float v = stof2("2.5");
        System.out.println("======="+v);//浮点数
        System.out.println("======="+stof2("32.1415"));
    }
}
