package ikko_ikki.testapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllCities {

    @SerializedName("citiesFrom")
    @Expose
    private List<CitiesFrom> citiesFrom = new ArrayList<CitiesFrom>();
    @SerializedName("citiesTo")
    @Expose
    private List<CitiesTo> citiesTo = new ArrayList<CitiesTo>();

    /**
     * 
     * @return
     *     The citiesFrom
     */
    public List<CitiesFrom> getCitiesFrom() {
        return citiesFrom;
    }

    /**
     * 
     * @param citiesFrom
     *     The citiesFrom
     */
    public void setCitiesFrom(List<CitiesFrom> citiesFrom) {
        this.citiesFrom = citiesFrom;
    }

    /**
     * 
     * @return
     *     The citiesTo
     */
    public List<CitiesTo> getCitiesTo() {
        return citiesTo;
    }

    /**
     * 
     * @param citiesTo
     *     The citiesTo
     */
    public void setCitiesTo(List<CitiesTo> citiesTo) {
        this.citiesTo = citiesTo;
    }

}
