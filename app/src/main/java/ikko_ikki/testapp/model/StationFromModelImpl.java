package ikko_ikki.testapp.model;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import ikko_ikki.testapp.R;
import ikko_ikki.testapp.data.AllCities;
import ikko_ikki.testapp.data.CitiesFrom;
import ikko_ikki.testapp.data.StationFrom;

public class StationFromModelImpl implements StationFromModel {

    @Override
    public List<StationFrom> initStationFrom(Context context) {
        final Gson gson = new Gson();
        final InputStream is = context.getResources().openRawResource(R.raw.all_stations);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        final AllCities cities = gson.fromJson(reader, AllCities.class);
        List<CitiesFrom> citiesFromList = cities.getCitiesFrom();
        List<StationFrom> stationFrom = citiesFromList.get(0).getStations();
        for (int i = 1; i < citiesFromList.size(); i++) {
            List<StationFrom> sf1 = citiesFromList.get(i).getStations();
            stationFrom.addAll(sf1); //merge to one List
        }
        return stationFrom;
    }
}
