package 蓝桥杯.第一次小选拔;

import java.math.BigDecimal;

/**
 * error
 */
/*
问题描述
　   某星球的天文服务器容量换算为地球的标准是9123456783TB，请问该服务器的存储容量是多少字节？
　　这是一道结果填空的题，你只需要算出结果后提交即可，要求结果精确到个位，在提交答案时只填写数字，填写多余的内容将无法得分。
 */
public class lanqiao_4_服务器容量9123456783TB转字节 {
    public static void main(String[] args) {
        method1();

    }

    /*
    1TB=1024GB=2^40
    1GB =1024MB=1024*1024KB=1024*1024*1024B =1024^3=2^30
    1MB =1024KB =1024*1024B =2^10*2^10=2^20 B就是字节数

    1TB=1024*1024*1024*1024
        GB    MB   KB   B


        BigInteger
        BigDecimal
     */
    public static void method1(){
        //long num = 9123456783 * 1024 * 1024 * 1024 * 1024;
        System.out.println(1024*1024*1024*1024);
        System.out.println("-----------");
        BigDecimal big1 = new BigDecimal("9123456783");
        BigDecimal big2 = new BigDecimal("1024");
        BigDecimal multiply1 = big1.multiply(big2);
        BigDecimal multiply2 = multiply1.multiply(big2);
        BigDecimal multiply3 = multiply2.multiply(big2);
        BigDecimal multiply4 = multiply3.multiply(big2);
        System.out.println(multiply4);
    }
}
