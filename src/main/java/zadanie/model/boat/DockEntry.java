package zadanie.model.boat;

import lombok.Data;
import lombok.Getter;
import zadanie.model.Dock;

import java.time.LocalDate;

@Data
public class DockEntry {
    Dock dock;
    Boat boat;
    LocalDate date;

    public DockEntry(Dock dock, Boat boat, LocalDate date) {
        this.dock = dock;
        this.boat = boat;
        this.date = date;
        dock.addEntry(this);
        boat.setDock(dock);
        dock.addBoat(boat);
    }

}
