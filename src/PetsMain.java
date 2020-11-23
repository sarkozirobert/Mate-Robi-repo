import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PetsMain {
    public static void main(String[] args) throws FileNotFoundException {

//        Beolvasás a pets.txt-ből

        ArrayList<Pet> petArrayList = new ArrayList<>();
        ArrayList<PetsOwner> petsOwnerArrayList = new ArrayList<>();
        Scanner sc = new Scanner(new File("pets.txt"));
        for (int i = 0; sc.hasNext(); i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            Pet pet = new Pet();
            pet.setPetCode(Integer.parseInt(parts[0]));
            pet.setName(parts[1]);
            pet.setType(parts[2]);
            pet.setAge(Integer.parseInt(parts[3]));
            petArrayList.add(pet);
        }

//        Beolvasás a petowner.txt-ből
        sc = new Scanner(new File("petowners.txt"));
        for (int i = 0; sc.hasNext(); i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            parts = line.split(",");
            PetsOwner owner = new PetsOwner();
            owner.setName(parts[0]);
            owner.setSex(parts[2]);
            owner.setAge(Integer.parseInt(parts[1]));
            for (int j = 3; j < parts.length; j++) {
                owner.pets.add(Integer.parseInt(parts[j]));
                for (int k = 0; k < petArrayList.size(); k++) {
                    if (petArrayList.get(k).petCode == Integer.parseInt(parts[j])) {
                        petArrayList.get(k).setPetsOwner(owner.getName());

                        owner.ownedPets.add(petArrayList.get(k));
                        owner.ownedPetNames.add(petArrayList.get(k).getName());

                    }
                }
            }
            petsOwnerArrayList.add(owner);

        }
//        1. Állattartók kora szerinti növekvő sorrendbe rendezve kiírja az állattartókat és állataikat!



        TreeMap<Integer, HashMap<String, ArrayList<String>>> ageMap = new TreeMap<>();
        for (PetsOwner petsOwner : petsOwnerArrayList) {
            ageMap.putIfAbsent(petsOwner.getAge(), new HashMap<>());
            ArrayList<String> ownersAnimalsNames = new ArrayList<>();
            for (int i = 0; i < petsOwner.getPets().size(); i++) {
                ownersAnimalsNames.add(petsOwner.getOwnedPetNames().get(i));
            }
            ageMap.get(petsOwner.getAge()).put(petsOwner.name, ownersAnimalsNames);
        }
        System.out.println("1. Állattartók kora szerinti növekvő sorrendbe rendezve kiírja az állattartókat és állataikat!");
        System.out.println(ageMap);


//Állattartók
//        Egy adatbázis állattartókat és az állataikat tartalmazza. Az állattartókról nyilvántartjuk a nevüket, az életkorukat (évben) a nemüket,
//        és kedvencei egyedi azonosítóját (ez egy egész szám). Az állatokról egy másik fájlban nyilvántartjuk az azonosítójukat, a nevüket,
//        a fajtájukat és a korukat (évben megadva).
//        Írj programot, ami beolvassa a fájlt és ez alapján létrehoz egy megfelelő adatstruktúrát! Hozz létre egy PetOwner és egy Pet osztályt.
//        A két osztály kölcsönösen hivatkozzon egymásra, vagyis a PetOwner osztály tartalmazza az állattartó által tulajdonolt állatokat, a Pet
//        osztály pedig a kis kedvenc tulajdonosát!

//        Írj programot, ami

        //        2. Állatok kora szerinti növekvő sorrendbe rendezve kiírja az
//        állattartókat és állataikat!

      TreeMap<Integer, HashMap<String, String>> ageOfPetsMap = new TreeMap<>();
        for (PetsOwner petsOwner : petsOwnerArrayList) {
            for (int i = 0; i < petsOwner.ownedPetNames.size(); i++) {
                ageOfPetsMap.putIfAbsent(petsOwner.ownedPets.get(i).age, new HashMap<>());
            }
//        ArrayList<String> ownersAnimalsNames = new ArrayList<>();
//        for (int i = 0; i < petsOwner.getPets().size(); i++) {
//        ownersAnimalsNames.add(petsOwner.getOwnedPetNames().get(i));
//        }
            for (int i = 0; i < petsOwner.ownedPetNames.size(); i++) {
                ageOfPetsMap.get(petsOwner.getOwnedPets().get(i).getAge()).put(petsOwner.name, petsOwner.getOwnedPets().get(i).getName());
            }
        }
        System.out.println(" 2. Állatok kora szerinti növekvő sorrendbe rendezve kiírja az" +
                "//        állattartókat és állataikat!");
        System.out.println(ageOfPetsMap);


//        3. Listázza azokat az állattartókat, akiknek van legalább egy náluk idősebb házikedvence!
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < petsOwnerArrayList.size(); i++) {
            for (int j = 0; j < petsOwnerArrayList.get(i).ownedPets.size(); j++) {
                if (petsOwnerArrayList.get(i).getOwnedPets().get(j).getAge() > petsOwnerArrayList.get(i).getAge()) {
                    hashSet.add(petsOwnerArrayList.get(i).getName());
                }
            }
        }
        System.out.println( "3. Listázza azokat az állattartókat, akiknek van legalább egy náluk idősebb házikedvence!");
        System.out.println(hashSet);
    }
//        A fájlok tartalma:
//        petowners.txt
//
//        Patta Nora,31,nő,1,2
//        Remek Elek,12,ffi,3,4
//        Szalmon Ella,23,nő,5
//        Techno Kolos,41,ffi,6
//        Trab Antal,30,ffi,7,8
//        Ultra Viola,11,nő,9,10,11
//        Am Erika,27,nő,12,13
//        Bac Ilus,62,nő,14
//
//
//        pets.txt
//
//        1,Lizi,gyík,5
//        2,Hedvig,bagoly,11
//        3,Zeusz,doberman,7
//        4,Apollo,doberman,7
//        5,Murci,perzsamacska,11
//        6,Leila,macska,6
//        7,Mogyoro,macska,22
//        8,Maci,bernáthegyi,9
//        9,Elvis,botsáska,1
//        10,Rambo,foltos szalamandra,2
//        11,Magnum,piton,20
//        12,Pedro,bernáthegyi,6
//        13,Samson,csivava,3
//        14,Mazsola,elefánt,32
//
//        Pl. Patta Nóra egy 31 éves nő, akinek két állata van: Lizi az 5 éves gyík és Hedvig a 11 éves bagoly.
//
//
//
//        Szorgalmi:
//        1. Kérd be a felhasználótól egy háziállat nevét! Valósíts meg egy metódust, amely visszaadja az adott nevű háziállat gazdáját!
//        2. Kérd be a felhasználótól egy állattartó nevét! Valósíts meg egy metódust, amely visszaadja az adott nevű állattartó házikedvenceit, életkor szerinti csökkenő sorrendben!
//        3. Melyik állattartónak van a legtöbb házikedvence?
//        4. Bővítsd a PetOwner osztályt egy int getPetCount() metódussal, ami visszaadja, hogy az adott gazdának hány háziállata van!
//        5. Bővítsd ki úgy a PetOwner osztályt, hogy ne csak az állatok listáját tartalmazza, hanem hivatkozzon egy kedvenc háziállatra is! (Beolvasásnál legyen ez az adott állattartóhoz tartozó listában először beolvasott háziállat!) Bővítsd ki a Pet osztályt is úgy, hogy egy boolean-ban tárolja el, hogy ő kedvenc háziállat-e!
//        a. Melyik állattartónak a legidősebb a kedvenc háziállata?
//        b. Hogy hívják a legfiatalabb kedvencként megjelölt háziállat gazdáját?
//        6. Melyik betűvel kezdődik a legtöbb háziállatnév? A visszatérési érték egy egybetűs String, a metódus szignatúrája pedig az alábbi legyen:
//        String getPopuparFirstLetter()
//        7. Bővítsd a Pet osztályt egy boolean isOlderThanOwner() metódust, amely akkor és csak akkor adjon vissza igaz értéket, ha az állat idősebb, mint a gazdája!
}


