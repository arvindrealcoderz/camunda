package nit.camunda;

import java.util.Iterator;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;
@Component("choice")
public class ChoiceSelectorOfTest {
	  private final Logger LOGGER = Logger.getLogger(ChosingModule.class.getName());
	 public void execute(DelegateExecution execution) throws Exception {
		// String fr=(String) execution.getVariable("fr");
		 String choice=(String) execution.getVariable("choice");
		 
		 char ch = 0;
		 int pt = 0;
		 String s = null;
			for(int i=0;i<choice.length();i++)
			{
				if(ch==' ')
					pt=choice.indexOf(' ',i);
				 s=s.substring(i+1, pt+1);
				
			}
			
			execution.setVariable("f1",s);
			choice=choice.substring(pt);
		  
	  }
}
