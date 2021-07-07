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
public class ChosingModuleDeligate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(ChosingModuleDeligate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {

	  System.out.println("ChosingModuleDeligate.execute(1111111)");	
	  long no_of_module = (long) execution.getVariable("no");
	   System.out.println("Module \t:: "+no_of_module);
	  execution.setVariable("result", no_of_module);
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
