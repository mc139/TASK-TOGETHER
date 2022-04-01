package zadanie.model.boat;

import org.junit.Before;
import org.junit.Test;
import zadanie.exception.TooManyPeopleException;
import zadanie.model.Person;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BoatTest {

     Boat boat;

     @Before
     public void init(){
         boat = new Boat("test", BoatSize.SMALLBOAT, 1200, null, 4);
     }


    @Test(expected = TooManyPeopleException.class)
    public void shouldThrowTooManyPeopleExceptionWhen5PeopleBeingAdded() {
        //GIVEN
        Person person = new Person("", 12, LocalDate.of(1990, 11, 11));
        Person person1 = new Person("", 12, LocalDate.of(1990, 11, 11));
        Person person2 = new Person("", 12, LocalDate.of(1990, 11, 11));
        Person person3 = new Person("", 12, LocalDate.of(1990, 11, 11));
        Person person4 = new Person("", 12, LocalDate.of(1990, 11, 11));


        //WHEN

        boat.addPerson(person);
        boat.addPerson(person1);
        boat.addPerson(person2);
        boat.addPerson(person3);
        boat.addPerson(person4);

    }

    @Test
    public void shouldAdd3PeopleToTheCrewAndReturn3() {
        //GIVEN
        Person person = new Person("", 12, LocalDate.of(1990, 11, 11));
        Person person1 = new Person("", 12, LocalDate.of(1990, 11, 11));
        Person person2 = new Person("", 12, LocalDate.of(1990, 11, 11));

//        Boat boat1 = new Boat("test", BoatSize.SMALLBOAT, 1200, null, 3);

//    WHEN
        boat.addPerson(person);
        boat.addPerson(person1);
        boat.addPerson(person2);

        //THEN
        assertEquals(3, boat.getCrew().size());

    }

}