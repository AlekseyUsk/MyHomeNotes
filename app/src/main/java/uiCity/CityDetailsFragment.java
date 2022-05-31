package uiCity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.hfad.myhomenotes.R;

import domainCity.City;

public class CityDetailsFragment extends Fragment {

    private static final String ARG_CITY = "ARG_CITY";

    public static CityDetailsFragment newInstance(City city) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);

        CityDetailsFragment fragment = new CityDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView title = view.findViewById(R.id.title);
        ImageView imageView = view.findViewById(R.id.icon);

        City city = getArguments().getParcelable(ARG_CITY);
        title.setText(city.getName());
        imageView.setImageResource(city.getIcon());
    }
}
