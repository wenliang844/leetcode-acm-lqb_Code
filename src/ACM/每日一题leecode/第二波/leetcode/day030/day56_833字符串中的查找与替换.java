package ACM.每日一题leecode.第二波.leetcode.day030;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day56_833字符串中的查找与替换 {


    public static void main(String[] args) throws MalformedURLException {


        URL httpUrl = new URL("http://47.96.183.65/pic/eye.jpg");
        System.out.println(httpUrl.getPath());

        String path = "F:\\upload";
        File file = new File(path + "http://47.96.183.65/pic/eye.jpg");
        System.out.println(file.getPath());
        if (!file.exists()){
            System.out.println(file.mkdirs());
//            FileUtils.copyURLToFile(httpUrl, file);
            System.out.println("sucssee");
        }


//        System.setOut(new PrintStream(new FileOutputStream(("F:\\LianQianTest\\test.txt"))));
//        Scanner scanner = new Scanner(System.in);
//        String nextLine = scanner.nextLine();
//        System.out.println(nextLine);
//
//
//        File f = new File("F:\\LianQianTest");
//        if (!f.exists()){
//            f.mkdirs();
//            System.out.println("succse");
//        }
//
//        System.out.println(readTxt("F:\\LianQianTest\\test.txt"));

//        String s  = "sss";
//        System.out.println(s.substring(0,0));
//        String res = s;
//        System.out.println(s==res);
//        res = "ssss"+res;
//        System.out.println(s);
//        System.out.println(res);
//        System.out.println(s==res);

        //System.out.println(findReplaceString("abcd" , new int[]{0, 2}, new String[]{"a" , "cd"}, new String[]{"eee" , "ffff  "}));//eeebffff
        //System.out.println(findReplaceString("abcd" , new int[]{0, 2}, new String[]{"ab","ec"}, new String[]{"eee" , "ffff  "}));//eeebffff
        //System.out.println(findReplaceString("vmokgggqzp" , new int[]{3, 5,1}, new String[]{"kg","ggq","mo"}, new String[]{"s","so","bfr"}));//vbfrssozp
        //vmossozp
        //vbfrssozp
    }

    public static String readTxt(String filePath) {
        StringBuilder lineTxt = new StringBuilder();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                int read = reader.read();

                BufferedReader br = new BufferedReader(reader);
                String lineTxt1;
                while ((lineTxt1 = br.readLine()) != null) {
                    lineTxt.append(lineTxt1).append("\n");
                }

                br.close();

            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
        return lineTxt.toString();
    }


    /**
     * 你会得到一个字符串 `s` (索引从 0 开始)，你必须对它执行 `k` 个替换操作。替换操作以三个长度均为 `k` 的并行数组给出：`indices`, `sources`,  `targets`。
     * 要完成第 `i` 个替换操作:
     * 1. 检查 **子字符串** `sources[i]` 是否出现在 **原字符串** `s` 的索引 `indices[i]` 处。
     * 2. 如果没有出现， **什么也不做** 。
     * 3. 如果出现，则用 `targets[i]`​**替换** 该子字符串。
     * 例如，如果 `s = "abcd"` ， `indices[i] = 0` , `sources[i] = "ab"`， `targets[i] = "eee"` ，那么替换的结果将是 `"<u>eee</u>cd"` 。
     * 所有替换操作必须 **同时** 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间**不会重叠 **。
     * * 例如，一个 `s = "abc"` ，  `indices = [0,1]` ， `sources = ["ab"，"bc"]` 的测试用例将不会生成，因为 `"ab"` 和 `"bc"` 替换重叠。
     * *在对 ​*​*`s`*​*​ 执行所有替换操作后返回 ​*​***结果字符串***​*​ 。*
     * **子字符串** 是字符串中连续的字符序列。
     * <p>
     * abcd  0,2  a c   c  g
     *
     * @param s
     * @param indices
     * @param sources
     * @param targets
     * @return
     */
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            indexMap.put(indices[i], i);
        }
        Arrays.sort(indices);
        System.out.println(Arrays.toString(indices));
        System.out.println(indexMap);

        int indexAdd = 0;//索引增量
        for (int i = 0; i < indices.length; i++) {
            //indices[i]索引开始
            Integer originIndex = indexMap.get(indices[i]);
            indices[i] = indices[i] + indexAdd;

            String str = s.substring(indices[i], indices[i] + sources[originIndex].length());

            if (sources[originIndex].equals(str)) {
//                res = res.replaceFirst(str,targets[i]);

                s = s.substring(0, indices[i]) + targets[originIndex] + s.substring(indices[i] + sources[originIndex].length(), s.length());
                indexAdd += targets[originIndex].length() - sources[originIndex].length();
                System.out.println("命中");
            }
            System.out.println("str=" + str + "---s=" + s + "---indexAdd=" + indexAdd);
        }

        return s;
    }

}
