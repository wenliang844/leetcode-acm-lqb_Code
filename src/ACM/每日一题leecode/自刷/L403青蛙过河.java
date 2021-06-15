package ACM.每日一题leecode.自刷;
/*
一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。

给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。

如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。

请注意：

石子的数量 ≥ 2 且 < 1100；
每一个石子的位置序号都是一个非负整数，且其 < 231；
第一个石子的位置永远是0。
示例 1:

[0,1,3,5,6,8,12,17]

总共有8个石子。
第一个石子处于序号为0的单元格的位置, 第二个石子处于序号为1的单元格的位置,
第三个石子在序号为3的单元格的位置， 以此定义整个数组...
最后一个石子处于序号为17的单元格的位置。

返回 true。即青蛙可以成功过河，按照如下方案跳跃：
跳1个单位到第2块石子, 然后跳2个单位到第3块石子, 接着
跳2个单位到第4块石子, 然后跳3个单位到第6块石子,
跳4个单位到第7块石子, 最后，跳5个单位到第8个石子（即最后一块石子）。
示例 2:

[0,1,2,3,4,8,9,11]

返回 false。青蛙没有办法过河。
这是因为第5和第6个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 */
public class L403青蛙过河 {

    static void printNums(int nums[]){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println("===");
    }
    public static void main(String[] args) {
        System.out.println(canCross2(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));//true
        System.out.println(canCross2(new int[]{0,1,2,3,4,8,9,11}));//false

    }

    public static boolean canCross(int[] stones) {

        int[] write = new int[stones[stones.length-1]+1];
        //write[0]=write[1]=1;
        for (int i = 2; i < write.length; i++) {
            write[i]=0;
        }
        for (int i = 0; i < stones.length; i++) {
            write[stones[i]]=1;
        }
        printNums(write);
        int k=1;
        for (int i = 1; i < write.length; i++) {
            if (write[i]>=1){
                if (i+write[i]-1 <write.length && write[i+write[i]-1]>=1){
                    write[i+write[i]-1]=write[i]-1;
                }

                if (i+write[i]<write.length &&  write[i+write[i]]>=1){
                    write[i+write[i]]=write[i];
                }

                if (i+write[i]+1<write.length && write[i+write[i]+1]>=1){
                    write[i+write[i]+1]=write[i]+1;
                }

            }
        }
        printNums(write);

        return true;
    }

    public static boolean canCross2(int[] stones) {
        //dp[i][k] = dp[j][k+1] | dp[j][k] | dp[j][k+1]

        int len = stones.length;
        //会超标内存 采用verctor更好
        boolean[][] dp = new boolean[stones[stones.length-1]+1][stones[stones.length-1]+1];
        dp[0][0]=true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int k =stones[i]-stones[j];
                if (k<len+1&&k<=stones[j]+1){
                    dp[i][k]=dp[j][k-1]||dp[j][k]||dp[j][k+1];
                    if (i==len-1&&dp[i][k]==true) return true;
                }
            }
        }

        return false;
    }

    public static boolean canCross3(int[] stones){
        /*try{
            return true;
        }catch (Exception e){
            return false;
        }*/

        return true;
    }
}
