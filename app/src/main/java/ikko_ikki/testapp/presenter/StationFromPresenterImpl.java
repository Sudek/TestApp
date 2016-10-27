package ikko_ikki.testapp.presenter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ikko_ikki.testapp.data.StationFrom;
import ikko_ikki.testapp.model.StationFromModelImpl;

public class StationFromPresenterImpl implements StationFromPresenter {

    private StationFromModelImpl stationFromModel = new StationFromModelImpl();

    public List<StationFrom> getStationFromInfo(Context context) {
        return stationFromModel.initStationFrom(context);
    }

    @Override
    public ArrayList<StationFrom> getFilteredStationList(String userRequest, List<StationFrom> stationFrom) {
        ArrayList<StationFrom> stationList = new ArrayList<>();
        String lowerCaseQuery = userRequest.toLowerCase();
        for (int i  = 0; i < stationFrom.size(); i++) {
            String city = stationFrom.get(i).getStationTitle().toLowerCase();
            if(city.contains(lowerCaseQuery)) {
                stationList.add(stationFrom.get(i));
            }
        }
        return stationList;
    }
}
