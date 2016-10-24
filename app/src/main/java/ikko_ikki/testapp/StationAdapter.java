package ikko_ikki.testapp;

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

class StationAdapter extends RecyclerView.Adapter<StationAdapter.PersonViewHolder> {

    static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        @BindView(R.id.station_city) TextView stationCity;
        @BindView(R.id.station_country) TextView stationCountry;
        @BindView(R.id.btn_info) ImageButton imageButtonInfo;
        @BindView(R.id.btn_bus) ImageButton imageButtonAdd;
//        @BindView(R.id.editTextFrom) EditText ed;

        PersonViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.recycler_view);
            ButterKnife.bind(this, itemView);
        }
    }

    private List<Station> stations;
    private Context context;

    StationAdapter(List<Station> persons, Context context){
        this.stations = persons;
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
        personViewHolder.stationCity.setText(stations.get(i).getCity());
        personViewHolder.stationCountry.setText(stations.get(i).getCountry());

        personViewHolder.imageButtonAdd.setOnClickListener(view ->
                ((StationActivity) context).intentSourceCity(stations.get(i).getCity()));
    }

    @Override
    public int getItemCount() { return stations.size(); }

}