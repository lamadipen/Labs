/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 *
 * @author dipen
 */
public class CountryListener implements ValueChangeListener{

    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
        FacesContext context= FacesContext.getCurrentInstance();
        if("US".equals(event.getNewValue()))
        {
            context.getViewRoot().setLocale(Locale.US);
        }
        else
            context.getViewRoot().setLocale(Locale.CANADA);
    }
    
}
