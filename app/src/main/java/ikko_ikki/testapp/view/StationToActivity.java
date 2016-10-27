package ikko_ikki.testapp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import ikko_ikki.testapp.R;
import ikko_ikki.testapp.data.StationTo;
import ikko_ikki.testapp.presenter.StationToPresenterImpl;
import ikko_ikki.testapp.view.adapter.StationToAdapter;

public class StationToActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, StationToView {

    private List<StationTo> stationTo;
    private RecyclerView recyclerView;
    private Context context;
    private StationToPresenterImpl toPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);
        recyclerView = (RecyclerView) findViewById (R.id.recycler_view);

        context = getApplicationContext();
        toPresenter = new StationToPresenterImpl();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        stationTo = toPresenter.getStationToInfo(context);
        StationToAdapter adapter = new StationToAdapter(stationTo, recyclerView.getContext());
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
        recyclerView.scrollToPosition(0);
        StationToAdapter adapter = new StationToAdapter(
                toPresenter.getFilteredStationList(newText, stationTo),
                recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        return true;
    }
    //set chosen city in main screen
    public void intentSourceCity(String station) {
        final Intent i = new Intent();
        i.putExtra("stationTo", station);
        setResult(2, i);
        finish();
    }
    //Information send to StationInfo and displayed
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
