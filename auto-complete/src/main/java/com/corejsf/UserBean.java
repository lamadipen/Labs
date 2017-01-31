package com.corejsf;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserBean {
	@Inject
	UserRepo userRepo;

	@Inject
	User user;

	public User getUser() {
		return user;
	}
	
	// invoked first on Process Validations by value change listener
	// then overridden on Update Model
	public void setUser(User user) {
		this.user = user;
	}

	public void add() {
		userRepo.addUser(user);
	}
	
	// Fired in Process Validations Phase
	public void findLastName(ValueChangeEvent e){
		List<User> userList = userRepo.getUserList();
		for(int i=0; i<userList.size();i++){
			if(userList.get(i).getFirstName().equals(e.getNewValue())){
				user.setLastName(userList.get(i).getLastName());
			}
		}
	}
        
        
        // Fired in Process Validations Phase
	public void findLastNameAction(ActionEvent e){
               System.out.println("This is dipen testing "+getUser().getFirstName());
		List<User> userList = userRepo.getUserList();
		for(int i=0; i<userList.size();i++){
			if(userList.get(i).getFirstName().equals(getUser().getFirstName())){
				user.setLastName(userList.get(i).getLastName());
			}
		}     
	}
        
        public void findLastNameTest(ActionEvent e){
		FacesContext fc = FacesContext.getCurrentInstance();
		String clientId = e.getComponent().getClientId(fc);
		
		Map<String,String> requestParams = fc.getExternalContext().getRequestParameterMap();
		          System.out.println("Before" + clientId+":di");
                String tmpName = requestParams.get("form"+":di");
                System.out.println("Dipen"+clientId+" -tempName"+tmpName+" "+requestParams.toString());
                          
		List<User> userList = userRepo.getUserList();
		for(int i=0; i<userList.size();i++){
			if(userList.get(i).getFirstName().equals(tmpName)){
				System.out.println(userList.get(i).getLastName());
				user.setLastName(userList.get(i).getLastName());
			}
		}
	}
        
        public String showView()
        {
            return null;
        }
}
