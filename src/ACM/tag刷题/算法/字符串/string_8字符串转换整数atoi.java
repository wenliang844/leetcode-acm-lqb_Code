package ACM.tag刷题.算法.字符串;

public class string_8字符串转换整数atoi {
    /***
     请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

     函数 myAtoi(string s) 的算法如下：

     读入字符串并丢弃无用的前导空格
     检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     返回整数作为最终结果。
     注意：
     本题中的空白字符只包括空格字符 ' ' 。
     除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     示例 1：
     输入：s = "42"
     输出：42
     解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
     第 1 步："42"（当前没有读入字符，因为没有前导空格）
     ^
     第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     ^
     第 3 步："42"（读入 "42"）
     ^
     解析得到整数 42 。
     由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
     */
    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ' ') {
                continue;
            } else {
                break;
            }

        }

        if (sb.toString().length() == 0) {
            return 0;
        }
        if (sb.toString().length() > 10) {
            return -2147483648;
        }
        return Integer.parseInt(sb.toString());
    }

    //网友提供方案: Sweetiee公众号:甜姨 技术人 99 75
    public static int myAtoi2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int idx = 0;
        //去掉前导空格
        while (idx<n&&chars[idx]==' '){
            idx++;
        }
        //如果直接到了末尾,退出 0
        if (idx==n){
            return 0;
        }
        boolean negative = false;//默认是正数
        if (chars[idx]=='-'){
            negative=true;//负数标记一下
            idx++;
        }else if (chars[idx]=='+'){
            idx++;//维持默认
        }else if (!Character.isDigit(chars[idx])){
            //其他符号,返正不是数字
            return 0;
        }
        int answer = 0;
        while (idx<n && Character.isDigit(chars[idx])){
            int digit = chars[idx]-'0';
            //本来是ans*10+digit 但是这个有可能会越界
            if (answer > (Integer.MAX_VALUE-digit)/10){
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            answer = answer*10+digit;
            idx++;
        }
        return negative?-answer:answer;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi2("   42"));
        System.out.println(myAtoi2("42"));
        System.out.println(myAtoi2("-42"));
        System.out.println(myAtoi2("4193 with words"));
        System.out.println(myAtoi2("words and 987"));
        System.out.println(myAtoi2("words and 987"));
        System.out.println(myAtoi2("-91283472332")); //-2147483648  10位数
        System.out.println(myAtoi2("91283472332")); //2147483647
    }
}
