/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.exam.reopsitory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dipen
 */
public class UserRepository {
    
    static List<String> countires;
    
    static {
        countires = new ArrayList<>();
        countires.add("Nepal");
        countires.add("China");
    }
    
    public List<String> getCountires() {
        return countires;
    }
    
}
