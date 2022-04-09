package boat.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Person {

    public static List<Person> peopleExtension = new ArrayList<>();
    private String name;
    private int age;
    private LocalDate dob;

    public Person(String name, int age, LocalDate dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        peopleExtension.add(this);
    }
}
