import core.AutoCompleteEngine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoCompleteEngineTest {

    private static AutoCompleteEngine engine;

    @BeforeAll
    public static void setup(){
        engine = new AutoCompleteEngine();
    }

    @Test
    public void testSuccessful() {
        engine.addToDictionary("Santa Combadao");

        assertEquals(1, engine.autoComplete("santa").size());
        assertEquals(1, engine.autoComplete("santa ").size());
        assertEquals("santa combadao", engine.autoComplete("santa ").get(0));

        engine.clearDictionary();
    }

    @Test
    public void testEmptyString() {

        assertThrows(IllegalArgumentException.class, () -> {
            engine.addToDictionary("");
        });

        engine.clearDictionary();
    }

    @Test
    public void testBlankString() {

        assertThrows(IllegalArgumentException.class, () -> {
            engine.addToDictionary(" ");
        });

        engine.clearDictionary();
    }

    @Test
    public void testManyStrings() {
        engine.addToDictionary("Santa Iria");
        engine.addToDictionary("Santa Margarida");
        engine.addToDictionary("Santana-Cartaxo");
        engine.addToDictionary("Santarém");
        engine.addToDictionary("Santo Amaro de Oreias");

        assertEquals(5, engine.autoComplete("sant").size());
        assertEquals(1, engine.autoComplete("santarém").size());
        assertEquals(4, engine.autoComplete("Santa").size());
        assertEquals(1, engine.autoComplete("Santo ").size());

        assertTrue("Santo Amaro de Oreias".equalsIgnoreCase(engine.autoComplete("Santo ").get(0)));

        engine.clearDictionary();
    }
}
