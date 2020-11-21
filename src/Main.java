import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static ArrayList<Indian> indians = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("txtFiles/indianok.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            HashSet<String> belongingsHashSet = new HashSet<>();
            String[] belongingsArray = parts[4].split("\\|");
            for (String string : belongingsArray) {
                belongingsHashSet.add(string);
            }
            Indian indian = new Indian(
                    parts[0],
                    parts[1],
                    parts[2],
                    Integer.parseInt(parts[3]),
                    belongingsHashSet);
            indians.add(indian);
        }
        for (int j = 0; j < indians.size(); j++) {
            System.out.println(indians.get(j).getName() + " " + indians.get(j).getBelongings() + " " + indians.get(j).getSex() + " " + indians.get(j).getAge() + " " + indians.get(j).getBelongings());
        }
        System.out.println("Ennyi különböző eszköz van a leltárban: " + howManyBelongingsInTheInventory());

        System.out.println(countIndiansInTribe("Seminole"));

        System.out.println(countRateOfMenInSeminole(indians));

        System.out.println(eldersInApache(indians));


    }

    //Hány különböző fajta eszköz szerepel a leltárban?

    public static int howManyBelongingsInTheInventory() {
        HashSet<String> items = new HashSet<>();
        int counter = 0;
        for (Indian indian : indians) {
            items.addAll(indian.getBelongings());
        }
        for (String string : items) {
            counter++;
        }
        return counter;
    }

    //Hányan vannak egy adott indián törzsben? (A metódus bemeneti paraméterül kapja a törzs nevét.)

    public static int countIndiansInTribe(String tribe) {
        int counter = 0;
        for (Indian indian:indians) {
            if (tribe.equals(indian.getTribe())){
                counter++;
            }
        }
        return counter;
    }

    //Milyen a férfi arány a Seminole törzsben?

    public static double countRateOfMenInSeminole(ArrayList<Indian> x){
        double counter = 0;
        double seminoleCounter = 0;
        double rate = 0;
        for (Indian indian : indians) {
            if (indian.getTribe().equals("Seminole")){
                seminoleCounter++;
            }
            if (indian.getSex().equals("f") && indian.getTribe().equals("Seminole")){
                counter++;
            }
        }
        rate = (counter / seminoleCounter) * 100;
        return rate;
    }

    //Kik alkotják a vének tanácsát az apache törzsben? (A vének arról ismerszenek meg, hogy van békepipájuk.)

    public static ArrayList<Indian> eldersInApache (ArrayList<Indian> x){
        ArrayList<Indian> apacheIndians = new ArrayList<>();
        for (Indian indian : indians){
            if (indian.getTribe().equals("Apache") && indian.getBelongings().contains("békepipa")){
                apacheIndians.add(indian);
            }
        }
        return apacheIndians;
    }
}
