package 数据结构算法教程.java数据结构算法.第2节_链表;

/*************
 根据用户的输入,生成一个小孩出圈的顺序
 1.需求创建要辅助指针(变量)helper,事先应该指向环形链表的最后这个节点 {自己需要数一下,理解一下}
 报数之前first移动到报数处 startNum  k-1次
 2.当小孩报数时,让first和hepler指针通时移动m-1次
 3.这是可以将first指向的小孩节点出圈, 销毁即可
 first = first.next
 heper.next=first
 原理first节点指向的节点就没有任何引用了,就会被垃圾地址回收
 **************/

/*******************
 总结分析:
 z这是
 */
public class Josepfu {
    public static void main(String[] args) {

        CircleSingleLinkedList first = new CircleSingleLinkedList();
        first.addBoy(5);
        first.showBoys();
        first.countBoy(1, 2, 5);

    }


}

//创建一个环形的单项链表
class CircleSingleLinkedList {
    //创建一个first节点 不赋值 没有编号的
    private Boy first = null;//后面再修改

    public void addBoy(int nums) {
        //添加小孩节点.构建层一个环形的链表
        //nums的一个数据校验
        if (nums < 1) {//至少一个小孩,不然没法玩
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针  指向最后一个元素
        //使用一个for循环创建贵环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);//自己构成一个环状 应为cur要进行遍历,所以需要这个动作
                curBoy = first;
            } else {
                /*curBoy = first;
                while (curBoy.getNext()!=first){
                    curBoy = curBoy.getNext();
                }*/
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }

    public void showBoys() {
        //遍历
        //判断空
        if (first == null) {
            System.out.println("没小孩~");
            return;
        }
        //应为first不能动,所以需要使用辅助指针curboy
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号是:" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();//让curBoy后移
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        /**startNo表示从第几个小孩开始数
         countNum表示数几下
         nums表示最初小孩数*/
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误,请重新输入!!!");
            return;
        }
        //创建一个辅助指针,帮助小孩出圈
        Boy hellper = first;
        //需求创建一个辅助指针变量helper,指向最后的一个节点
        while (true) {//说明指向了最后一个节点
            if (hellper.getNext() == first) {
                break;
            }
            hellper = hellper.getNext();
        }

        //小孩报数前,先让first helper移动k-1次   移动startNum-1次  first移动到startNum进行操作
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            hellper = hellper.getNext();
        }
        //进行报数定位   first移动到nums-1处,出圈,这里是一个循环  直到圈中只有一个人 first ==helper
        while (true) {
            if (hellper == first) {//只剩下了一个人
                break;
            }

            //让 first helper指针同时移动countNum -1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                hellper = hellper.getNext();
                System.out.println("在移动");
            }
            //first指向的就是出圈的小孩
            System.out.println("出圈:" + first.getNo());
            System.out.println("现在的first helper" + first.getNo() + "-" + hellper.getNo());

            first = first.getNext();
            hellper.setNext(first);
            System.out.println("现在的first helper" + first.getNo() + "-" + hellper.getNo());
        }
        System.out.println("最后的小孩是:获胜:" + first.getNo());
        System.out.println("最后的小孩是:获胜:" + hellper.getNo());
    }
}


class Boy {
    private int no;//编号
    private Boy next;//指向下一个小孩 默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
