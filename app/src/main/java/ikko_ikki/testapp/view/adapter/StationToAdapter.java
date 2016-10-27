package ikko_ikki.testapp.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ikko_ikki.testapp.R;
import ikko_ikki.testapp.data.StationTo;
import ikko_ikki.testapp.view.StationToActivity;

public class StationToAdapter extends RecyclerView.Adapter<StationToAdapter.PersonViewHolder> {

    static class PersonViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.station_city) TextView stationCity;
        @BindView(R.id.station_country) TextView stationCountry;
        @BindView(R.id.btn_info) ImageButton imageButtonInfo;
        @BindView(R.id.btn_bus) ImageButton imageButtonAdd;

        PersonViewHolder(View itemView) {
            super(itemView);
            CardView cardView = (CardView) itemView.findViewById(R.id.recycler_view);
            ButterKnife.bind(this, itemView);
        }
    }

    private List<StationTo> stations;
    private Context context;

    public StationToAdapter(List<StationTo> stationTo, Context context){
        this.stations = stationTo;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public StationToAdapter.PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.activity_station, viewGroup, false);
        return new StationToAdapter.PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StationToAdapter.PersonViewHolder personViewHolder, int i) {
        String station = stations.get(i).getStationTitle();
        String country = stations.get(i).getCountryTitle();
        String region = stations.get(i).getRegionTitle();
        String city = stations.get(i).getCityTitle();
        String district = stations.get(i).getDistrictTitle();
        personViewHolder.stationCity.setText(station);
        personViewHolder.stationCountry.setText(country);

        personViewHolder.imageButtonAdd.setOnClickListener(view ->
                ((StationToActivity) context).intentSourceCity(station));
        personViewHolder.imageButtonInfo.setOnClickListener(view ->
                ((StationToActivity) context).intentInfoStation(station, country, region, city, district));
    }

    @Override
    public int getItemCount() {return stations.size();}
}
