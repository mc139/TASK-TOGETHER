package boat.service;

import boat.exception.BoatNotFoundException;
import boat.model.Person;
import boat.model.boat.Boat;

import java.util.*;

public class BoatService {

    //todo testy


    public static Boat getBoatWithYoungestCrew(List<Boat> boats) {
        return Optional.ofNullable(boats).orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(boat -> boat.getCrew() != null)
                .filter(boat -> boat.getCrew().size() != 0)
                .min(Comparator.comparingDouble(Boat::getAverageAge))
                .orElseThrow(() -> new BoatNotFoundException("Could not find a boat with youngest crew!!"));
    }

    public static Person getOldestOwnerFromListOfBoats(List<Boat> boats) {
        return Optional.ofNullable(boats).orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .map(Boat::getOwner)
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new IllegalArgumentException("Could not find an owner with greatest age"));
    }


}
