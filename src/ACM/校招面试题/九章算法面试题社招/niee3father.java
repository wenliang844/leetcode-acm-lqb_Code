package ACM.校招面试题.九章算法面试题社招;

public class niee3father {
    private String name = "Zhuge Liang";
    private int id = 1;

    public niee3father() {
    }

    /**
     *
     * @param name: Father's name
     * @param id: Father's id
     */
    public niee3father(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void introduction() {
        System.out.println("Hello, my name is " + name + ", my id is " + id +
                ".");
    }
}
