package ACM.tag刷题.算法.字符串;

public class string_14最长公共前缀 {

    /***
     编写一个函数来查找字符串数组中的最长公共前缀。
     如果不存在公共前缀，返回空字符串 ""。
     输入：strs = ["flower","flow","flight"]
     输出："fl"
     */
    //方法一:从String[0] 开始,对比每一个前缀,进行sub
    public static String longestCommonPrefix(String[] strs) {

        return null;
    }

    //方法二:构造字典树
    //方法三:遍历每一个串的第一个字符,然后第二个,第三个 7 5
    public static String longestCommonPrefix3(String[] strs) {
        //判空
        if (strs==null)return "";
        if (strs.length==0)return "";
        if (strs.length==1)return strs[0];
        int index =0;
        String ans = "";
        while (true){
            if (strs[0].length()==0) return "";
            if (index >= strs[0].length()){
                break;
            }
            char target = strs[0].charAt(index);
            boolean flag = true;
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length()){
                    flag = false;
                    break;
                }
                char c = strs[i].charAt(index);
                if (c!=target){
                    flag = false;
                    break;
                }

            }
            if (flag){
                ans += target;
            }else {
                break;
            }
            index++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix3(new String[]{"flower", "flow", "flight"}));//"fl"
        System.out.println(longestCommonPrefix3(new String[]{"dog","racecar","car"}));//""
        System.out.println(longestCommonPrefix3(new String[]{"","",""}));//""
        System.out.println(longestCommonPrefix3(new String[]{"",""}));//""
        System.out.println(longestCommonPrefix3(new String[]{"flower","flower","flower","flower"}));
        System.out.println(longestCommonPrefix3(new String[]{"ab","a"}));//""
        System.out.println(longestCommonPrefix3(null));

    }
}
