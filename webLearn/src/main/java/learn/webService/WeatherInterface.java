package learn.webService;

/**
 * Created by shifeixuan on 2019/3/25.
 */
public interface WeatherInterface {
    /**
     *查詢天气
     * @param cityName
     * @return String
     */
     String queryWeather(String cityName);
}
