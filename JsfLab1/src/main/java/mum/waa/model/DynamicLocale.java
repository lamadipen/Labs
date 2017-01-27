package mum.waa.model;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("dynalocal")
@SessionScoped
public class DynamicLocale implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String changeLocale(String code)
	{
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		viewRoot.setLocale(new Locale(code));
		return "index";
	}
	

}
