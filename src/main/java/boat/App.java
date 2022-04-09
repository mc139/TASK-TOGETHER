package boat;

import boat.model.Dock;
import boat.model.Person;
import boat.model.boat.Boat;
import boat.model.boat.BoatSize;
import boat.model.boat.DockEntry;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Dock dock = new Dock("test", 20000);

        Person oldOwner = new Person("Jack", 99, LocalDate.of(1990, 1, 1));
        Person youngOwner = new Person("Bob", 25, LocalDate.of(1990, 1, 1));

        for (int i = 0; i < 100; i++) {
            new Person(faker.name().firstName(), 20 + i, LocalDate.of(1990, 11, 11));
        }
        Boat boat1 = new Boat("test OLD ", BoatSize.SMALLBOAT, 1300, null, 4);
        Boat boat2 = new Boat("test YOUNG", BoatSize.SMALLBOAT, 1300, null, 4);
//        Boat boat3 = new Boat("test", BoatSize.SMALLBOAT,1300,null,4);
//        Boat boat4 = new Boat("test", BoatSize.SMALLBOAT,1300,null,4);
//        Boat boat5 = new Boat("test", BoatSize.SMALLBOAT,1300,null,4);
        new DockEntry(dock, boat1, LocalDate.of(2000, 11, 11));
        new DockEntry(dock, boat2, LocalDate.of(2011, 11, 11));
//        dock.addEntry(new DockEntry(dock,boat3,LocalDate.of(2010,11,11)));
//        dock.addEntry(new DockEntry(dock,boat4,LocalDate.of(2009,11,11)));

        // System.out.println(Person.peopleExtension);

        for (int i = 0; i < Person.peopleExtension.size(); i++) {
            if (i >= 55) {
                boat1.getCrew().add(Person.peopleExtension.get(i));
            } else {
                boat2.getCrew().add(Person.peopleExtension.get(i));
            }
        }

        List<Boat> boatExtension = Boat.boatExtension;

        System.out.println(dock.getBoats().size());
        System.out.println(dock.getOccupiedCapacity());

        boat1.setOwner(oldOwner);
        boat2.setOwner(youngOwner);

//        Boat boatWithYoungestCrew = BoatService.getBoatWithYoungestCrew(boatExtension);
//        System.out.println(boatWithYoungestCrew);
//        System.out.println(dock);
//        System.out.println(boat1);
//        System.out.println(dock.getBoats());

//        System.out.println(BoatService.getOldestOwnerFromListOfBoats(boatExtension));

//        System.out.println(DockService.getBoatWhichMooredTheLongest(dock));


    }
}
