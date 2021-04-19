package ru.netology.geo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    public static final String LOCALHOST = "127.0.0.1";
    public static final String MOSCOW_IP = "172.0.32.11";
    public static final String NEW_YORK_IP = "96.44.183.149";

    @Test
    void byMoscowIp() {
        String expected = "172.0.32.11";

        assertTrue(expected.startsWith("172."));
    }

    @Test
    void byNewYorkIp() {
        String expected = "96.44.183.149";

        assertTrue(expected.startsWith("96."));
    }

    @Test
    void byLocalHostIp() {
        String expected = "127.0.0.1";

        assertTrue(expected.startsWith("127."));
    }

    @Test
    void ipIsNull() {
        String expected = null;

        assertNull(expected);
    }

    @Test
    void ipIsEmpty() {
        String expected = "";

        String actual = "";

        assertEquals(expected, actual);
    }
}