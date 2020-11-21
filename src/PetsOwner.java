import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PetsOwner {

    String name;
    int age;
    String gender;
    ArrayList<Integer> pets = new ArrayList<Integer>();
    ArrayList<Pet> ownedPets = new ArrayList<>();
    ArrayList<String> ownedPetNames = new ArrayList<>();

    public PetsOwner() throws FileNotFoundException {


    }

    public ArrayList<String> getOwnedPetNames() {
        return ownedPetNames;
    }

    public ArrayList<Pet> getOwnedPets() {
        return ownedPets;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setSex(String sex) {
        this.gender = sex;
    }

    public ArrayList<Integer> getPets() {
        return pets;
    }

}
