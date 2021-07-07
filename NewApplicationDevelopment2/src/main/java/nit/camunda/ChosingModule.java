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
	    String profile =(String) execution.getVariable("profile");
	    String type =(String) execution.getVariable("type");
	    String mcq =(String) execution.getVariable("mcq");
	    String cr =(String) execution.getVariable("cr");
	    String mt =(String) execution.getVariable("mt");
	    String hr =(String) execution.getVariable("hr");
		System.out.println(mcq+"\tcr :"+cr+"\t mt"+mt+"\t hr"+hr);
	    
		System.out.println("name :: "+name+"\nemail :: "+email+"\nprofile :: "+profile+"\ntype"+type);
	    execution.setVariable("result", 5);
	    
		/*
		 * if(name.equalsIgnoreCase("arvind verma") ) message+="success "; else
		 * message+="failure "; execution.setVariable("result",message);
		 */
	   
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
