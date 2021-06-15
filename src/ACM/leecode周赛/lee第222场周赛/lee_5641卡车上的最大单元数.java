package ACM.leecode周赛.lee第222场周赛;

/***
 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：

 numberOfBoxesi 是类型 i 的箱子的数量。
 numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。

 返回卡车可以装载 单元 的 最大 总数。



 示例 1：

 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 输出：8
 解释：箱子的情况如下：
 - 1 个第一类的箱子，里面含 3 个单元。
 - 2 个第二类的箱子，每个里面含 2 个单元。
 - 3 个第三类的箱子，每个里面含 1 个单元。
 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 示例 2：

 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 输出：91
 */
public class lee_5641卡车上的最大单元数 {
    public static void main(String[] args) {
        System.out.println("这是键结果"+maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        System.out.println("这是键结果"+maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7},{3,9}}, 10));
    }

    //方法一:贪心算法 按单元数排序,把最大先的装载 直到size=0
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        sortByJ(boxTypes);
        System.out.println("排序后---");
        for (int i = 0; i < boxTypes.length; i++) {
            for (int j = 0; j < boxTypes[i].length; j++) {
                System.out.print(boxTypes[i][j]+"-");
            }
            System.out.println();
        }
        int maxSum = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0]<=truckSize){
                System.out.println("放了"+boxTypes[i][0]+"--"+boxTypes[i][1]);
                maxSum += boxTypes[i][0] * boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }else {
                System.out.println("最后"+truckSize+"--"+boxTypes[i][1]);
                maxSum += truckSize*boxTypes[i][1];
                break;
            }
        }
        return maxSum;
    }

    //根据j=1号位的单元数进行排序
    public static void sortByJ(int[][] boxTypes){
        //选择排序
        for (int i = 0; i < boxTypes.length-1; i++) {
            int maxNum = i;
            for (int j = i+1; j < boxTypes.length; j++) {
                if (boxTypes[j][1]>boxTypes[maxNum][1]){
                    maxNum=j;
                }
            }
            //交换
            int temp1 = boxTypes[i][0];
            int temp2 = boxTypes[i][1];
            boxTypes[i][0]=boxTypes[maxNum][0];
            boxTypes[i][1]=boxTypes[maxNum][1];
            boxTypes[maxNum][0]=temp1;
            boxTypes[maxNum][1]=temp2;
        }
    }
}
