package mum.waa.model;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class QuizBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int currentIndex=0;
	
	
	@Inject Conversation converstion;
	
	public void setAnswer(String newValue)
	{
		if(currentIndex==0)converstion.begin();
		int answer = Integer.parseInt(newValue.trim());
		
		
	}
	
	
}
