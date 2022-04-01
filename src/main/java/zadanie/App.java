package zadanie;

import com.github.javafaker.Faker;
import zadanie.model.Dock;
import zadanie.model.Person;
import zadanie.model.boat.Boat;
import zadanie.model.boat.BoatSize;
import zadanie.model.boat.DockEntry;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        Faker faker= new Faker();
        Dock dock = new Dock("test",20000);

        for (int i = 0; i < 20; i++) {
             new Person(faker.name().firstName(), 20, LocalDate.of(1990, 11, 11));
        }
        Boat boat = new Boat("test", BoatSize.SMALLBOAT,1300,null,4);
        dock.addEntry(new DockEntry(dock,boat,LocalDate.now()));

        System.out.println(Person.peopleExtension);

        System.out.println(dock);
        System.out.println(boat);
        System.out.println(dock.getBoats());



    }
}
