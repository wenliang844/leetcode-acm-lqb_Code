package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 因此，如果你知道一个实例，那么你可以通过实例的“getClass()”方法获得该对象的类型类，
 如果你知道一个类型，那么你可以使用“.class”的方法获得该类型的类型类。
 */
public class Test03 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Student> cls = Student.class;
        //全是public方法   object的方法   运行时类的方法和所有父类的方法
        Method[] methods = cls.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        //运行时类的所有的方法
        System.out.println("--------");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field m : declaredFields) {
            System.out.println(m);
        }

        System.out.println("------------------");
        //指定方法
        Method word = cls.getDeclaredMethod("work");
        System.out.println(word.getName());
        System.out.println(Modifier.toString(word.getModifiers()));

        System.out.println("-------------");
        //返回值
        //System.out.println(word.getReturnType());


        System.out.println("----------");
        //获取注解
        //只有runtion运行期可以
        //override是souse 编译期进行的一个校验,获取不到
        Method myMethod = cls.getMethod("myMethod");
        Annotation[] annotations = myMethod.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }


        System.out.println("-----------------");
        //获取异常
        Class<?>[] exceptionTypes = myMethod.getExceptionTypes();
        for (Class<?> c : exceptionTypes) {
            System.out.println(c);
        }

        System.out.println("--------------");
        //反射的东西
        //调用方法
        Student o = cls.newInstance();
        myMethod.invoke(o);//需要传对象和参数   是调用o对象的myMethod方法



    }
}
