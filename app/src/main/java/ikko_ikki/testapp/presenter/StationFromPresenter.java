package ikko_ikki.testapp.presenter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ikko_ikki.testapp.data.StationFrom;

public interface StationFromPresenter {

    List<StationFrom> getStationFromInfo(Context context);
    ArrayList<StationFrom> getFilteredStationList(String userRequest, List<StationFrom> stationFrom);
}
