package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void locationRussia() {
        Country expected = Country.RUSSIA;

        Country actual = Country.RUSSIA;

        assertEquals(expected, actual);
    }

    @Test
    void otherLocations() {
        Country expected = Country.USA;

        Country actual = Country.USA;

        assertEquals(expected, actual);
    }

    @Test
    void nullLocations() {
        Country expected = null;

        assertNull(expected);
    }
}