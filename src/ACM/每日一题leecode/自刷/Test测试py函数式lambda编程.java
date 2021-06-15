package ACM.每日一题leecode.自刷;

public class Test测试py函数式lambda编程 {
    public static void main(String[] args) {

        String str = "11";
        int a = 11;
        change(str);
        changenum(a);
        System.out.println(str);
        System.out.println(a);
    }


    public static void change(String str){
        str = "change";
    }
    public static void changenum(int str){
        str = 132123;
    }

    public static String changenum2(int str){
        str = 132123;

        return "12";
    }
    public static int changenum2(int str,int a){
        str = 132123;
        return 1;
    }
}
