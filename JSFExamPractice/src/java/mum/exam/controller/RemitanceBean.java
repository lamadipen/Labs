/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.exam.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import mum.exam.model.Currency;

/**
 *
 * @author dipen
 */
@Named("rb")
@SessionScoped
public class RemitanceBean implements Serializable {

    private String country;
    private double howMuchMoney = 0.0;
    private double exchangeAmount = 0.0;
    private Currency currency;
    private Map<String, Currency> exchangeRates;

    public RemitanceBean() {
        exchangeRates = new HashMap<>();

        exchangeRates.put("NEPAL", new Currency("NPR", 104.98));
        exchangeRates.put("INDIA", new Currency("INR", 65.57));
        exchangeRates.put("MEXICO", new Currency("MXN", 16.96));
        exchangeRates.put("Phillippines", new Currency("PHP", 45.65));
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the howMuchMoney
     */
    public double getHowMuchMoney() {
        return howMuchMoney;
    }

    /**
     * @param howMuchMoney the howMuchMoney to set
     */
    public void setHowMuchMoney(double howMuchMoney) {
        this.howMuchMoney = howMuchMoney;
    }

    /**
     * @return the exchangeAmount
     */
    public double getExchangeAmount() {
        return exchangeAmount;
    }

    /**
     * @param exchangeAmount the exchangeAmount to set
     */
    public void setExchangeAmount(double exchangeAmount) {
        this.exchangeAmount = exchangeAmount;
    }

    /**
     * @return the currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * @return the exchangeRates
     */
    public Map<String, Currency> getExchangeRates() {
        return exchangeRates;
    }

    /**
     * @param exchangeRates the exchangeRates to set
     */
    public void setExchangeRates(Map<String, Currency> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public Currency getCurrencyValue(String country) {
        return exchangeRates.get(country);
    }

    public String showView() {
        return null;
    }

    public void calculateTotalAmount() {
        FacesContext context = FacesContext.getCurrentInstance();

        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        String countryName = (String) params.get("form:countryInput");

        howMuchMoney = Double.parseDouble(params.get("form:totalSendMoney"));

        Currency currencyObject = getCurrencyValue(countryName);
        setCurrency(currencyObject);

        setExchangeAmount(currencyObject.getValue() * howMuchMoney);
        System.out.println(exchangeAmount);

    }

    public void moneyValidator(FacesContext fc, UIComponent uc, Object value) {

        if ((Double.parseDouble(String.valueOf(value))) < 0) {
            throw new ValidatorException(new FacesMessage("Amount cannot be negative"));
        }
    }

}
