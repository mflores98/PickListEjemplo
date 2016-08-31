/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Owner
 */
@ManagedBean
@RequestScoped
public class PickListView {

//    @ManagedProperty("#{themeService}")
//    private ThemeService service;
//    private DualListModel<Theme> themes;

    private DualListModel<String> cities;

    @PostConstruct
    public void init() {
        //Cities
        List<String> citiesSource = new ArrayList<>();
        List<String> citiesTarget = new ArrayList<>();

        citiesSource.add("San Francisco");
        citiesSource.add("London");
        citiesSource.add("Paris");
        citiesSource.add("Istanbul");
        citiesSource.add("Berlin");
        citiesSource.add("Barcelona");
        citiesSource.add("Rome");

        cities = new DualListModel<>(citiesSource, citiesTarget);

//        Themes
//        List<Theme> themesSource = service.getThemes().subList(0, 5);
//        List<Theme> themesTarget = new ArrayList<Theme>();
//
//        themes = new DualListModel<Theme>(themesSource, themesTarget);

    }

    public DualListModel<String> getCities() {
        return cities;
    }

    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }

//    public ThemeService getService() {
//        return service;
//    }
//
//    public void setService(ThemeService service) {
//        this.service = service;
//    }
//
//    public DualListModel<Theme> getThemes() {
//        return themes;
//    }
//
//    public void setThemes(DualListModel<Theme> themes) {
//        this.themes = themes;
//    }
//
//    public void onTransfer(TransferEvent event) {
//        StringBuilder builder = new StringBuilder();
//        for (Object item : event.getItems()) {
//            builder.append(((Theme) item).getName()).append("<br />");
//        }
//
//        FacesMessage msg = new FacesMessage();
//        msg.setSeverity(FacesMessage.SEVERITY_INFO);
//        msg.setSummary("Items Transferred");
//        msg.setDetail(builder.toString());
//
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }

    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }

    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }

    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    }
}
