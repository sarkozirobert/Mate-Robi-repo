import java.io.FileNotFoundException;

public class Pet {
    String name;
    String type;
    int age;
    int petCode;
    String petsOwner;

    public Pet() throws FileNotFoundException {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPetCode() {
        return petCode;
    }

    public void setPetCode(int petCode) {
        this.petCode = petCode;
    }

    public String getPetsOwner() {
        return petsOwner;
    }

    public void setPetsOwner(String petsOwner) {
        this.petsOwner = petsOwner;
    }
}

