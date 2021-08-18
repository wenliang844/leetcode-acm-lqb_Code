package ACM.每日一题leecode.day141;

import javax.tools.Diagnostic;
import java.util.*;

//73/5
public class day157_1600皇位继承顺序_ThroneInheritance {

    /**
     * Your ThroneInheritance object will be instantiated and called as such:
     * ThroneInheritance obj = new ThroneInheritance(kingName);
     * obj.birth(parentName,childName);
     * obj.death(name);
     * List<String> param_3 = obj.getInheritanceOrder();
     */
    static class KingTree {
        String name;
        List<KingTree> sons = new ArrayList<>();
        boolean isDeath;

        public KingTree(String kingName) {
            this.name = kingName;
        }
    }

    static Map<String, KingTree> map = new HashMap<>();
    KingTree root;


    //初始化一个king
    public day157_1600皇位继承顺序_ThroneInheritance(String kingName) {
        root = new KingTree(kingName);
        map.put(kingName, root);
    }

    //出生了
    public void birth(String parentName, String childName) {
        KingTree child = new KingTree(childName);
        map.put(childName, child);
        KingTree kingTree = map.get(parentName);
        kingTree.sons.add(child);
    }

    //死亡了 用hash直接标志name tree
    public void death(String name) {
        map.get(name).isDeath = true;
    }

    //获取序号 遍历深度优先遍历一次,栈,层序遍历,先进后出
    public List<String> getInheritanceOrder() {

        List<String> res = new ArrayList<>();
        Stack<KingTree> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            KingTree cur = stack.pop();
            if (!cur.isDeath) {
                res.add(cur.name);
            }
            List<KingTree> sons = cur.sons;
            for (int i = sons.size()-1; i >=0 ; i--) {
                stack.add(sons.get(i));
            }
        }

        return res;
    }


    public static void main(String[] args) {
        day157_1600皇位继承顺序_ThroneInheritance t = new day157_1600皇位继承顺序_ThroneInheritance("king"); // 继承顺序：king
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }

}
