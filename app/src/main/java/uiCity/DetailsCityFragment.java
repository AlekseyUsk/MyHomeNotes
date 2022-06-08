package uiCity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.myhomenotes.R;

import domainCity.City;

public class DetailsCityFragment extends Fragment {

    private static final String ARG_CITY = "ARG_CITY";
    private static final String ARG_CITY_DETAILS_FRAGMENT = "ARG_CITY_DETAILS_FRAGMENT";

    public static DetailsCityFragment newInstance(City city) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);

        DetailsCityFragment fragment = new DetailsCityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_details_city, container, false);
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