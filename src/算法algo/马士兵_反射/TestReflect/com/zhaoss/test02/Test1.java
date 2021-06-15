package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test02;

import 算法algo.马士兵_反射.TestReflect.com.zhaoss.test01.Test;

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //案例:使用person的字节码信息作为案例
        //方法1:通过对象的方法getClass获取
        Person p = new Person();
        Class<? extends Person> c1 = p.getClass();//获取字节码对象
        System.out.println(c1);
        //方式2 内置类的class属性
        Class<Person> c2 = Person.class;//字节码文件信息
        System.out.println(c2);

        //方式三:通过classForname 字节码信息的名字 //反射,动态得到信息,常用
        Class<?> c3 = Class.forName("算法algo.马士兵_反射.TestReflect.com.zhaoss.test02.Person");
        System.out.println(c3);

        //方式4:利用类的加载器  jvm class Test
        ClassLoader loader = Test.class.getClassLoader();
        Class<?> c4 = loader.loadClass("算法algo.马士兵_反射.TestReflect.com.zhaoss.test02.Person");
        System.out.println(c4);

    }
}
