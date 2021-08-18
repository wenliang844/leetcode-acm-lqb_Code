package 数据结构算法教程.java数据结构算法.第10节_算法.动态规划_01背包KnapsackProblem;

/***C++实现
 int main()
 {
 cin >> n >> v;
 for (int i = 1; i <= n; i++)
 cin >> c[i];//价值
 for (int i = 1; i <= n; i++)
 cin >> w[i];//体积
 for (int i = 1; i <= n; i++)
 f[i][0] = 0;
 for (int i = 1; i <= n; i++)
 for (int j = 1; j <= v; j++)
 if (j >= w[i])//背包容量够大
 f[i][j] = max(f[i - 1][j - w[i]] + c[i], f[i - 1][j]);
 else//背包容量不足
 f[i][j] = f[i - 1][j];
 cout << f[n][v] << endl;
 return 0;

 如果是第一种问法，要求恰好装满背包，那么在初始化时除了f[0]为0其它f[1..V]均设为-∞，这样就可以保证最终得到的f[N]是一种恰好装满背包的最优解。
 如果并没有要求必须把背包装满，而是只希望价格尽量大，初始化时应该将f[0..V]全部设为0。
 }

 for v=V..cost
 f[v]=max{f[v],f[v-cost]+weight}
 */

/***********
 01背包问题->{物品只能放入和不放入,物品不能重复放入}
 完全背包问题->{物品可以重复放入}  -->可以转成背包问题
 ******状态转移方程:数学好有优势,但是和数学没关系,逻辑性强,思想考验
 f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]} //j >= W[ i ]
 item[][]最大容量4

 吉他   音响    电脑  |item
 1      4       3    |weight
 1500  3000    2000  |values

 dp数组:两种状态 放 不放 n是容量 n -= item[i][0]
 放    放    放
 不放 不放  不放
 dp:maxValue:
 1500放     3000放+不放    3500不放+放+放  √return this maxValue
 0不放      1500不放+放    3000放+不放+不放


 老师的推导:
 物品  0磅    1磅   2磅   3磅   4磅
 *     0      0     0     0     0
 吉他g  0   1500g  1500g 1500g  1500g
 音响s  0   1500g  1500g 1500g  3000s
 电脑l  0   1500g  1500g 2000l  3500l+g

 下一个子问题的解答 依赖于上一次的子问题
 Maath.max(val1,val2)

 1. v[i][0]=v[0][j] = 0;
 2. 当w[i]>j时 v[i][j]=v[i-1][j] //当装的容量大于当亲背包的容量,直接使用上一次的装入策略
 3. 当j>=w[i]时,v[i][j]=max[i-1][j] , v[i-1][j-w[i]+v[i]]
 要是准备加入的商品的容量小于等于当期当前背包的容量,
 装入的方式可以是
 v[i][j]: 上一个单元格的最大值
 v[i]: 表示当前商品的最大值
 v[i-1][j-w[i]]:装入i-1商品,->到剩余空间j-w[i]的最大值

 思想:把重量1 2 3 4的状态下最大重量都求出来,地推
 把原先的空间 和把现在的商品放入=剩余空间的最大值{之前二维表有保存,直接取即可{保存历史计算过的,避免重复计算}}   ==>求最大值
 典型的以时间换空间
 v[3][4]
 i=3 j=4
 w[i]=w[3]=3 j=4

 v[3][4] = max{v[2][4], v[3]+v[2][1]} = max{3000, 2000+1500}=3500

 */
public class 动态规划_01背包 {

    public static void main(String[] args) {
        System.out.println("maxValue=" + getMaxValue2(new int[][]{{1, 4, 3}, {1500, 3000, 2000}}, 4));

        int[] w = {1, 4, 3};//商品重量
        int[] val = {1500, 3000, 2000};//物品的价值
        int m = 4; //背包的容量
        int n = val.length;//物品的数量

        //为了记录放入商品的情况,这里在程序中定义一个二维数组
        int[][] path = new int[n+1][m+1];

        //创建一个二维数组,表示
        int[][] v = new int[n + 1][m + 1];//v[i][j]: 在前i个物品中能够装入容量为j个物品的最大价值

        //初始化第一行和第一列, 这里在本程序中不去处理,默认为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0; //把第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0; //将第一行设置为0
        }

        //根据前面的公式进行循环处理
        for (int i = 1; i < v.length; i++) { //不处理第一行 i从1开始
            for (int j = 1; j < v[0].length; j++) { //不处理第一列 j从1开始
                //公式
                if (w[i - 1] > j) { //应为程序i是1开始,原来公式中的w[1]要-1
                    v[i][j] = v[i - 1][j];
                } else {
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);//j-w[i-1]当前剩余价值的最大价值
                    //如果要path的话,要max中材出来,使用if-else
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]){
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出一下v    {最大价值分配表}
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //输出记录的存放物品路径
        //输出一下v    {最大价值分配表}
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                if (path[i][j]==1){ //这样会把所有的情况输出,但是我们至于要最后的情况
                    System.out.print(i+path[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("郑重输出---");
        int i = path.length-1;//行的最大下标
        int j = path[0].length-1;//列的最大下标
        while (i>0 && j>0){//从path的最后开始找
            if (path[i][j]==1){
                System.out.println(i+"---");
                j -= w[i-1]; //w[i-1]  j需要调整
            }
            i--;

        }

    }

    public static int getMaxValue(int[][] itemValueAndWeight, int n) {

        int[][] dp = new int[2][itemValueAndWeight[0].length];
        dp[0][0] = itemValueAndWeight[1][0];
        dp[1][0] = 0;
        int n1 = n - itemValueAndWeight[0][0];
        int n2 = n;
        for (int i = 1; i < itemValueAndWeight[0].length; i++) {
            int value1 = itemValueAndWeight[1][i];
            int weight1 = itemValueAndWeight[0][i];
            if (n1 < weight1) {

                //dp[0][i] =
            }
        }
        return 0;
    }

    public static int getMaxValue2(int[][] itemValueAndWeight, int n) {

        int put = itemValueAndWeight[1][0];
        int noput = 0;
        int n1 = n - itemValueAndWeight[0][0];
        int n2 = n;
        for (int i = 1; i < itemValueAndWeight[0].length; i++) {
            System.out.println("这是第" + i + "轮:" + put + "-" + noput + "--------剩余空间" + n1 + "-" + n2);
            int oldPut = put;
            int oldNoPut = noput;
            int oldN1 = n1;
            int oldN2 = n2;
            //考虑放put
            if (oldN1 < itemValueAndWeight[0][i]) {
                //只能不放 + 放
                put = oldNoPut + itemValueAndWeight[1][i];
                n1 = oldN2 - itemValueAndWeight[0][i];
            } else {
                if (oldPut + itemValueAndWeight[1][i] > oldNoPut + itemValueAndWeight[1][i]) {
                    put = oldPut + itemValueAndWeight[1][i];
                    n1 = oldN1 - itemValueAndWeight[0][i];
                } else {
                    put = noput + itemValueAndWeight[1][i];
                    n1 = oldN2 - itemValueAndWeight[0][i];
                }
            }

            //考虑不放 noput
            if (oldPut > oldNoPut) {
                noput = oldPut;
                n2 = oldN1;
            } else {
                noput = oldNoPut;
            }
        }

        System.out.println("这是最后一轮轮:" + put + "-" + noput + "--------剩余空间" + n1 + "-" + n2);
        return Math.max(put, noput);
    }


}




























