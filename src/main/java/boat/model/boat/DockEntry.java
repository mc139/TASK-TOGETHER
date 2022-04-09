package boat.model.boat;

import boat.exception.BoatAlreadyHasADockException;
import boat.exception.TooBigBoatException;
import boat.model.Dock;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DockEntry {
    Dock dock;
    Boat boat;
    LocalDate date;

    //todo testy
    public DockEntry(Dock dock, Boat boat, LocalDate date) {
        if (boat.getDock() != null) {
            throw new BoatAlreadyHasADockException("This boat alread has a dock !!" + boat.getName());
        }
        if (dock.getCapacityLeft() < boat.getVolume()) {
            throw new TooBigBoatException("The boat is too big");
        }
        this.dock = dock;
        this.boat = boat;
        this.date = date;
        dock.getBoats().add(boat);
        boat.setDock(dock);
    }

}
