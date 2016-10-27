package ikko_ikki.testapp.presenter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ikko_ikki.testapp.data.StationTo;
import ikko_ikki.testapp.model.StationToModelImp;

public class StationToPresenterImpl implements StationToPresenter{

    private StationToModelImp stationToModel = new StationToModelImp();

    @Override
    public List<StationTo> getStationToInfo(Context context) {
        return stationToModel.initStationTo(context);
    }

    @Override
    public ArrayList<StationTo> getFilteredStationList(String userRequest, List<StationTo> stationTo) {
        final ArrayList<StationTo> stationList = new ArrayList<>();
        final String lowerCaseQuery = userRequest.toLowerCase();
        for (int i = 0; i < stationTo.size(); i++) {
            String city = stationTo.get(i).getStationTitle().toLowerCase();
            if (city.contains(lowerCaseQuery)) {
                stationList.add(stationTo.get(i));
            }
        }
        return stationList;
    }
}
