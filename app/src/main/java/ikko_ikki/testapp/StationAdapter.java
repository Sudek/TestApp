package ikko_ikki.testapp;

import android.content.Context;
import android.content.Intent;
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
import ikko_ikki.testapp.utils.CitiesFrom;

class StationAdapter extends RecyclerView.Adapter<StationAdapter.PersonViewHolder> {

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

    private List<CitiesFrom> stations;
    private Context context;

    StationAdapter(List<CitiesFrom> citiesFrom, Context context){
        this.stations = citiesFrom;
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
        personViewHolder.stationCity.setText(stations.get(i).getCityTitle());
        personViewHolder.stationCountry.setText(stations.get(i).getCountryTitle());

        personViewHolder.imageButtonAdd.setOnClickListener(view ->
                ((StationActivity) context).intentSourceCity(stations.get(i).getCityTitle()));
        personViewHolder.imageButtonInfo.setOnClickListener(view ->
                context.startActivity(new Intent(context, StationInfoActivity.class)));
    }

    @Override
    public int getItemCount() { return stations.size(); }

}