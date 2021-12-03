package ACM.其他的算法比赛.笔试.同花顺;

public class ths输出1到999中所有不包含5的整数 {

    public static void main(String[] args) {
        for (int i = 1; i <= 999; i++) {
            if (!String.valueOf(i).contains("5")){
                System.out.println(i);
            }
        }
    }
}
