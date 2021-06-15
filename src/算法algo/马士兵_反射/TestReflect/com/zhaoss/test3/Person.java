package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test3;

import java.io.Serializable;

public class Person implements Serializable {//序列化的接口

    //attribute
    private int age;
    public String name;

    //method
    private void eat(){
        System.out.println("person---eat----private");
    }

    public void sleep(){
        System.out.println("person---sleep---public");
    }
}
