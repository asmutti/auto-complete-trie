import core.AutoCompleteEngine;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var engine = new AutoCompleteEngine();

        var stations = new ArrayList<>(Arrays.asList(
                "Santa Iria",
                "Santa Margarida",
                "Santana-Cartaxo",
                "Santarém",
                "Santo Amaro de Oeiras"
        ));

        stations.forEach((station) -> {
            engine.addToDictionary(station);
        });

        var suggestions = engine.autoComplete("sant");

        engine.print(suggestions);
    }
}
