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
import ikko_ikki.testapp.data.StationFrom;
import ikko_ikki.testapp.view.StationFromActivity;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.PersonViewHolder> {

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

    private List<StationFrom> stations;
    private Context context;

    public StationAdapter(List<StationFrom> stationFrom, Context context){
        this.stations = stationFrom;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.activity_station, viewGroup, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        String station = stations.get(i).getStationTitle();
        String country = stations.get(i).getCountryTitle();
        String region = stations.get(i).getRegionTitle();
        String city = stations.get(i).getCityTitle();
        String district = stations.get(i).getDistrictTitle();
        personViewHolder.stationCity.setText(station);
        personViewHolder.stationCountry.setText(country);

        personViewHolder.imageButtonAdd.setOnClickListener(view ->
                ((StationFromActivity) context).intentSourceCity(station));
        personViewHolder.imageButtonInfo.setOnClickListener(view ->
                ((StationFromActivity) context).intentInfoStation(station, country, region, city, district));
    }

    @Override
    public int getItemCount() {return stations.size();}
}