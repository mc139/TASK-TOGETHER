package boat.model.boat;


import boat.exception.TooManyPeopleException;
import boat.model.Dock;
import boat.model.Person;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
public class Boat {

    public static List<Boat> boatExtension = new ArrayList<>();
    private final String name;
    private final int regNo;
    private final List<Person> crew = new ArrayList<>();
    private final double volume;
    private final int capacity;
    private BoatSize boatSize;
    private Person owner;
    private Dock dock;

    public Boat(String name, BoatSize boatSize, int regNo, Person owner, int capacity) {
        this.name = name;
        this.boatSize = boatSize;
        this.volume = boatSize.getSize();
        this.regNo = regNo;
        this.owner = owner;
        this.capacity = capacity;
        boatExtension.add(this);
    }

    public Boat(String name, double volume, int regNo, Person owner, int capacity) {
        this.name = name;
        this.volume = volume;
        this.regNo = regNo;
        this.owner = owner;
        this.capacity = capacity;
        boatExtension.add(this);
    }

    public void addPerson(Person person) {
        if (crew.size() >= capacity) {
            throw new TooManyPeopleException("Unable to add person to the crew! MAX CAPACITY IS: " + capacity);
        }
        crew.add(person);

    }

    public double getAverageAge() {
        return Optional.of(crew).orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getAge() > 0)
                .mapToInt(Person::getAge)
                .average().orElse(0);
    }

    public void setOwner(Person owner) {
        if (owner.getAge() < 21) {
            throw new IllegalArgumentException("This owner is too young!" + owner.getName());
        }
        this.owner = owner;

    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }
}
