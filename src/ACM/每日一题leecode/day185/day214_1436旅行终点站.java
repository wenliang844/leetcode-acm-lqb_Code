package ACM.每日一题leecode.day185;

import java.util.ArrayList;
import java.util.List;

public class day214_1436旅行终点站 {

    public static void main(String[] args) {
        List<List<String>> listList = new ArrayList<>();
        String[][] strings = {{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}};
        for (String[] string : strings) {
            List<String> list = new ArrayList<>();
            list.add(string[0]);
            list.add(string[1]);
            listList.add(list);
        }
        System.out.println(destCity(listList));
    }

    //把终点列出来,用起点去抵消(局部),最后没抵消的那个就是终点 7|50
    public static String destCity(List<List<String>> paths) {
        List<String> end = new ArrayList<>();
        //List<String> start = new ArrayList<>();
        for (List<String> path : paths) {
            end.add(path.get(1));
        }
        System.out.println(end);
        for (List<String> path : paths) {
            end.remove(path.get(0));
        }
        System.out.println(end);
        return end.get(0);
    }
}
