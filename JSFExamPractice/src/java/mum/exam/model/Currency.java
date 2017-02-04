/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.exam.model;

import java.io.Serializable;


public class Currency implements Serializable{
    private String symbol;
    private double value;

    public Currency(String symbol, double value) {
        this.symbol = symbol;
        this.value =  value;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}