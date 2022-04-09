package boat.service;

import boat.model.Dock;
import boat.model.boat.Boat;
import boat.model.boat.DockEntry;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

@Getter
public class DockService {
    //tylko i wylacznie metody dotyczaczace klasuy dock

    public static Boat getBoatWhichMooredTheLongest(Dock dock) {
        return Optional.ofNullable(dock.getEntries()).orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(en -> en.getDate() != null)
                .min(Comparator.comparing(c -> c.getDate().compareTo(LocalDate.now())))
                .map(DockEntry::getBoat)
                .orElseThrow(() -> new IllegalArgumentException("Could not find a boat"));

    }

//     3. Metody typu zwróć najmłodszą załogę, właściciela itd.

}
