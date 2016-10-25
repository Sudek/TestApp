package ikko_ikki.testapp.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CitiesFrom {

    @SerializedName("countryTitle")
    @Expose
    private String countryTitle;
    @SerializedName("districtTitle")
    @Expose
    private String districtTitle;
    @SerializedName("cityId")
    @Expose
    private Integer cityId;
    @SerializedName("cityTitle")
    @Expose
    private String cityTitle;
    @SerializedName("regionTitle")
    @Expose
    private String regionTitle;
    @SerializedName("stations")
    @Expose
    private List<StationFrom> stations = new ArrayList<StationFrom>();

    /**
     * 
     * @return
     *     The countryTitle
     */
    public String getCountryTitle() {
        return countryTitle;
    }

    /**
     * 
     * @param countryTitle
     *     The countryTitle
     */
    public void setCountryTitle(String countryTitle) {
        this.countryTitle = countryTitle;
    }

    /**
     * 
     * @return
     *     The districtTitle
     */
    public String getDistrictTitle() {
        return districtTitle;
    }

    /**
     * 
     * @param districtTitle
     *     The districtTitle
     */
    public void setDistrictTitle(String districtTitle) {
        this.districtTitle = districtTitle;
    }

    /**
     * 
     * @return
     *     The cityId
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 
     * @param cityId
     *     The cityId
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 
     * @return
     *     The cityTitle
     */
    public String getCityTitle() {
        return cityTitle;
    }

    /**
     * 
     * @param cityTitle
     *     The cityTitle
     */
    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    /**
     * 
     * @return
     *     The regionTitle
     */
    public String getRegionTitle() {
        return regionTitle;
    }

    /**
     * 
     * @param regionTitle
     *     The regionTitle
     */
    public void setRegionTitle(String regionTitle) {
        this.regionTitle = regionTitle;
    }

    /**
     * 
     * @return
     *     The stations
     */
    public List<StationFrom> getStations() {
        return stations;
    }

    /**
     * 
     * @param stations
     *     The stations
     */
    public void setStations(List<StationFrom> stations) {
        this.stations = stations;
    }

}
