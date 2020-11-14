package spring.TDDService;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class CityPopulationService {

    public Integer getCityPopulation(String cityName) {
        if (StringUtils.isEmpty(cityName)) return 0;
        Map<String, Integer> cityPopulationCount = getCityPopulationCount();
        if (!cityPopulationCount.containsKey(cityName)) return 0;
        return cityPopulationCount.get(cityName);
    }

    private Map<String, Integer> getCityPopulationCount() {
        return new HashMap<String, Integer>() {{
                put("Isfahan", 2000000);
                put("Tehran", 5000000);
                put("Yazd", 500000);
                put("Mashhad", 1000000);
            }};
    }
}
