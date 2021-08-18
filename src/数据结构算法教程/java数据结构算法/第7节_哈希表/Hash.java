package 数据结构算法教程.java数据结构算法.第7节_哈希表;

import java.util.Scanner;

/***
 hashTable的底层
 开场题:
 公司员工信息加入id age gender address
 输入id 快速查找到员工的信息
 不使用数据库,节省内存,速度快
 一个关键码值 映射
 散列函数 映射函数
 存放记录的表就是散列表

 对数据库的访问平凡  加一个缓存层
 1.缓存产品 redis memcache
 2.自己写一个缓存
 用hash表   把数据先加载到内存
 取数据在哈希中存取
 数组+链表
 数组+二叉树
 key value
 如果一级不够   可以加二级缓存 再哈希得到

 增
 删
 改
 查

 hash 利用mod高效的利用了空间
 一个数组管理7个链表,把链表的查找效率提高了7倍
 可以在size/7的时间内,找到,返回这个数据
 id+name
 */
public class Hash {
    public static void main(String[] args) {
        /***
         使用hashTable存储雇员信息
         EmpLinkedList ->Emp ->Emp
         EmpLinkedList ->Emp ->Emp
         EmpLinkedList ->Emp ->Emp
         举例如上
         数组里面的元素是链表
         链表指向的元素里面有 classEmp{
         int id;
         String name;
         String adress;
         }

         classEmpLinedList{
         Emp head = null;//指向当前链表的第一个雇员
         //相关的对雇员的操作
         //add
         //list
         //find
         //del
         通过hashTable来操作
         //有一个散列函数  决定id对应哪个链表 数组的第几个元素
         }

         数组每个元素指向链表
         classHashTab{
         EmpLinedList[] empLikedListArr;   链表数组
         }
         */

        //创建一个hashTab
        HashTab hashTab = new HashTab(7);

        //写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id:");
                    int id = scanner.nextInt();
                    System.out.println("输入名字:");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id:");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("退出成功");
                    System.exit(0);
                default:
                    System.out.println("输入有误!请从欣输入{谢谢合作}:");
                    break;
            }
        }
    }
}

//hash可以集中管理很多链表,这是效率高潮的原因
//创建hashTabke  管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    //构造器
    public HashTab(int size) {
        this.size = size;//表示共有多少条链表
        //初始化长度
        empLinkedListArray = new EmpLinkedList[size];
        //?能用了莫?  留一个坑   不要忘了分别初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //写添加雇员 真正的添加是hashtab完成的  包起来的
    public void add(Emp emp) {
        //根据员工的id得到该元工应该加入的位置
        int empLinkedListNO = hashFun(emp.id);
        //将emp加入对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //遍历所有的链表 hash表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public void findEmpById(int id) {
        //使用散列函数确定去哪个链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp!=null){
            System.out.println("在链表中找到这个雇员"+id+"-"+(empLinkedListNO+1));
        }else {
            System.out.println("在哈希表中没有找到这个雇员");
        }
    }

    //编写一个散列函数,使用一个取模法
    public int hashFun(int id) {
        return id % size;
        /***
         如果1-7    如果序号是8 8会在1上面
         */
    }


}

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;//默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//表示一个链表
class EmpLinkedList {
    //头指针,执行第一个Emp,因此我们这个链表的head是直接指向第一个Emp的
    private Emp head;//默认为空

    //添加雇员到链表
    //说明 假设添加雇员的时候就是添加在最后  id是自增长的 从小到大
    //因此加到本链表的最后一个即可
    public void add(Emp emp) {
        //如果是添加第一个链表
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是添加第一个雇员,使用一个辅助的之后只和 帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;//后移一位
        }
        //退出时,直接将emp加入最后
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "链表为空");//空
            return;

        }
        System.out.print("第" + (no + 1) + "链表的信息如下=======");
        Emp curEmp = head;//辅助指针
        while (true) {
            System.out.printf("=>id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();

    }

    //根据id查找雇员 找到返回emp 没哟返回空
    public Emp findEmpById(int id) {
        //判空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                //找到
                break;//这时curEmp就是查找的雇员
            }
            //退出
            if (curEmp.next == null) {
                //水命遍历当前濑尿没哟找到这个雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;

        }

        return curEmp;
    }

}
