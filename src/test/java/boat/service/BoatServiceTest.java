package boat.service;

import boat.model.Person;
import boat.model.boat.Boat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BoatServiceTest {

    @Before
    public void init() {
        Boat.boatExtension.clear();
        for (int i = 0; i < 100; i++) {
            new Boat("boat  " + i, 20 + i, 100 + i, new Person("test", 20 + i, LocalDate.of(1990, 11, 11)), 400);
        }
        for (int i = 0; i < 100; i++) {
            new Person("Bob" + 1, 15 + 1, LocalDate.of(1990, 1, 1));
        }
    }

    @Test
    public void shouldReturnBoatWithYoungestCrew() {
        //GIVEN
        Boat boat = new Boat("boat ", 20, 100, new Person("test", 20, LocalDate.of(1990, 11, 11)), 400);
        Boat boat1 = new Boat("boat ", 20, 100, new Person("test", 20, LocalDate.of(1990, 11, 11)), 400);
        for (int i = 0; i < Person.peopleExtension.size(); i++) {
            if (i >= 55) {
                boat.getCrew().add(Person.peopleExtension.get(i));
            } else {
                boat1.getCrew().add(Person.peopleExtension.get(i));
            }
        }
        //EXPECTED
        assertEquals(boat, BoatService.getBoatWithYoungestCrew(Boat.boatExtension));

    }

    @Test
    public void shouldReturn100() {
        //THEN
        Assert.assertEquals(100, Boat.boatExtension.size());
    }

}