package main_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.hfad.myhomenotes.R;

import ui.Notes_List;
import uiCity.CitiesListFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_action_nav:
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.container_activity, new Notes_List())
                                .commit();
                        return true;

                    case R.id.bottom_city_list:
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.container_activity, new CitiesListFragment())
                                .commit();


                }


                return false;
            }
        });


    }
}