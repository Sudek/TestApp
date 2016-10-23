package ikko_ikki.testapp;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class StationActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<Station> stations;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        recyclerView = (RecyclerView) findViewById (R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        stations = new ArrayList<>();
        stations.add(new Station("Австрия", "Вена"));
        stations.add(new Station("Австрий", "Зальцбург"));
        stations.add(new Station("Венгрия", "Будапешт"));
    }

    private void initializeAdapter(){
        StationAdapter adapter = new StationAdapter(stations);
        recyclerView.setAdapter(adapter);
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
        ArrayList<Station> stationList = new ArrayList<>();
        final String lowerCaseQuery = newText.toLowerCase();
        for (int i  = 0; stations.size() != i; i++) {
            String city = stations.get(i).getCity().toLowerCase();
            if(city.contains(lowerCaseQuery)) {
                stationList.add(stations.get(i));
            }
        }
        recyclerView.scrollToPosition(0);
        StationAdapter adapter = new StationAdapter(stationList);
        recyclerView.setAdapter(adapter);
        return true;
    }
}