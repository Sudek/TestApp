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

import ikko_ikki.testapp.utils.AllStations;
import ikko_ikki.testapp.utils.CitiesFrom;

public class StationActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<CitiesFrom> stations;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        recyclerView = (RecyclerView) findViewById (R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        stations = initializeData();

        StationAdapter adapter = new StationAdapter(stations, recyclerView.getContext());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<CitiesFrom> initializeData() {
        final Gson gson = new Gson();
        final InputStream is = getResources().openRawResource(R.raw.all_stations);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        final AllStations station = gson.fromJson(reader, AllStations.class);
        return (ArrayList<CitiesFrom>) new ArrayList(station.getCitiesFrom());
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
        final ArrayList<CitiesFrom> citiesList = new ArrayList<>();
        final String lowerCaseQuery = newText.toLowerCase();
        for (int i  = 0; stations.size() != i; i++) {
            String city = stations.get(i).getCityTitle().toLowerCase();
            if(city.contains(lowerCaseQuery)) {
                citiesList.add(stations.get(i));
            }
        }
        recyclerView.scrollToPosition(0);
        StationAdapter adapter = new StationAdapter(citiesList, recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        return true;
    }

    public void intentSourceCity(String city) {
        final Intent intent = new Intent();
        intent.putExtra("city", city);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}