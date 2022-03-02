package ACM.每日一题leecode.day237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day239_1078Bigram分词 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOcurrences("alice is a good girl she is a good student", "a", "good")));
    }

    //100 82
    public static String[] findOcurrences(String text, String first, String second) {

        String[] split = text.split(" ");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < split.length-2; i++) {
            if (first.equals(split[i])&&second.equals(split[i+1])){
                list.add(split[i+2]);
            }

        }

        return list.toArray(new String[list.size()]);
    }
}
