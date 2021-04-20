package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    private final GeoService geoService = new GeoServiceImpl();
    private final LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void locationRussia() {
        Location location = geoService.byIp("172.0.32.11");
        System.out.printf("Отправлено сообщение: %s", localizationService.locale(location.getCountry()));
    }

    @Test
    void otherLocations() {
        Location location = geoService.byIp("96.44.183.149");
        System.out.printf("Отправлено сообщение: %s", localizationService.locale(location.getCountry()));
    }
}