package ikko_ikki.testapp.model;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import ikko_ikki.testapp.R;
import ikko_ikki.testapp.data.AllCities;
import ikko_ikki.testapp.data.CitiesTo;
import ikko_ikki.testapp.data.StationTo;

public class StationToModelImp implements StationToModel {
    @Override
    public List<StationTo> initStationTo(Context context) {
        final Gson gson = new Gson();
        final InputStream is = context.getResources().openRawResource(R.raw.all_stations);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        final AllCities cities = gson.fromJson(reader, AllCities.class);
        List<CitiesTo> citiesToList = cities.getCitiesTo();
        List<StationTo> stationTo = citiesToList.get(0).getStations();
        for (int i = 1; i < citiesToList.size(); i++) {
            List<StationTo> sf = citiesToList.get(i).getStations();
            stationTo.addAll(sf); //merge to one List
        }
        return stationTo;
    }
}
