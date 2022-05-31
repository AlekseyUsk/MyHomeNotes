package uiCity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hfad.myhomenotes.R;

import domainCity.City;

public class CityDetailsActivity extends AppCompatActivity {
    // todo --> тут я через intent передаю в активити город
    private static final String EXTRA_CITY = "EXTRA_CITY";

    public static void show(Context context, City city) {

        Intent intent = new Intent(context, CityDetailsActivity.class);

        intent.putExtra(EXTRA_CITY, city);

        context.startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);
        //если первое открытие то вытаскиваем город который нам передали
        if (savedInstanceState == null) {

            City city = getIntent().getParcelableExtra(EXTRA_CITY);  // если самое первое открытие вытаскиваем город

            CityDetailsFragment cityDetailsFragment = CityDetailsFragment.newInstance(city);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_activity_city_details, cityDetailsFragment)
                    .commit();
        }
    }
}