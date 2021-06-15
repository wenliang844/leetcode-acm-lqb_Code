package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoReflect {

    //利用反射实现这个功能
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException {
        //定义一个字符串模拟支付方式的选择
        String str = "算法algo.马士兵_反射.TestReflect.com.zhaoss.test01.AliPay";   //现在写的字符串是方法名

        //根据类名得到一个类
        Class c1 = "AliPay".getClass();
        System.out.println(c1.getName());

        Class<?> aClass = Class.forName(str);//路径得到类
        Object o1 = aClass.newInstance();
        Mtwm o = (Mtwm) aClass.newInstance();//直接把类名来 强转
        o.payOnline();//多态进行调用方法

        Method method = aClass.getMethod("payOnline");//获取类的方法
        method.invoke(o1);//通过invoke调用

    }
}
