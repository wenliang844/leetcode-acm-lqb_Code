package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test3;

import 算法algo.马士兵_反射.TestReflect.com.zhaoss.test02.Person;

//student做子类
@MyAnnotation(value = "hidemethod")
public class Student extends Person implements MyInterface {

    //attr
    private int sno;
    double height;
    protected double weight;
    public double score;

    //method
    public String showInfo() {
        return "i am a student";
    }

    public String showInfo(int a, int b) {
        return "i am a student===重载方法!!!";
    }

    private void work() {
        System.out.println("coding---------");
    }

    void happy() {
        System.out.println("做人重要的就是开心每一天!!!");
    }

    protected int getSno() {
        return sno;
    }

    //构造器
    public Student() {
        System.out.println("空参构造器");
    }

    public Student(double weight,double height){
        this.weight = weight;
        this.height = height;
    }
    private Student(int sno) {
        this.sno = sno;
    }

    Student(int sno, double weight) {
        this.sno = sno;
        this.weight = weight;
    }

    protected Student(int sno, double height, double weight) {
        this.sno = sno;
    }

    @Override
    @MyAnnotation(value = "hidemethod") //多注解重复加载
    public void myMethod() {
        System.out.println("重写了方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
