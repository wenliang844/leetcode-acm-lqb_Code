package 数据结构算法教程.java数据结构算法.第8节_树tree.huffmanCode;

import java.io.*;
import java.util.*;

/***
 • 实践  数据压缩成编码
 * 根据哈夫曼编码树 获取哈夫曼编码
 把i like like like java do you like a java对应的赫夫曼树

 1. Node {data数据  weight{权值} left right}
 2. 得到字符串对应的byte[]数组
 3.编写一个方法 将准备构建huffman数node节点放到一个list中  形式{Node{data=97 weight=5},Node{data=32,weight=9}} 体现list
 4.通过list创建对应的huffman数 存放权值



 • 实践 得到huffmanTree编码表
 1.a:01   d:11000 u:1101
 树向左的路径为0  右为1
 放在一个map中  形式就是
 map<32,01> <97,100>

 • 实践 得到huffmanTree编码后的数据
 1.编写一个方法,将一个字符串对应的byte数组通过生成的huffman表返回一个处理后的byte数组

 • 实践 得到经过编码后 解码的string字符{数据解压}
 1.将huffmanCodeBytes数组转成str字符串8位一个转 二进制字符串1010010001011...
 2.将这个字符串对照赫夫曼编码重新转成字符串 map<"1010","a">

 • 最佳实践 --将一个文件进行压缩 调用huffmanZip

 • 最佳实践 --将一个文件进行解压 调用decode


 总结:
 技巧:使用Object进行写入写出,可以对象分类写出
 jpeg,视频,ppt:有压缩处理;用
 可以用自己的算法压缩一下文件再发给别人,用于密码传输
 huffman可以压缩所有的文件
 文件重复的数据不多,压缩效果也不明显

 无损: 差分编码、RLE、Huffman编码、LZW编码、算术编码
 有损: 预测编码、音感编码、分形压缩、小波压缩、JPEG/MPEG


 */
public class HuffmanCode {

    //源码补码反码
    private static void codeTest1() {
        String str = "10101000";
        System.out.println((byte) Integer.parseInt(str, 2));//byte -88  8位处理:省空间
    }

    //前序遍历的方法
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("is null~");
        }
    }

    //字符串 编码成zip byte数组
    public static void teachersTest_1() {

        String str = "i like like like java do you like a java";
        System.out.println(str.length());
        byte[] contentByte = str.getBytes();
        System.out.println(contentByte.length); //40
        List<Node> nodes = getNodes(contentByte);
        System.out.println("nodes==" + nodes);

        //测试创建的二叉树
        Node huffmanTree = createHuffmanTree(nodes);
        //preOrder(huffmanTree);
        //测试编码后的huffman集合map
        //getCodes(huffmanTree,"",stringBuilder);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTree);
        System.out.println("生成的huffman编码表=" + huffmanCodes);

        //测试生成的码
        System.out.println("测试生成的码==========");
        byte[] huffmanCodeBytes = zip(contentByte, huffmanCodes);
        System.out.println("生成的huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));
        System.out.println(huffmanCodeBytes.length);
        System.out.println("压缩率=" + (huffmanCodeBytes.length / contentByte.length));
        System.out.println((17.0 / 40.0));


    }

    //byte数组 经过decode成字符串--->这个在main方法中进行测试---从main中转移到这里
    public static void techersTest2() {
        //测试byteToBitString方法
        System.out.println(byteToBitString(true, (byte) -1));
        System.out.println(byteToBitString(true, (byte) 1));
        byte[] huffmanZipCodeBytes = huffmanZip("i like like like java do you like a java".getBytes());
        System.out.println("压缩后的结果是:" + Arrays.toString(huffmanZipCodeBytes) + "\n长度为" + huffmanZipCodeBytes.length);
        techersTest2();
        byte[] sourceBytes = decode(huffmanCodes, huffmanZipCodeBytes);
        System.out.println("原来的数组是" + new String(sourceBytes));
        System.out.println(sourceBytes.length);
    }

    //测试文件压缩
    public static void techersTest3() {
        String srcFile = "G:\\ProgramTest\\TestHuffmanCodes\\2.jpg";
        String dstFile = "G:\\ProgramTest\\TestHuffmanCodes\\a\\2.zip";
        zipFile(srcFile, dstFile);
        System.out.println("压缩文件成功---");
    }

    //测试文件解压
    public static void techersTest4() {
        String srcFile = "G:\\ProgramTest\\TestHuffmanCodes\\a\\2.zip";
        String dstFile = "G:\\ProgramTest\\TestHuffmanCodes\\22.png";
        unZipFile(srcFile, dstFile);
        System.out.println("解压文件成功---");
    }

    //集成几个方法
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);//获取ndoes集合
        Node huffmanTree = createHuffmanTree(nodes);//获取node根节点
        Map<Byte, String> huffmanCodes = getCodes(huffmanTree);//获取霍夫曼编码表
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);//根据编码表,获取压缩后的字节数组
        return huffmanCodeBytes;
    }

    //全局变量
    static StringBuilder stringBuilder = new StringBuilder();//存储叶子结点的路径
    static Map<Byte, String> huffmanCodes = new HashMap<>();

    public static void main(String[] args) {
        //teachersTest_1();
        //codeTest1();
        //techersTest2();
        techersTest3();
        techersTest4();

    }

    //获取list形式的node  封装
    private static List<Node> getNodes(byte[] bytes) {
        //1.创建一个list
        List<Node> nodes = new ArrayList<>();

        //遍历bytes,统计每一个byte 出现的频率 map<key,value> a,5
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        System.out.println("这是统计好的字符频率=" + counts);

        //把每一个键值对转成一个node对象,并加入到node集合中
        for (Map.Entry<Byte, Integer> byteIntegerEntry : counts.entrySet()) {
            nodes.add(new Node(byteIntegerEntry.getKey(), byteIntegerEntry.getValue()));
        }
        //System.out.println("这是把字符 字符频率放到list中的效果="+nodes);

        return nodes;
    }

    //通过一个list获取创建一个对应的huffman树的方法
    private static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出第一课最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二小的
            Node rightNode = nodes.get(1);
            //创建一颗新的二叉树,根节点没有data,只要权值,最终的data都是放在叶子节点的
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //将已经处理的节点移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }

        return nodes.get(0);
    }


    //获取字符对应的编码
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        /***
         将叶子节点的huffman编码传入huffmanCodes集合
         node:传入节点
         code:路径:左子节点就是0 右子节点1 sb.append(0 | 1)
         sb:拼接路径
         */
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {//如果node==null 不处理
            //判断当前node是叶子节点还是非叶子节点
            if (node.data == null) {//非叶子节点
                //递归处理
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);

            } else {//说明是一个叶子节点
                //表示找到了一个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }

        }

    }

    //为了调用方便,重载getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理左子树
        getCodes(root.left, "0", stringBuilder);
        //处理右子树
        getCodes(root.right, "1", stringBuilder);

        return huffmanCodes;
    }

    //编写一个方法,将一个字符串对应的byte数组通过生成的huffman表返回一个处理后的byte数组
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        /***
         bytes:源字符串
         huffmanCodes:编码表
         return byte[] :返回的是字符串对应的byte数组 编码后的 8位一个
         即8位一个bute 存储byte数组
         byte[0] = 10101000(补码)  --> 转成一个byte  [推导 10101000=>10101000-1 =>10100111(反码)=>11011000源码  -88]
         huffmancideByte ->-88
         */
        StringBuilder stringBuilder = new StringBuilder();//局部变量sb
        //遍历byte数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        System.out.println("测试sb=\n" + stringBuilder);
        System.out.println(stringBuilder.length());
        //8位一节进行byte存储 转成一个byte数组
        //统计返回的huffmanCodeByte的长度有多长
        int len = (stringBuilder.length() + 7) / 8;//巧妙
        //创建一个存储压缩后的buye数组
        byte[] huffmanCodeBytes = new byte[len];

        int index = 0;//记录第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {//8位一个byte
            String strByte;
            if (i + 8 > stringBuilder.length()) {//不够8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }

            //将strByte转成一个byte数放到by
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;//下标移动
        }


        return huffmanCodeBytes;
    }

    //数据的解压--• 实践 得到经过编码后 解码的string字符{数据解压}
    private static String byteToBitString(boolean flag, byte b) {
        /***
         * 如果看不懂.看java基础二进制补码分析
         flag:标识是否需要补高位  如果是treu需要   false不补
         b   传入的byte值
         return str是对应的二进制的字符串(是按补码形式返回的) 底层都是按补码操作的 (byte) Integer.parseInt(strByte,2);
         */
        //使用一个变量保存这个b
        int temp = b;
        //如果是正数,还需要补位
        if (flag) {
            temp |= 256; //按位与 256是 1 0000 0000  |  0000 00001  ===>  1 0000 00001
        }
        String str = Integer.toBinaryString(temp);//返回的是int对应的-1的补码 存在一个截取的问题
        //System.out.println(str);
        //最后一位可能不满8位:所以采用一个flag区分
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //编写一个方法,完成对数组byte[]解码的方法
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        /****
         huffmanCode //赫夫曼编码表 mao
         huffmanBytes 赫夫曼对应的字节数组
         return:原来的对应的字符ascll数组
         */
        //先得到huffmanBytes对应的二进制字符串 形式1010100010111
        StringBuilder stringBuilder1 = new StringBuilder();
        //将byte数组传成二进制的字符串 如果是最后一个字节,不用补高位 最后一个28的话就不用补 false传入
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder1.append(byteToBitString(!flag, b));
        }
        //System.out.println("huffman解码后对应的字节数组" + stringBuilder1.toString());

        //把字符串按照指定的赫夫曼编码进行解码
        //把huffman编码表进行一个变换,进行反向查找 map<a , 1010>
        Map<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //System.out.println("反转后:" + map);
        //根据反向的表进行解码
        //创建一个集合 存放byte
        ArrayList<Byte> list = new ArrayList<>();
        //遍历bytes  一位一位的比较,看编码表里有没有 有就放到stringbuider 没有就继续扫描
        for (int i = 0; i < stringBuilder1.length(); ) {//i就是要给索引,扫描stringbuider 就是一位一位的二进制  不用i++ 用count进行定位
            int count = 1;//小的计数器
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //取出一个字符1 0或
                String key = stringBuilder1.substring(i, i + count);//i不动,让count移动,直到匹配一个字符
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;//直接移动到count


        }
        //当for结束 就有了所有的单个的字符  将list->byte[]
        byte[] b = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    //编写一个方法 将一个文件进行压缩
    public static void zipFile(String srcFile, String dstFile) {
        /****
         srcFile 传入文件的路径
         dstFile 将压缩文件放在哪一个目录下
         */
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建输入流
        FileInputStream is = null;
        byte[] b = null;
        try {
            is = new FileInputStream(srcFile);

            //创建一个和源文件大小一样的byte数组
            b = new byte[is.available()];
            //读取文件
            is.read(b);

            //使用hffman编码进行编码 获取文件编码表
            byte[] huffmanBytes = huffmanZip(b);//直接编码了
            //创建文件输出流,存放这个压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStranm
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanBytes);//把赫夫曼编码后的字节数组写入压缩文件
            //这里以对象流的方式写入huffmanCodes,是为了解压时恢复源文件
            //一定要把赫夫曼编码写入压缩文件,解压会用到这个编码map
            oos.writeObject(huffmanCodes);//编码表用得上

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //编写一个方法 文件解压
    public static void unZipFile(String zipFile, String dstFile) {
        /***
         zipFile: 要解压的文件
         dstFile: 解压存放的路径
         */
        //对象流直接恢复,简单了
        //定义文件输入流
        InputStream is = null;
        //定义一个对象输入楼
        ObjectInputStream ois = null;
        //定义一个文件输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组,就是压缩之后的字符数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取huffmanCode哈夫曼编码表
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();//会分门别类的读取

            //解码
            byte[] bytes = decode(codes, huffmanBytes);
            //将bytes数组写入到目标文件夹
            os = new FileOutputStream(dstFile);
            //写出数据
            os.write(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

//构建一个Node节点,带数据和权值
class Node implements Comparable<Node> {
    Byte data;//存放数据本身,比如'a'
    int weight;//权值 就是数据字符出现的频率
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}