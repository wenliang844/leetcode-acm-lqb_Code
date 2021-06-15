package ACM.每日一题leecode.day100;

import java.util.*;

public class day114_690员工的重要性 {
    /***
     给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
     比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
     现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
     示例：
     输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     输出：11
     解释：
     员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
     */


    static int sum;
    private static Map<Integer, Employee> map;
    //方法一:直接递归法// 80 51
    public static int getImportance(List<Employee> employees, int id) {
        sum = 0;
        map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id,employee);
        }
        dfs(map.get(id));

        return sum;
    }

    private static void dfs(Employee employee) {
        sum+=employee.importance;
        if (employee.subordinates!=null){
            List<Integer> subordinates = employee.subordinates;
            for (Integer subordinate : subordinates) {
                dfs(map.get(subordinate));
            }
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3));
        employees.add(new Employee(3, 3));
        System.out.println(getImportance(employees, 1));//5 3 3==11
    }


    // Definition for Employee.
    static class Employee {
        public int id;//员工id
        public int importance;//重要性
        public List<Integer> subordinates;//下属id

        Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        Employee(int id, int importance) {
            this.id = id;
            this.importance = importance;
        }

        Employee() {

        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", importance=" + importance +
                    ", subordinates=" + subordinates +
                    '}';
        }
    }


}
