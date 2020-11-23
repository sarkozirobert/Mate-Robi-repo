import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MainTest {

    @Before
    public void setUp() throws Exception {
        Scanner sc = new Scanner(new File("txtFiles/indianok.txt"));
        for (int i = 0; i <1 ; i++) {

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
            Main.indians.add(indian);
            System.out.println("1");
            System.out.println(indian.getAge());
        }
        Indian indian2 = new Indian("","Seminole","f",0,new HashSet<>());
        Main.indians.add(indian2);

    }

    @After
    public void tearDown() throws Exception {
        Main.indians.remove(0);
        Main.indians.remove(0);
    }

    @Test
    public void main() {
    }

    @Test
    public void howManyBelongingsInTheInventory() {
        int cnt = 3;
        Assert.assertEquals(cnt,Main.howManyBelongingsInTheInventory());
    }

    @Test
    public void countIndiansInTribe() {
        Assert.assertEquals(1,Main.countIndiansInTribe("Apache"));
        Assert.assertEquals(1,Main.countIndiansInTribe("Seminole"));

    }

    @Test
    public void countRateOfMenInSeminole() throws FileNotFoundException {
//        Scanner sc = new Scanner(new File("txtFiles/indianok.txt"));
//        sc.nextLine();
//        for (int i = 0; i <6 ; i++) {
//        String line = sc.nextLine();
//        String[] parts = line.split(",");
//        HashSet<String> belongingsHashSet = new HashSet<>();
//        String[] belongingsArray = parts[4].split("\\|");
//        for (String string : belongingsArray) {
//            belongingsHashSet.add(string);
//        }
//        Indian indian = new Indian(
//                parts[0],
//                parts[1],
//                parts[2],
//                Integer.parseInt(parts[3]),
//                belongingsHashSet);
//        Main.indians.add(indian);
//        System.out.println("1");
//        System.out.println(indian.getAge());
//    }
        Assert.assertEquals(100,Main.countRateOfMenInSeminole(Main.indians),1);
    }

    @Test
    public void eldersInApache() {
        Assert.assertEquals(new ArrayList<>(),Main.eldersInApache(Main.indians));
    }
}