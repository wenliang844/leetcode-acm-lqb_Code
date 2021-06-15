package 蓝桥杯.蓝桥杯每日一题;

public class day43_修改字符串 {
    /***
     给定两个字符串S和T，每次小Ho可以对S进行以下操作：
     选定S中的一个字符Si，将Si移动到字符串首位。
     例如对于S="ABCD"，小Ho可以选择移动B从而得到新的S="BACD"；也可以选择移动C得到"CABD"；也可以选择移动D得到"DABC"。
     请你计算最少需要几次移动操作，可以使S变成T。

     输入
     第一行包含一个字符串S。
     第二行包含一个字符串T。
     对于30%的数据，1 ≤ |S| = |T| ≤ 10
     对于100%的数据，1 ≤ |S| = |T| ≤ 100000  S和T都只包含大写字母
     输出
     一个整数代表答案。如果无法达成，输出-1。

     样例输入
     ABCD
     DBAC
     样例输出
     2
     */
    //方法一:去重复之后再操作,两种情况:1.交换一次匹配了两组字符 2:交换一个次只匹配一组
    //当当前字符后面有字符刚好相反就是情况一,直接将这两组字符消掉 就是把他们变成一样的
    //双指针 如果一样下一个,如果不一样coun++,forj=i+1,看后面有没有刚好相反的,有就变一样
    public static int str_编辑距离字符变另一个字符只能交换(String s,String t){
        //无法达成的情况就是单词个数不一样
        //所以采用模拟法, 不同的话遍历后面如果有相反的采用相反的,没有的话就取一个origuinal[j] = target[i]的字符进行original交换
        int count = 0;
        char[] original = s.toCharArray();
        char[] target = t.toCharArray();
        for (int i = 0; i < original.length; i++) {
            if (original[i]!=target[i]){
                //去后面找,看没有orighal[j] = target[i]的,并且target[j]==orighal[i]最好相反的
                int index = -1;
                for (int j = i+1; j < original.length; j++) {
                    if (original[j] == target[i]){
                        index = j;
                        if (original[i] == target[j]){
                            break;
                        }
                    }
                }
                if (index==-1){
                    return -1;
                }
                count++;
                //交换orighal的i j
                char temp = original[i];
                original[i] = original[index];
                original[index] = temp;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(str_编辑距离字符变另一个字符只能交换("ABCD","DBAC"));//2
        System.out.println(str_编辑距离字符变另一个字符只能交换("",""));//0
        System.out.println(str_编辑距离字符变另一个字符只能交换("av","va"));//1
        System.out.println(str_编辑距离字符变另一个字符只能交换("ACCV","VCCA"));//1
        System.out.println(str_编辑距离字符变另一个字符只能交换("ACCVE","VCCAR"));//-1
    }
}
