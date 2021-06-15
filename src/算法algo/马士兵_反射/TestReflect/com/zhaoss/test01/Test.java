package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test01;

public class Test {
    public static void main(String[] args) {
        //这样的话就是两种方式了
        //微信支付
        new WeChat().payOnline();

        //支付宝支付
        new AliPay().payOnline();

        //使用分支,界面选择的是微信和支付宝
        //定义一个字符串,模拟支付方式
        String str = "支付宝";
        if ("微信".equals(str)){
            //new WeChat().payOnline();
            pay(new WeChat());
        }

        //分支可以使用多分支 switch等等......
        if ("支付宝".equals(str)){ //防止空指针异常 str可能为空 前台没选择支付方式
            //new AliPay().payOnline();
            pay(new AliPay());
        }

        if ("招商银行".equals(str)){
            pay(new BankCard());
        }
        /**
         如此代码的缺点: 扩展的越多,方法写的多
         面向对象的特征:多态
         */


    }



    /*//能不能提取一个方法  重载
    public static void pay(WeChat wc){
        wc.payOnline();
    }

    public static void pay(AliPay ap){
        ap.payOnline();
    }

    public static void pay(BankCard bankCard) {
        bankCard.payOnline();
    }*/

    /**
     //用的多态
     传参是接口, 实参是对象
     不管多少支付方式,一种方法就可以
     多态可以提高代码的扩展性,这个扩展性没有达到最好

     一旦不合作了,分支就需要删除了,少了分支呢?  分支就需要加好多,分支多了,代码的扩展性还是不好
     解决办法,反色机制

     * @param m
     */
    public static void pay(Mtwm m){
        m.payOnline();
    }
}
