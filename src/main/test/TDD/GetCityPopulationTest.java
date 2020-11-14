package TDD;

import org.junit.Before;
import org.junit.Test;
import spring.TDDService.CityPopulationService;

import static org.junit.Assert.assertEquals;

public class GetCityPopulationTest {
    CityPopulationService cityPopulationService=null;

    @Before
    public void createObjectInstance(){
        cityPopulationService=new CityPopulationService();
    }


    @Test
    public void getCityPopulation() {
        String cityName = "Isfahan";
        Integer expectedCityPopulationCount = 2000000;
        Integer cityPopulationCount = cityPopulationService.getCityPopulation(cityName);
        assertEquals(cityPopulationCount, expectedCityPopulationCount);
    }

    @Test
    public void getCityPopulationEmptyValue() {
        String cityName = "";
        Integer expectedCityPopulationCount = 0;
        Integer cityPopulationCount = cityPopulationService.getCityPopulation(cityName);
        assertEquals(cityPopulationCount, expectedCityPopulationCount);
    }

    @Test
    public void getCityPopulationNullValue() {
        String cityName = null;
        Integer expectedCityPopulationCount = 0;
        Integer cityPopulationCount = cityPopulationService.getCityPopulation(cityName);
        assertEquals(cityPopulationCount, expectedCityPopulationCount);
    }
    @Test
    public void getCityPopulationInvalidValue() {
        String cityName = "fasghdgha";
        Integer expectedCityPopulationCount = 0;
        Integer cityPopulationCount = cityPopulationService.getCityPopulation(cityName);
        assertEquals(cityPopulationCount, expectedCityPopulationCount);
    }
}
