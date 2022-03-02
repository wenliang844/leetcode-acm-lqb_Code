package ACM.每日一题leecode.day237;

public class day246_2000反转单词前缀 {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public static String reversePrefix(String word, char ch) {

        int index = word.indexOf(ch);
        System.out.println(index);
        String temp = new StringBuilder(word.substring(0, index + 1)).reverse().toString();

        return new StringBuilder(temp).append(word.substring(index+1,word.length())).toString();
    }
}
