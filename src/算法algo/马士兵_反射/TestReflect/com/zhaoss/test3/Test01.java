package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test01 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取里面的构造器:
        //1.获取字节码信息
        Class<Student> cls = Student.class;

        //通过字节码信息获取构造器
        Constructor[] c1 = cls.getConstructors();
        for (Constructor c : c1) {
            System.out.println(c); //只能获取public方法的构造器修饰  不全面
        }

        System.out.println("------------");
        Constructor<?>[] c2 = cls.getDeclaredConstructors();//获取全部修饰符的构造器
        for (Constructor<?> c : c2) {
            System.out.println(c);
        }
        System.out.println("-------------");
        //获取指定的构造器
        Constructor<Student> con1 = cls.getConstructor();
        System.out.println(con1);//空构造器

        System.out.println("----------------");
        //得到两个参数的有参构造器
        Constructor<Student> con2 = cls.getConstructor(double.class, double.class);
        System.out.println(con2);

        System.out.println("--------------");
        //得到一个参数的有参,是private修饰的
        Constructor<Student> con3 = cls.getDeclaredConstructor(int.class);//Declared就可以得到
        System.out.println(con3);

        System.out.println("############");
        //有了构造器就可以创建对象了
        Student student = con1.newInstance();
        System.out.println(student);

    }
}
