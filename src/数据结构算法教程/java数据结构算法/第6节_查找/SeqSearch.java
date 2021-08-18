package 数据结构算法教程.java数据结构算法.第6节_查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeqSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        System.out.println(seqSearch(new int[]{1, 9, 11, -1, 34, 89}, 11));
        System.out.println(binarySearch(new int[]{-1, 9, 10, 11, 11, 11, 11, 11, 34, 89}, 0, 5, 11));//前提是有序的数组
        System.out.println(binarySearch_2(new int[]{-1, 11, 11, 11, 11, 11, 11, 11, 34, 89}, 0, 5, 11));//前提是有序的数组
        System.out.println(binarySearch_2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 0, 20, 1));//前提是有序的数组
        System.out.println(binarySearch_2(new int[]{1, 8, 10, 89, 1000, 1234}, 0, 6, 11));//前提是有序的数组
    }

    //线性查找
    public static int seqSearch(int[] arr, int value) {
        //线性查找就是逐一比对
        /***
         找到一个值就退出
         如果想找多个值呢,就直接用一个数组存值
         */
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }

        System.out.println("没找到你要的值,请重新确定查询!");
        return -1;
    }

    //二分查找  -有序序列 log2n 次
    public static int binarySearch(int[] arr, int left, int right, int findValue) {
        /****
         1.确定中间下标
         mid = (left+right)/2
         2.然后让需要查找到的数findValue和mid比较
         2.1如果大于mid 就向右查找
         如果小于mid 就向左边找
         如果等于,return;

         递归的结束条件
         1.找到了 退出
         2.找不到 退出 当left>tight了退出
         典型的分治,递归,二分,子问题,
         */

        if (left > right) {
            System.out.println("不好意思,没找到哦啊~" + findValue);
            return -1;
        }
        int mid = (left + right) / 2;
        // while (left<right){
        if (findValue == arr[mid]) {
            return mid;
        } else if (findValue > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else {
            return binarySearch(arr, left, mid - 1, findValue);
        }
        // }

        //System.out.println("不好意思,没找到哦啊~"+findValue);
        //return -1;//找不到
    }

    //需求:有所有符合的下标都找到
    public static List<Integer> binarySearch_2(int[] arr, int left, int right, int findValue) {
        /***
         思路:在找到mid时,先向mid左扫描,再想右扫描,,符合的都加入list中
         */
        List<Integer> list = new ArrayList<>();

        if (left > right) {
            System.out.println("不好意思,没找到哦啊~" + findValue);
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        if (findValue == arr[mid]) {
            //向左扫描
            int temp = mid - 1;
            while (true) {//向左扫描
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                list.add(temp);//将数加入list
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findValue) {
                    break;
                }
                list.add(temp);
                temp++;
            }

            return list;
        } else if (findValue > arr[mid]) {
            return binarySearch_2(arr, mid + 1, right, findValue);
        } else {
            return binarySearch_2(arr, left, mid - 1, findValue);
        }

        /***
         总结:
         线性
         二分

         预告:
         插值
         斐波那数列
         第7节_哈希表
         二叉树 前序 中序 后序
         */
    }

    //插值查找mid的处理方式不一样  mid=low+(key -a[low])/a[high] - a[low] *(high-low)   //这样改的公司就是  假设数列是均匀的
    public static int interpolationSearch(int[] arr, int left, int right, int findValue) {
        /***
         findValue < arr[0] || findValue > arr[arr.length - 1]   这句话不仅仅是优化
         这个条件必须要,否则mid值可能会越界 如果故意把findValue找8000000 非常大,就会越界
         */
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            System.out.println("不好意思,没找到哦啊~" + findValue);
            return -1;
        }
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);//动态追踪
        // while (left<right){
        if (findValue == arr[mid]) {
            return mid;
        } else if (findValue > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else {
            return binarySearch(arr, left, mid - 1, findValue);
        }
    }

    //斐波那契 / 黄金分割法 / 查找算法     这是一个神奇的数字,会带来意想不到的效果
    public static int fibSearch(int[] a, int key) {
        /***利用fib寻找分隔点
         最近看见一个要求仅使用加法减法实现二分查找的题目，百度了一下，原来要用到一个叫做斐波那契查找的的算法。查百度，是这样说的：

         斐波那契查找与折半查找很相似，他是根据斐波那契序列的特点对有序表进行分割的。他要求开始表中记录的个数为某个斐波那契数小1，即n=F(k)-1;

         开始将k值与第F(k-1）位置的记录进行比较(及mid=low+F(k-1)-1),比较结果也分为三种

         1）相等，mid位置的元素即为所求

         2）>   ,low=mid+1,k-=2;说明:low=mid+1说明待查找的元素在[mid+1,hign]范围内，k-=2 说明范围[mid+1,high]内的元素个数为n-（F(k-1))= Fk-1-F(k-1)=Fk-F(k-1)-1=F(k-2)-1个，所以可以递归的应用斐波那契查找

         3)<    ,high=mid-1,k-=1;说明:low=mid+1说明待查找的元素在[low,mid-1]范围内，k-=1 说明范围[low,mid-1]内的元素个数为F(k-1)-1个，所以可以递归的应用斐波那契查找



         大部分说明都忽略了一个条件的说明：n=F(k)-1， 表中记录的个数为某个斐波那契数小1。这是为什么呢？

         我想了很久，终于发现，原因其实很简单：

         是为了格式上的统一，以方便递归或者循环程序的编写。表中的数据是F(k)-1个，使用mid值进行分割又用掉一个，那么剩下F(k)-2个。正好分给两个子序列，每个子序列的个数分别是F(k-1)-1与F(k-2)-1个，格式上与之前是统一的。不然的话，每个子序列的元素个数有可能是F(k-1)，F(k-1)-1，F(k-2)，F(k-2)-1个，写程序会非常麻烦。
         实现代码如下：

         复制代码
         // 斐波那契查找.cpp

         #include "stdafx.h"
         #include <memory>
         #include  <iostream>
         using namespace std;

         const int max_size=20;//斐波那契数组的长度

         /*构造一个斐波那契数组*/
       /* void Fibonacci(int * F)
        {
            F[0]=0;
            F[1]=1;
            for(int i=2;i<max_size;++i)
                F[i]=F[i-1]+F[i-2];
        }

        *//*定义斐波那契查找法*/
        /*
        int Fibonacci_Search(int *a, int n, int key)  //a为要查找的数组,n为要查找的数组长度,key为要查找的关键字
        {
            int low=0;
            int high=n-1;

            int F[max_size];
            Fibonacci(F);//构造一个斐波那契数组F

            int k=0;
            while(n>F[k]-1)//计算n位于斐波那契数列的位置
                ++k;

            int  * temp;//将数组a扩展到F[k]-1的长度
            temp=new int [F[k]-1];
            memcpy(temp,a,n*sizeof(int));

            for(int i=n;i<F[k]-1;++i)
                temp[i]=a[n-1];

            while(low<=high)
            {
                int mid=low+F[k-1]-1;
                if(key<temp[mid])
                {
                    high=mid-1;
                    k-=1;
                }
                else if(key>temp[mid])
                {
                    low=mid+1;
                    k-=2;
                }
                else
                {
                    if(mid<n)
                        return mid; //若相等则说明mid即为查找到的位置
                    else
                        return n-1; //若mid>=n则说明是扩展的数值,返回n-1
                }
            }
            delete [] temp;
            return -1;
        }

        int _tmain(int argc, _TCHAR* argv[])
        {
            int a[] = {0,16,24,35,47,59,62,73,88,99};
            int key=100;
            int index=Fibonacci_Search(a,sizeof(a)/sizeof(int),key);
            cout<<key<<" is located at:"<<index;
            system("PAUSE");
            return 0;
        }
         */
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那数列的下标
        int mid = 0;//存档mid值
        int f[] = fib();//获取fib数列
        //获取斐波那期数的期望值下标
        while (high > f[k] - 1) {
            k++;
        }
        //f[k]的值不一定和数组的大小相同  可能大于数组的长度,需要用arrsys类 够着一个新的数组指向啊
        int[] temp = Arrays.copyOf(a, f[k]);//不足的部分会用0填充
        //对新的数组进行去0 用a.high a数组的最后一个数来填充0
        for (int i = high; i < temp.length; i++) {
            temp[i] = a[high];
        }

        //使用while循环处理找到key
        while (low <= high) {
            mid = low + f[k - 1] + 1;
            if (key < temp[mid]) {//向数组的前面查找(左边)
                high = mid - 1;
                k--;//为甚是k--
                /***
                 1.全部元素等于前面的元素加上后面的元素
                 2.f[k] = f[k-1]+f[k-2]
                 因为前面有f[k-1]个元素,所以可以继续材分 f[k-1]  = f[k-2]+f[k-3]
                 即在f[k-1] 前面继续查找 k--;
                 即下次循环mid = f[k-1-1]-1
                 */
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
                /***
                 为甚是这样的呢?
                 全部元素依然是前面的元素 + 后面的元素
                 f[k] = f[k-1] + f[k-2]
                 在f[k-2]的前面可以继续查找 mid=f[k-1-2]-1
                 */
            }else {//找到了
                //需要确定的是返回的是哪一个下标
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }

        return -1;

        /***
         fib原理: 相邻的数接近黄金分隔点
         满足一个公式,可以寻找黄金分隔点 mid
         */
    }

    //需要先获取一个fib数列 -非递归方法得到一个fib数列
    public static int[] fib() {//得到maxSize个
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


}
