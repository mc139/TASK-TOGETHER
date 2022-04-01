package zadanie.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data

public class Person {

    private String name;
    private int age;
    private LocalDate dob;
    public static List<Person> peopleExtension = new ArrayList<>();

    public Person(String name, int age, LocalDate dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        peopleExtension.add(this);
    }
}
