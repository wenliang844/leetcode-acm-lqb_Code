package java虚拟机jvm.jvm;

public class jvm_math {

    public static final int initData = 666;
    public static User user = new User();
    public int initData1 = 666;

    public int compute(){ //一个方法对应一块栈帧内存区域
        int a=1;
        int b=2;
        int c = (a+b) *10;
        return c;
    }

    public static void main(String[] args) {

        jvm_math math = new jvm_math();
        math.compute();
        System.out.println("test");
    }
}
