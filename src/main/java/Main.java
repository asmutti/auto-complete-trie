import core.AutoCompleteEngine;

public class Main {
    public static void main(String[] args) {
        var engine = new AutoCompleteEngine();


        engine.addToDictionary("Santa Iria");
        engine.addToDictionary("Santa Margarida");

        var result = engine.autoComplete("santa ");

        engine.print(result);
    }
}
