package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test3;

import java.lang.reflect.Field;

//获取属性:赋值操作
public class Test02 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Student> cls = Student.class;

        //获取属性 获取紫烈父类的public属性
        Field[] field = cls.getFields();
        for (Field f : field) {
            System.out.println(f);//4个得到两  student person个一个public

        }

        System.out.println("-----------");
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("-----------");
        //和获取指定的属性 score的属性
        Field score = cls.getField("score");//直接参数 字符串名字
        System.out.println(score);

        //获取属性的数据类型  getTypy()
        //获取修饰符   getMoifiers()

        //赋值 属性赋值要有对象
        Field sco = cls.getField("score");
        Student o1 = cls.newInstance();
        sco.set(o1,98);

        System.out.println(o1);
    }
}
