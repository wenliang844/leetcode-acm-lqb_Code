package 数据结构算法教程.java数据结构算法.第5节_排序;

import java.util.Arrays;

/***sort algorithm_BinarySearchIgenocuesion
 note
 内部排序:需要处理的数据全部加载到内存中进行排序
 外部排序:数据量过大,需要借助外部寻西湖进行排序
 内部排序:
 * 插入  直接插入^  希尔排序{缩小增量排序}
 * 选择  简单选择^  堆排序
 * 交换  冒泡^  快速(插一个基数点 左右交换 )(挖坑法){随机选择基准数，区间内数据较少时直接用另的方法排序以减小递归深度}
 * 归并(二路归并,递归)
 * 基数(桶排序的升级扩展板) {似于一些“打表”或是哈希的做法}
 *
 * 1. 基数排序 vs 计数排序 vs 桶排序
 * 基数排序：根据键值的每位数字来分配桶；
 * 计数排序：每个桶只存储单一键值；
 * 桶排序：每个桶存储一定范围的数值；
 *
 * 在桶中放一个区间的数
 * 例如0-100
 * 一个桶放0-10  11-20 分配

 常数阶1   没有循环结构 一些语句就是,不随变量的增长而增长 几万行代码也是常数阶
 对数阶 log2N   while(i<n) i=i*2   变量越大 增速越慢   i离n越来越近
 线性阶n   {一层for循环 i++}n20 就是代码执行20次   代码执行的行数和n变量的关系
 线性对数阶nlog2n  将log2n的代码循环执行了n遍  在外面加一个for循环 fori-n  whilei<n  i=i*2
 平方阶 n^2
 立方阶 n^2
 k次方阶 n^k
 指数阶 2^n   慢
 n!


 平均时间复杂度和最坏时间复杂度{常用}
 一般做最坏情况的打算{合理}

 冒泡 n^2
 交换 N^2 不稳
 选择 n^2 不稳
 插入 n^2
 基数{桶} logrB
 shell希尔 nlogN  n2 {1-2}{1.3}不稳定
 快速 nlogn 不稳
 归并 nlogn
 堆 nlogn 不稳
 */
public class All_Sort {

    static void mySwap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    static int[] getBigNums() {
        //创建一个8万数的随机数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//生成一个0 - 8000000 的数
        }

        return arr;
    }

    public static void main(String[] args) {
        //System.out.print("bubble冒泡=");
        printNums(bubbleSort(new int[]{5, 4, 3, 2, 1}));
        //System.out.print("selection选择=");
        printNums(selectionSort(new int[]{6, 3, 2, 1}));
        long start = System.currentTimeMillis();
        //printNums(insertSort_2(getBigNums()));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        printNums(shellSort(new int[]{5, 4, 3, 2, 1}));

        System.out.println("快速排序===============");
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(arr, 0, 8);
        printNums(arr);

        System.out.println("归并排序=================");
        int temp[] = new int[8];//额外的空间开销
        int[] arr1 = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        megerSort(arr1, 0, 7, temp);
        printNums(arr1);

        System.out.println("基数排序===================");
        int[] arr3 = new int[]{53, 3, 542, 748, 14, 214};
        radixSort_2(arr3);
        //printNums(arr3);

    }

    //冒泡排序
    public static int[] bubbleSort(int[] nums) {
        /***
         算法思想  相邻像个数进行交换  每次交换最大的数冒泡到最后了
         */

        int len = nums.length;
        int len2 = len;
        for (int i = 0; i < len; len--) {
            for (int j = i; j < len - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    mySwap(nums, j, j + 1);
                    //printNums(nums);
                }
            }
        }

        return nums;
    }

    //选择排序
    public static int[] selectionSort(int[] nums) {
        /***
         算法思想  把最小的数和第一个数进行交换
         */

        for (int i = 0; i < nums.length; i++) {
            int maxNum = nums[i];
            int i1 = i;//记录最小值的坐标
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < maxNum) {
                    maxNum = nums[j];
                    i1 = j;
                }
            }
            mySwap(nums, i, i1);

        }

        return nums;
    }

    //插入排序
    public static int[] insertSort(int[] nums) {
        /***
         算法思想  打扑克,最容易理解 从0开始,把每张牌和前面的牌进行对比
         大则移动补坑 小则插入
         */

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];//临时变量 保存num[i]的值
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                } else {
                    nums[j + 1] = temp;
                    break;
                }
            }
        }

        return nums;
    }

    //插入排序 老师的代码
    public static int[] insertSort_2(int[] nums) {
        /***
         算法思想  打扑克,最容易理解 从0开始,把每张牌和前面的牌进行对比
         大则移动补坑 小则插入
         */

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];//临时变量 保存num[i]的值

            int j = i;//从已经排序的序列最右边开始比较 找到小的值
            //将这个数后移
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }

            //存在更小的值 插入
            //如果不存在 就不插入
            if (j != i) {//加不加判断都一样  若是没找到,j就不会一定
                nums[j] = temp;
            }

            //System.out.println("第"+i+"轮插入后=");
            //printNums(nums);
        }

        return nums;
    }

    //希尔排序
    public static int[] shellSort(int[] nums) {
        /***
         希尔排序 算法思想
         插入排序在整体有序的时候非常高效 但是一般情况下还是每次只移动一位的 每次都只有序一位的
         希尔排序是加入一个step值,传统每次都是一次
         step将控制每次比较的步长 构造一个全局基本有序的序列

         方案存在问题  在交换的问题
         在step中 利用插入排序 找到位置之后一次性插入
         移位法
         1秒 80000数字
         */
        for (int step = nums.length / 2; step >= 1; step /= 2) {

            for (int i = step; i < nums.length; i++) {
                int temp = nums[i];//临时变量 保存num[i]的值

                int j = i - step;//从已经排序的序列最右边开始比较 找到小的值
                while (j > 0 && nums[j] > temp) {
                    nums[j + step] = nums[j];
                    j -= step;
                }

                //存在更小的值 插入
                //如果不存在 就不插入
                //if (j!=i){
                nums[j + step] = temp;
                //}
            }

        }
        return nums;
    }

    //归并排序  合并的次数就是数据链额的长度
    public static void megerSort(int[] arr, int left, int right, int[] temp) {
        /***
         归并排序 可以
         *自下而上的递归
         * 自下而上的迭代

         采用经典的分治策略思想;而治的阶段把各个小阶段的答案整合起来
         8457 1362
         84 57 13 62
         8 4 5 7  1 3 6 2   分的过程没做什么事情
         48 57 13 26
         4578 1236
         12345678   治的时候采用的方法:两个栈顶的元素进行比较,谁小取谁

         */
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归进行分解
            megerSort(arr, left, mid, temp);

            //向右递归进行分解
            megerSort(arr, mid + 1, right, temp);

            //每分解一次合并一次 调用merge
            merge(arr, left, mid, right, temp);
        }


    }

    //合并的方法 arr需要排序的原始数组 left左边有序序列的初始索引 mid中间索引 right右边索引 temp中转的数组
    //arr4578 1236   temp空 中转数组   将arr有序转到tmep,再把temp转回去arr
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.out.println("--|");
        int i = left;//初始化i 左边有序序列的初始索引
        int j = mid + 1; //初始化j 表示右边有序序列的初始索引
        int t = 0;//t是指向temp

        //1.先把左右两边的有序数据按照规则填充到temp数组
        //直到左右两边的有序序列,有一边处理完毕为止
        while (i <= mid && j <= right) {//继续
            if (arr[i] <= arr[j]) {//如果左边的当前元素小于等于右边的元素,就将左边的arr[i]->tmep
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //2.应该吧哪边剩余的加入temp
        /*if (i<mid){//arr[i]左边还有元素
            while ()
        }*/
        while (i <= mid) {//右边有剩余 填充
            temp[t] = arr[i];
            t++;
            i++;
        }
       /* if (j<arr.length){

        }*/
        while (j <= right) {//右边有剩余 填充
            temp[t] = arr[j];
            t++;
            j++;
        }
        //3.将tmep加入arr   拷贝的是left - right
        t = 0; //指向temp数组 学应用 自创
        int templeft = left;//
        System.out.println("templeft:" + templeft + "right:" + right);
        while (templeft <= right) {
            //第一次合并 temp=0,right1
            //第二次temp=2 right3
            //第三次 temp=0 right3
            //最后一次是0 7
            //arr[templeft] = temp[0];//警告 !不能每次都是temp[0]
            arr[templeft] = temp[t];
            t++;
            templeft++;
        }

    }

    //快速排序
    public static void quickSort(int[] arr, int left, int right) {
        /***
         快速排序 可以      挖坑法
         找一个基准点 左右交换
         对左部分和右部分进行递归

         交换 对冒泡排序进行的一个优化;
         快排的一个以空间换时间 8百万 2-4秒
         2 3 5 1
         */
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];//先保存基准值
        int temp = 0;//交换使用

        //while循环的意义,让比pivot小的放左边
        //比pivot大的放在右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于的pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }

            //在pivot的右边一直找 找到小于等于pivot推出
            while (arr[r] > pivot) {
                r -= 1;
            }

            //交换左右的值
            if (l >= r) {
                break;//说明pivot的左右已经是左边都小于  右边都大于了
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换后发现arr[l] == pivot 相等 r--  前移动一下
            if (arr[l] == pivot) {
                r -= 1;
            }

            //如果交换后发现arr[l] == pivot 相等 r--  前移动一下
            if (arr[r] == pivot) {
                l += 1;
            }

        }
        //如果l ==r 必须l++  r--
        if (l == r) {
            l++;
            r--;
        }
        //System.out.println("这是下一趟的--------------------");
        //printNums(arr);
        if (left < r) {
            quickSort(arr, left, r);
        }

        if (right > r) {
            quickSort(arr, l, right);
        }

        //return arr;
    }


    /****
     堆排序:构造一个有序二叉树

     计数排序:键值对  每个桶只存储单一键值  重复的数多?
     桶排序:分区放入数值 每个桶存储一定范围的数值
     基数排序:根据键值的每位数字分配桶

     0-200   几亿个数  适合桶排序   设置0-10  个桶  基于数据状态
     */

    //朴素算法
    //基数排序  基于桶排序  分位排序
    public static void radixSort(int[] arr) {
        /***
         {53,3,542,748,14,214};
         10个桶
         第一轮:将每个元素的个位数取出来,然后判断应该放在哪个一位数组中
         542  53   14   748
         3   214
         第二部:按照桶的顺序一次取出数据放回原数组
         542 53 3 14 214 748

         第二轮:将十位数取出,进行桶里排序   没有就是0
         3   14   542   53 214  748
         再取数
         3 14 214 542 748 53
         第三轮:百位取出 进行桶排序
         3   214   542   748
         14
         53
         取数:3 14 53 214 542 748
         已然是一个有序序列了
         0 1 2 3 4 5 6 7 8 9
         */

        //第一轮 针对每个元素的个位进行排序处理

        //定义一个二维数组,每个桶就是一个一维数组
        //1.二维数组包含10个一维数组 每个一维就是一个桶
        //2.为了防止在放数的时候溢出数据,足够大 每个都是arr.lengh  空间换时间{基数排序}
        //每一个桶有一个下标在不停的指针,当前实际放置的数,   用一个point[10] 指针
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        //第一轮(针对每个元素的个位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位的数
            int digitOfElement = arr[j] % 10; //取出个位
            //放入到对应的桶中  第digit个桶的第digit指针
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //把数取出来,一次放入原数组
        int index = 0;
        //遍历每一个桶,将每一个桶中的值放入原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据才放入原数组,
            if (bucketElementCounts[k] != 0) {
                //循环该桶 即第k个一维数组,放入
                for (int i = 0; i < bucketElementCounts[k]; i++) {
                    //取出元素放入arr
                    arr[index++] = bucket[k][i];
                }
            }
            //第一轮处理后,需要清零
            bucketElementCounts[k] = 0;

        }

        System.out.println("第一轮对个位的处理结束=" + Arrays.toString(arr));

        //==============第二轮的处理
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的十位的数
            int digitOfElement = arr[j] / 10 % 10; //取出十位
            //放入到对应的桶中  第digit个桶的第digit指针
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //把数取出来,一次放入原数组
        index = 0;
        //遍历每一个桶,将每一个桶中的值放入原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据才放入原数组,
            if (bucketElementCounts[k] != 0) {
                //循环该桶 即第k个一维数组,放入
                for (int i = 0; i < bucketElementCounts[k]; i++) {
                    //取出元素放入arr
                    arr[index++] = bucket[k][i];
                }
            }
            bucketElementCounts[k] = 0;//桶指针回归0

        }

        System.out.println("第二轮对个位的处理结束=" + Arrays.toString(arr));


        //==============第三轮的处理
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的百位的数
            int digitOfElement = arr[j] / 10 / 10 % 10; //取出百位
            //放入到对应的桶中  第digit个桶的第digit指针
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //把数取出来,一次放入原数组
        index = 0;
        //遍历每一个桶,将每一个桶中的值放入原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据才放入原数组,
            if (bucketElementCounts[k] != 0) {
                //循环该桶 即第k个一维数组,放入
                for (int i = 0; i < bucketElementCounts[k]; i++) {
                    //取出元素放入arr
                    arr[index++] = bucket[k][i];
                }
            }
            bucketElementCounts[k] = 0;//桶指针回归0

        }

        System.out.println("第三轮对个位的处理结束=" + Arrays.toString(arr));
    }

    //优化算法 -->根据前面的算法 可以得到优化的基数排序代码
    public static void radixSort_2(int[] arr) {

        //1.得到最大的位数
        int max = arr[0];//假设第一个就是最大数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();//巧妙

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //每个元素对应的位进行排序 个 十 百(针对每个元素的个位进行排序处理)
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的数
                int digitOfElement = arr[j] / n % 10; //取出个位
                //放入到对应的桶中  第digit个桶的第digit指针
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //把数取出来,一次放入原数组
            int index = 0;
            //遍历每一个桶,将每一个桶中的值放入原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放入原数组,
                if (bucketElementCounts[k] != 0) {
                    //循环该桶 即第k个一维数组,放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第一轮处理后,需要清零
                bucketElementCounts[k] = 0;

            }

            System.out.println("第" + (i + 1) + "轮对个位的处理结束=" + Arrays.toString(arr));
        }


        /*****
         基数排序的总结分析:
         1.内存占用空间过大,数多了内存不足以支撑 OutOfMemoryError
         2.用的是每位数进行一个进桶 出桶   下一位进行进桶 出桶
         效率高 空间换时间
         稳定的:像两个相同的数字,拍完数后1 1前后顺序不变,就是稳定排序  可以自测测出
         如果是不确定的  就是不稳定的

         有负数,则不支持使用基数排序,要用的话,要对代码进行改进
         加步步:***   对负数求绝对值,取出要进行反转

         进行一个对比:堆排序:和二叉树相关 维持一个有序的大顶堆  二叉树

         计数排序和基数排序 桶排序类似O(n*k) k:是桶的数量

         堆排序

         */

    }


}












































