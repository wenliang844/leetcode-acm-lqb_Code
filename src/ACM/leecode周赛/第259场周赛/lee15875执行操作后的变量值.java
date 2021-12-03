package ACM.leecode周赛.第259场周赛;

public class lee15875执行操作后的变量值 {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (int i = 0; i < operations.length; i++) {
            String oper = operations[i];
            switch (oper){
                case "X++":
                case "++X":
                    x++;
                    break;
                case "X--":
                case "--X":
                    x--;
                    break;
            }
        }
        return x;
    }
}
