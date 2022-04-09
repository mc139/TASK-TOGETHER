package boat.model;

import boat.model.boat.Boat;
import boat.model.boat.DockEntry;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Dock {

    private String name;
    private double capacityInCubicMeters;
    private List<Boat> boats = new ArrayList<>();
    private List<DockEntry> entries = new ArrayList<>();

    public Dock(String name, double capacityInCubicMeters) {
        this.name = name;
        this.capacityInCubicMeters = capacityInCubicMeters;
    }

    public double getOccupiedCapacity() {
        return Optional.ofNullable(boats).orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getVolume() != 0)
                .mapToDouble(Boat::getVolume)
                .sum();
    }

    public double getCapacityLeft() {
        return capacityInCubicMeters - getOccupiedCapacity();
    }

    @Override
    public String toString() {
        return "Dock{" +
                "name='" + name + '\'' +
                ", capacityInCubicMeters=" + capacityInCubicMeters;
    }


}
