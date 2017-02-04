/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.exam.controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ValidationException;
import mum.exam.model.User;
import mum.exam.service.UserService;

/**
 *
 * @author dipen
 */
@Named("userBean")
@SessionScoped
public class UserBean implements Serializable{
    @Inject
    private User user;
    @Inject
    private UserService userService;
    List<String> countires;
    private boolean islogedIn = false;
    
    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
    public String login()
    {
        System.out.println("This is testing: "+user.getUsername()+" Password: "+user.getPassword());
        islogedIn =true;
        return "welcome";
    }
    
    public void customValidator(FacesContext fc, UIComponent c, Object value)
    {
        if((value.toString()).contains("@"))
        {
           //throw new ValidationException("Cannot contaion @");

        }
    }
    
    
    /**
     * @return the countires
     */
    public List<String> getCountires() {
        return userService.getCountires();
    }
    
    public String isLogin()
    {
        if(islogedIn==false)
        {
            return "index?faces-redirect=true";
        }
        return "index";
    }

}
