package boat.dto;

import boat.model.Dock;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class DockToTxtDto {

    // motoda przyjume liste dockow i wypisuje zawartowsc do pliku txt

    // metode ktora robi to samo tylko z jednym dockiem


    public static void saveDockToTxtFile(Dock dock) {

        String name = dock.getName();

        //todo zmiana sciezki zapisywanie pliku!
        try (FileWriter writer = new FileWriter(name + ".txt");
             BufferedWriter bw = new BufferedWriter(writer)) {

            String dockAsFormattedString = getDockAsFormattedString(dock);
            bw.write(dockAsFormattedString);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    private static String getDockAsFormattedString(Dock dock) {
        StringBuilder sb = new StringBuilder();
        sb.append("########")
                .append(dock.getName().toUpperCase(Locale.ROOT))
                .append("########")
                .append('\n')
                .append(dock.getBoats())
                .append("\n")
                .append(dock.getCapacityInCubicMeters());
        return sb.toString();
    }

    public static void main(String[] args) {
        Dock dock = new Dock("testowy dock", 20321300);
        Dock dock1 = new Dock("testowy dock11", 232131000);
        Dock dock2 = new Dock("testowy dock22", 20231200);
        Dock dock3 = new Dock("testowy dock333", 20023120);

        saveDockToTxtFile(dock1);
        saveDockToTxtFile(dock2);
        saveDockToTxtFile(dock3);
        saveDockToTxtFile(dock);
    }


}
