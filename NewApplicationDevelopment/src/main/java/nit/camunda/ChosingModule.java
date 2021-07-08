package nit.camunda;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
@Component("logger")
public class ChosingModule implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(ChosingModule.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
	  	String name =(String) execution.getVariable("name");
	    String email =(String) execution.getVariable("email");
	   
	    String jp =(String) execution.getVariable("jp");
	    String it =(String) execution.getVariable("it");
	    String finance =(String) execution.getVariable("finance");
	    
	    Boolean mcq =(Boolean) execution.getVariable("mcq");
	    Boolean gd =(Boolean) execution.getVariable("gd");
	    Boolean ceo =(Boolean) execution.getVariable("ceo");
	    Boolean coding =(Boolean) execution.getVariable("coding");
	    Boolean tr =(Boolean) execution.getVariable("tr");
	    Boolean hr =(Boolean) execution.getVariable("hr");
	    int count=0;
	    
	    if(mcq==true && tr==true && hr==true) {
	    	if(ceo==true)
	    		execution.setVariable("result",4);
	    	else if(gd==true && coding==true )
	    		execution.setVariable("result",5);
	    	else
	    		execution.setVariable("result",3);
	    }
	    	
	    
	   LOGGER.info("\n\n  ... LoggerDelegate invoked by "
            + "activtyName='" + execution.getCurrentActivityName() + "'"
            + ", activtyId=" + execution.getCurrentActivityId()
            + ", processDefinitionId=" + execution.getProcessDefinitionId()
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + ", variables=" + execution.getVariables()
            + " \n\n");
    
  }

}
