package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test3;

public class Test04 {

    public static void main(String[] args) {
        //获取字节码文件
        Class<Student> cls = Student.class;
        //获取运行时类的接口
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println(i);
        }

        //获取父类的字节码信息
        System.out.println("----------");
        Class<? super Student> superclass = cls.getSuperclass();
        Class<?>[] interfaces1 = superclass.getInterfaces();
        for (Class<?> c : interfaces1) {
            System.out.println(c);
        }

        //运行时所在包getPackage .getName
        //获取运行时类的注解 getAnnotation


    }
}
