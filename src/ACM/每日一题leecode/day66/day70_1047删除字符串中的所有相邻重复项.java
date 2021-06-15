package ACM.每日一题leecode.day66;


/***
 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

 在 S 上反复执行重复项删除操作，直到无法继续删除。

 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

  

 示例：

 输入："abbaca"
 输出："ca"
 */
public class day70_1047删除字符串中的所有相邻重复项 {

    public static String removeDuplicates(String S) {
        /***
         思路:
         如果相同就下一个,如果不相同了就把当前这个给进来,再下一个
         每次添加一个哨兵,免得处理最后的情况

         */

        boolean flag = true;
        System.out.println("哨兵="+S);
        while (flag){

            S=S+"0";//添加一个哨兵,免得处理最后的情况
            flag = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < S.length()-1;) {
                int j = i+1;
                if (S.charAt(i) == S.charAt(j)){
                    j++;
                    flag = true;
                }else {
                    sb.append(S.charAt(i));
                }
                i=j;
            }

            S = sb.toString();
            System.out.println("------"+S);
        }
        System.out.println(S);
        return S;

    }

    public static void main(String[] args) {
        System.out.println("这是结果"+removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("abbacaa"));
    }
}
