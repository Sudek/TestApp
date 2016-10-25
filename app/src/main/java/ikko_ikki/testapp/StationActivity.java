package ikko_ikki.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ikko_ikki.testapp.utils.AllCities;
import ikko_ikki.testapp.utils.CitiesFrom;
import ikko_ikki.testapp.utils.StationFrom;

public class StationActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<StationFrom> stationFrom;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        recyclerView = (RecyclerView) findViewById (R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        stationFrom = initializeDataFrom();
        StationAdapter adapter = new StationAdapter(stationFrom, recyclerView.getContext());
        recyclerView.setAdapter(adapter);
    }

    private List<StationFrom> initializeDataFrom() {
        final Gson gson = new Gson();
        final InputStream is = getResources().openRawResource(R.raw.all_stations);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final ArrayList<StationFrom> stationList = new ArrayList<>();
        final String lowerCaseQuery = newText.toLowerCase();
        for (int i  = 0; i < stationFrom.size(); i++) {
            String city = stationFrom.get(i).getStationTitle().toLowerCase();
            if(city.contains(lowerCaseQuery)) {
                stationList.add(stationFrom.get(i));
            }
        }
        recyclerView.scrollToPosition(0);
        StationAdapter adapter = new StationAdapter(stationList, recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        return true;
    }
    //set chosen city in main screen
    public void intentSourceCity(String station) {
        final Intent i = new Intent();
        i.putExtra("station", station);
        setResult(Activity.RESULT_OK, i);
        finish();
    }

    public void intentInfoStation(String station, String country, String region, String city, String district) {
        final Intent i = new Intent(this, StationInfoActivity.class);
        i.putExtra("station", station);
        i.putExtra("country", country);
        i.putExtra("region", region);
        i.putExtra("city", city);
        i.putExtra("district", district);
        startActivity(i);
    }
}