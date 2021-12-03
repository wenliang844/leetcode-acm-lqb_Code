package ACM.其他的算法比赛.笔试.others;

public class java1 {

    public static void main(String[] args) {
        System.out.println(java1("12323", "11233"));
    }


    public static int java1(String s1,String s2) {
        int len = s1.length();
        int count = 0;
        int i = 0;
        boolean flag = true;
        while (i<len){
            if (s1.charAt(i)!=s2.charAt(i) && flag){
                count++;
                flag = false;
            }else if (s1.charAt(i)==s2.charAt(i) && !flag){
                flag = true;
            }

            i++;
        }

        return count;
    }

    public static void java2() {
        //table.setBackgroundColor(1,1,8,8,"blue");
        //table.setBackgroundColor(4,5,7,7,"white");

        //css:


    }
}
