package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test02;

public class Demo {

    /**
     class类的具体的实例有哪些:
     1.类:外部类,匿名内部类
     2.接口:
     3.注解
     4.数组
     5.基本数据类型
     6.void

     验证:
     */
    public static void main(String[] args) {
        Class<Person> c1 = Person.class;//类
        Class<Comparable> c2 = Comparable.class;//接口
        Class<Override> c3 = Override.class;//注解

        int[] arr1 = {1,2,3};
        Class<? extends int[]> c4 = arr1.getClass();//数组是一样的,同一个维度,类型,一致

        Class<Integer> c5 = int.class;//基本数据类型
        Class<Void> c6 = void.class;//void的数据类型反射class字节码文件



    }
}
