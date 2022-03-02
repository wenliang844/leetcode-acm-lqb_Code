package ACM.每日一题leecode.day237;

public class day718_917仅仅反转字母 {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters("7_28]"));
    }

    public static String reverseOnlyLetters(String s) {

        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left<s.length() && (chars[left] < 'A' || (chars[left] > 'Z' && chars[left] < 'a') || chars[left] > 'z')) {
                left++;
            }
            while (right>0 && (chars[right] < 'A' || (chars[right] > 'Z' && chars[right] < 'a') || chars[right] > 'z')) {
                right--;
            }
            //swap left right
            //System.out.println(left + "---" + right);
            if (left<right){
                int temp = chars[left];
                chars[left] = chars[right];
                chars[right] = (char) temp;
                //System.out.println(chars);
                left++;
                right--;
            }

        }
        return new String(chars);
    }
}
