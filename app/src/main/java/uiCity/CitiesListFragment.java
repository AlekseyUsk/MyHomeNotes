package uiCity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hfad.myhomenotes.R;

import java.util.List;

import domainCity.City;
import domainCity.InMemoryCityRepository;

public class CitiesListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bottom_info, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<City> cities = InMemoryCityRepository.getInstanceCity(requireContext()).getCity();

        LinearLayout container = view.findViewById(R.id.container_cities_list);

        for (City city : cities) {

            View itemView = getLayoutInflater().inflate(R.layout.item_cities, container, false);

            itemView.findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CityDetailsActivity.show(requireContext(), city);

                  //  Toast.makeText(requireContext(), city.getName(), Toast.LENGTH_SHORT).show();
                }
            });
            ImageView icon = itemView.findViewById(R.id.icon);

            icon.setImageResource(city.getIcon());

            TextView title = itemView.findViewById(R.id.title);

            title.setText(city.getName());

            container.addView(itemView);

        }
    }
}
