package 算法algo.马士兵左程云_排序算法.牛客第三期初级.排序算法;

public class Bloom布隆过滤器和一致性哈希 {

    public static void main(String[] args) {
        int[][] arr = new int[100][100];
        //arr[0];//0~31位 信息
        //arr[1];//64~127位     6341描黑  arr[6341 / 64] -> 1
        //就是比特为上的 0101

        /**
         最低位是
         1byte = 8bits
         url
         k个哈希函数
         url经过哈希函数计算出k个0-n-1  值   描黑

         查是否加入过bloom
         url哈希函数一下得到k个值,查这k个值的状态,都是1 黑的,那即是黑的
         有一个不是1,绝对没加入过bloom 过滤器

         */

    }
}
