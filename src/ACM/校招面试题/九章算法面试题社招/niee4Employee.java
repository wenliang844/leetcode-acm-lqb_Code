package ACM.校招面试题.九章算法面试题社招;

public class niee4Employee {
    String name;
    String occupation;
    String telephone;
    int age;
    int salary;
    // write your code here

    public void setName(String name) {
        this.name = name;
    }


    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void printInfo() {
        System.out.println("Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Telephone: " + telephone + "\n" +
                "Occupation: " + occupation + "\n" +
                "Salary: " + salary + "");
    }


}
