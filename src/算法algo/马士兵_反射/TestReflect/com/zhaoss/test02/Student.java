package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test02;
//student做子类
public class Student extends Person {

    //attr
    private int sno;
    double height;
    protected double weight;
    public double score;
    //method
    public String showInfo(){
        return "i am a student";
    }

    private void work(){
        System.out.println("coding---------");
    }
    //构造器
    public Student(){
        System.out.println("空参构造器");
    }
    private Student(int sno){
        this.sno=sno;
    }
    Student(int sno,double weight){
        this.sno = sno;
        this.weight = weight;
    }

}
