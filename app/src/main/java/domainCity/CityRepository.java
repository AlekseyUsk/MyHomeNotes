package domainCity;

import java.util.List;

public interface CityRepository {

    List<City> getCity(); // получение заметок

    void addCity(City city); //добавление
}
