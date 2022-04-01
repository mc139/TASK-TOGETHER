package zadanie.model.boat;


import lombok.Data;
import lombok.Getter;
import zadanie.exception.TooManyPeopleException;
import zadanie.model.Dock;
import zadanie.model.Person;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Boat {

    private final String name;
    private BoatSize boatSize;
    private final int regNo;
    private Person owner;
    private final List<Person> crew = new ArrayList<>();
    private final double volume;
    private final int capacity;
    private Dock dock;

    public Boat(String name, BoatSize boatSize, int regNo, Person owner, int capacity) {
        this.name = name;
        this.boatSize = boatSize;
        this.volume = boatSize.getSize();
        this.regNo = regNo;
        this.owner = owner;
        this.capacity = capacity;
    }

    public Boat(String name, double volume, int regNo, Person owner, int capacity) {
        this.name = name;
        this.volume = volume;
        this.regNo = regNo;
        this.owner = owner;
        this.capacity = capacity;
    }

    public void addPerson(Person person) {
        if(crew.size() >= capacity){
            throw new TooManyPeopleException("Unable to add person to the crew! MAX CAPACITY IS: " + capacity);
        }
        crew.add(person);

    }

    //todo sprawdzic czy owner ma wiecej niz 21 lat jesli nie to thoro exception
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }
}
