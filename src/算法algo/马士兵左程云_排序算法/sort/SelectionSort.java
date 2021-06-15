package 算法algo.马士兵左程云_排序算法.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};

        //优化 有一个flag   后面已经有序,然后flag=false,不循环了 ---意义不大
        //如果找到一个最小值  一个最大值   这样少二分之一
        //还能优化:如果提取两个值来比较:又会少二分之一的循环值
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;//一个标记量
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j]<arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
        print(arr);

    }

   public static void sort(int[] arr){
        //int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};

        //优化 有一个flag   后面已经有序,然后flag=false,不循环了 ---意义不大
        //如果找到一个最小值  一个最大值   这样少二分之一
        //还能优化:如果提取两个值来比较:又会少二分之一的循环值
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;//一个标记量
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j]<arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/*
程序大O分析:
    1.算法初始化不计入算法时间
    2.打印中间结果不计入算法时间
    3.常数不计入算法时间
    4.低阶不计入算法时间
    看循环 n的阶层;
    n2次 n2
 */
/*
选择排序后一个问题
    1.大O分析
    2.空间指的是额外的局部变量  minPos一个空间

    测试程序:肉眼观察容易错,数据大的时候,
        1.肉眼观察
        2.产生足够多随机样本
        3.用确定正确的算法计算样本结果
        4.用你的算法计算,然后比较两者结果的值,一致性
 */

