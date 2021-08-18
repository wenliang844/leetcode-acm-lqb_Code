package ACM.校招面试题.九章算法面试题社招;

public class niee1StringLength {
    public static void main(String[] args) {
        System.out.println(getArrayStringLength(new String[]{"asd", "asd"}));
    }
    public static int getArrayStringLength(String[] stringArray) {
        // write your code here
        int count = 0;
        for (int i = 0; i < stringArray.length; i++) {
            count+=stringArray[i].length();
        }

        return count;
    }
}
