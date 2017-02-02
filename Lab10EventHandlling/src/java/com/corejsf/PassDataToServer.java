/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author dipen
 */
@Named("PData")
@SessionScoped
public class PassDataToServer implements Serializable{
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String languageCodeDirect;
    
    private static final Locale[] countries = {Locale.CANADA,Locale.US};
    public Locale[] getCountries() { return countries; }
    
    public void setStreetAddress(String newValue) {
        streetAddress = newValue;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setCity(String newValue) {
        city = newValue;
    }

    public String getCity() {
        return city;
    }

    public void setState(String newValue) {
        state = newValue;
    }

    public String getState() {
        return state;
    }

    public void setCountry(String newValue) {
        country = newValue;
    }

    public String getCountry() {
        return country;
    }
    
    public String changeLocale(String languageChange) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(new Locale(languageChange));
        System.err.println("Method parameter test: "+languageChange);
        return null;
    }
    
     public String changeLocaleParam() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String languageChange = params.get("languageCode");
        
        context.getViewRoot().setLocale(new Locale(languageChange));
        System.err.println("parameter test: "+languageChange);
        return null;
    }
     
     public void changeLocaleAttribure(ActionEvent event) {
        UIComponent component = event.getComponent();
        Map<String, Object> attrs = component.getAttributes();
        String languageCode = (String) attrs.get("languageCode");
        System.err.println("Attribute test: "+languageCode);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(languageCode));
    }
     

    public String test()
    {
        System.err.println("Attribute test: "+languageCodeDirect);
        return languageCodeDirect;
    }

    /**
     * @return the languageCodeDirect
     */
    public String getLanguageCodeDirect() {
        return languageCodeDirect;
    }

    /**
     * @param languageCodeDirect the languageCodeDirect to set
     */
    public void setLanguageCodeDirect(String languageCodeDirect) {
        this.languageCodeDirect = languageCodeDirect;
    }
    

}
