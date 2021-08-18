package 数据结构算法教程.java数据结构算法.第2节_链表;
/*
1.双链表可以自我删除
2.可以双向查找,自我删除方便   但是插入不方便
    1.遍历方式一样,只是可以向前和向后查找
    2.添加 添加到最后的话直接
        *先cur找到双向链表的后面
        cur.next=newHeroNode;
        newHeroNode.pre=cur;
    3.修改 也是一样 找到node进行一个替换
    4.删除 比如要删除数据为5的节点---自我删除
        cur.pre.next=cur.next
        cur.next.pre=cur.per
        
 */
public class doubleLinkedDemo {

}

class doubleLinkedList{
    private doubleLinked head = new doubleLinked(0,"","");
    public doubleLinked getHead(){
        return head;
    }
    public void list(){
        //遍历双向列表的方法实现
        if (head.next==null){
            System.out.println("双向链表为空~");
        }
        doubleLinked cur = head.next;
        while (true){
            if (cur==null){//退出条件
                break;
            }
            System.out.println(cur);//遍历
            cur=cur.next;
        }
    }
    public void addNode(doubleLinked heroNode){
        //因为head不能动,因此我们需要一个辅助遍历temp
        doubleLinked temp = head;
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后,就将temp后移
            temp=temp.next;
        }
        //当退出while循环的时候,temp就指向了最后
        //temp.next = heroNode;
        temp.next = heroNode;//形成双向链表
        heroNode.pre=temp;
    }
    public  void update(doubleLinked newHeroNode){
        //判断是否为空
        if (head.next==null){
            System.out.println("链表为空 不能更新");
            return;
        }
        //找到需要修改的节点  根据no编号
        doubleLinked temp = head.next;
        boolean flag = false;
        while (true){
            if (temp==null){
                break;//到了链表的底部 已经遍历完成了,还是没有找到
            }
            if (temp.no == newHeroNode.no){
                flag = true;//找到了这个节点  退出
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name=newHeroNode.name;
            temp.nickName=newHeroNode.nickName;
        }else{
            System.out.println("不能修改 没有找到编号"+newHeroNode.no);
        }
    }
    public  void deleteByNo(int no){
        /*
        可以找到之后直接自我删除
         */
        //判断是否为空
        if (head.next==null){
            System.out.println("链表为空 不能更新");
            return;
        }
        //找到需要修改的节点  根据no编号
        doubleLinked temp = head.next;//不需要靠前一个来删除了,直接自我删除
        boolean flag = false;//标识是否找到前一个节点
        while (true){
            if (temp==null){
                break;//到了链表的底部 已经遍历完成了,还是没有找到 ---找到最后节点
            }
            if (temp.no == no){
                flag = true;//找到了这个节点  退出
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要删除的节点
        //被删除的节点会被垃圾回收机制回收
        if (flag){
            //temp.next=temp.next.next;//temp.next会自动被回收   单项链表的
            temp.pre.next = temp.next;//这是双向链表 但是如果是最后一个节点呢 temp最后一个节点没有null
            if (temp.next!=null)//如果是最后一个节点就不用执行下面这句话 进行一个判断
            temp.next.pre = temp.pre;

        }else{
            System.out.println("不能delete没有找到编号"+no);
        }
    }
}
class doubleLinked{
    int no;
    String name;
    String nickName;
    doubleLinked pre;//指向前一个 默认为null
    doubleLinked next;//指向后一个

    public doubleLinked(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "doubleLinked{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
