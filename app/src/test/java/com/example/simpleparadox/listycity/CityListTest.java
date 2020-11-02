package com.example.simpleparadox.listycity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewen");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        final CityList cityList = mockCityList();
        final City city = new City("Yellowknife", "NorthWest");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, cityList.getCities().get(0));

        City city = new City("CharLottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));

    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");
        cityList.add(city);

        assertEquals(2, cityList.countCities());

        cityList.delete(mockCity());

        assertEquals(1, cityList.countCities());
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
    }

    @Test
    void testDeleteException() {
        final CityList cityList = mockCityList();
        cityList.delete(mockCity());

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(mockCity());
        });
    }



}
