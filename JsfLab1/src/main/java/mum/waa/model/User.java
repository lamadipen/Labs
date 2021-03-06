package mum.waa.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("user")
@SessionScoped
public class User implements Serializable{
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getGreeting()
	{
		return "ajax output "+username +" "+password;
	}
	
	public String authenticate(String param)
	{
		System.out.println("eg of EL method expression " +param);
		return "eg of EL method expression " +param;
	}
	
	@PostConstruct
	public void initilize()
	{
		System.out.println("Initilize code");
	}
	
	@PreDestroy
	public void cleanUp()
	{
		System.out.println("clean up");
	}
	
	
	public String dynamicNavigation()
	{
		
		return "dynamic_nav";
	}
	
	
}
