package domainCity;

import android.content.Context;

import com.hfad.myhomenotes.R;

import java.util.ArrayList;
import java.util.List;

import domain.InMemoryNotesRepository;
import domainCity.City;
import domainCity.CityRepository;

public class InMemoryCityRepository implements CityRepository {

    private static CityRepository INSTANCE_CITY;

    public static CityRepository getInstanceCity(Context context) {
        if (INSTANCE_CITY == null) {
            INSTANCE_CITY = new InMemoryCityRepository(context);
        }
        return INSTANCE_CITY;
    }

    private Context context;

    public InMemoryCityRepository(Context context) {
        this.context = context;
    }

    @Override
    public List<City> getCity() {

        ArrayList<City> result = new ArrayList<>();

        result.add(new City(context.getString(R.string.msk), R.drawable.msc));
        result.add(new City(context.getString(R.string.nsk), R.drawable.nsk));
        result.add(new City(context.getString(R.string.ebrg), R.drawable.ebrg));
        result.add(new City(context.getString(R.string.sam), R.drawable.sam));
        result.add(new City(context.getString(R.string.spb), R.drawable.spb));
        return result;
    }

    @Override
    public void addCity(City city) {

    }
}
