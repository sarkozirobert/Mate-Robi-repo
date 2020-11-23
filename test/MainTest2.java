import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MainTest2 {

    @Before
    public void setUp() throws Exception {
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
            Main.indians.add(indian);
        }

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void main() {
    }

    @Test
    public void howManyBelongingsInTheInventory() {
    }

    @Test
    public void countIndiansInTribe() {
    }

    @Test
    public void countRateOfMenInSeminole() {
    }

    @Test
    public void eldersInApache() {
    }
}