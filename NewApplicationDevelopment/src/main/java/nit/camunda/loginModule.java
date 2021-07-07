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
@Component("logger1")
public class loginModule implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(loginModule.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {

	  System.out.println("loginModule.execute(1111111)");	
	  String name =(String) execution.getVariable("name");
	  String password =(String) execution.getVariable("password");
	  
	  System.out.println(name+"\t"+password);
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
