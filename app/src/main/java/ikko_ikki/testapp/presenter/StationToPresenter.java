package ikko_ikki.testapp.presenter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ikko_ikki.testapp.data.StationTo;

public interface StationToPresenter {
    List<StationTo> getStationToInfo(Context context);
    ArrayList<StationTo> getFilteredStationList(String userRequest, List<StationTo> stationTo);
}
