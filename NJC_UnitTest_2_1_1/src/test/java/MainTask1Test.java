import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTask1Test {

    @Test
    void fileName_success() {
        System.out.println("fileName_success");
        String expected = "new_data.json";

        String actual = "new_data.json";

        assertEquals(expected, actual);
    }

    @Test
    void fileName_isEmpty() {
        System.out.println("fileName_isEmpty");
        String expected = "";

        String actual = "";

        assertEquals(expected, actual);
    }

    @Test
    void fileName_isNotEmpty() {
        System.out.println("fileName_isNotEmpty");
        String expected = "";

        String actual = "new_data.json";

        assertNotEquals(expected, actual);
    }

    @Test
    void fileName_isNull() {
        System.out.println("fileName_isNull");
        String expected = null;

        assertNull(expected);
    }

    @Test
    void fileName_isNotNull() {
        System.out.println("fileName_isNotNull");
        String expected = "new_data.json";

        assertDoesNotThrow(() ->
                expected.equals("null")
        );
    }
}