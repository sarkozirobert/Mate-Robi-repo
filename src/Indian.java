import java.util.HashSet;

public class Indian {

    private String name;
    private String tribe;
    private String sex;
    private int age;
    private HashSet<String> belongings;

    public Indian(String name, String tribe, String sex, int age, HashSet<String> belongings) {
        this.name = name;
        this.tribe = tribe;
        this.sex = sex;
        this.age = age;
        this.belongings = belongings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HashSet<String> getBelongings() {
        return belongings;
    }

    public void setBelongings(HashSet<String> belongings) {
        this.belongings = belongings;
    }

    @Override
    public String toString() {
        return "Indian{" +
                "name='" + name + '\'' +
                '}';
    }
}
