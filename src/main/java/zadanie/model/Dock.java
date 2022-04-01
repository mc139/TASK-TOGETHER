package zadanie.model;

import lombok.Getter;
import lombok.Setter;
import zadanie.model.boat.Boat;
import zadanie.model.boat.DockEntry;

import java.util.ArrayList;
import java.util.List;

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

//    public void addBoat(Boat boat){
//        if()
//        boat.setDock(this);
//        boats.add(boat);
//    }

    ////todo sprawdzic czy jest wystarczajaco duzo miejsca i czy lodka nie jest juz w zadnycm docku a jesli jest to rzucamy wyjatkiem
    public void addEntry(DockEntry entry){
        entries.add(entry);
        boats.add(entry.getBoat());
    }

    @Override
    public String toString() {
        return "Dock{" +
                "name='" + name + '\'' +
                ", capacityInCubicMeters=" + capacityInCubicMeters;
    }
}
