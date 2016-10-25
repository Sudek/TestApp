package ikko_ikki.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StationInfoActivity extends AppCompatActivity {

    @BindView(R.id.txt_station_name) TextView stationName;
    @BindView(R.id.txt_country_name) TextView countryName;
    @BindView(R.id.txt_region_name) TextView regionName;
    @BindView(R.id.txt_city_name) TextView cityName;
    @BindView(R.id.txt_district_name) TextView districtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_station);
        ButterKnife.bind(this);
        Intent i = getIntent();
        stationName.setText(i.getStringExtra("station"));
        countryName.setText(i.getStringExtra("country"));
        regionName.setText(i.getStringExtra("region"));
        cityName.setText(i.getStringExtra("city"));
        districtName.setText(i.getStringExtra("district"));
    }
}
