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
public class LoggerDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
	  	String message="Login ";
	    String name =(String) execution.getVariable("name");
	    String email =(String) execution.getVariable("email");
	    String profile =(String) execution.getVariable("profile");
	    String type =(String) execution.getVariable("type");
		
	    System.out.println("name :: "+name+"\nemail :: "+email+"\nprofile :: "+profile+"\ntype"+type);
	    
	    if(name.equalsIgnoreCase("arvind verma")  )
	    	message+="success ";
	    else
	    	message+="failure ";
	   execution.setVariable("result",message);
	   
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
