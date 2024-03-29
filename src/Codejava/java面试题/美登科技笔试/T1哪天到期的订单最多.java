package Codejava.java面试题.美登科技笔试;

public class T1哪天到期的订单最多 {
    public static void main(String[] args) {

    }

    public static int getMaxOrder(){


/**
 * ## 问题1回答如下
 * 在闰年的下一年的2月28日到期订单最多,共有13个,分别是:
 * 当年1月28,1月29,1月30,1月31
 * 去年11月28,11月29,11月30
 * 去年8月28,8月29,8月30,8月31
 * 去年2月28,2月29
 *
 * 分析:
 * 该天到期的订单必然是前一个月,前三个月,前六个月,前一年的订单,只需要找到特殊的一天到期的订单中包含的日期最多即可
 * 2月份非闰年只有28天,则该天到期的订单会包含28,29,30,31四种日期的订单,订单至少从五年前就开始了,则必定包含闰年和闰年的下一年
 * 通过使用倒推法以2001年2月28为例子可以轻松倒推出包含的到期订单为:
 * 2001年的1月28,1月29,1月30,1月31
 * 2000年的11月28,11月29,11月30
 * 2000年的8月28,8月29,8月30,8月31
 * 2000年的2月28,2月29
 */
        return 0;
    }
}
