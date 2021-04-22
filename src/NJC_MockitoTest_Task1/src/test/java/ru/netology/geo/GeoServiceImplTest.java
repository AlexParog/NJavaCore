package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    private final GeoService geoService = new GeoServiceImpl();
    private final LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void locationLocalHost() {
        Location location = geoService.byIp("127.0.0.1");
        assertNull(location.getCountry());
    }

    @Test
    void locationRussia() {
        Location location = geoService.byIp("172.0.32.11");
        System.out.println(location.getCountry());

        Country actual = Country.RUSSIA;

        assertEquals(location.getCountry(), actual);
    }

    @Test
    void locationUSA() {
        Location location = geoService.byIp("96.44.183.149");
        System.out.println(location.getCountry());

        Country actual = Country.USA;

        assertEquals(location.getCountry(), actual);
    }
}