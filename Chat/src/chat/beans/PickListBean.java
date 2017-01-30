package chat.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;
@ManagedBean(name="pickListBean")
@SessionScoped
public class PickListBean {
    private DualListModel<String> cities;
    
    public PickListBean() {
        List<String> citiesSource = new ArrayList<String>();
        List<String> citiesTarget = new ArrayList<String>();
        citiesSource.add("Sala1");
        citiesSource.add("Sala2");
        citiesSource.add("Sala3");
        citiesSource.add("Sala4");
        citiesSource.add("Sala5");
        this.cities = new DualListModel<String>(citiesSource, citiesTarget);
    }
    public DualListModel<String> getCities() {
        return cities;
    }
    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }
}