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
  static int count=0;
  String choice="";
  public void execute(DelegateExecution execution) throws Exception {
	  	String name =(String) execution.getVariable("name");
	    String email =(String) execution.getVariable("email");

	    String it =(String) execution.getVariable("it");
	    String hr =(String) execution.getVariable("hr");
	    String finance =(String) execution.getVariable("finance");
	    String jp =(String) execution.getVariable("jp");

	    
	    
	    String fr =(String) execution.getVariable("fr");
	    String sr =(String) execution.getVariable("sr");
	    String tr =(String) execution.getVariable("tr");
	    String fo =(String) execution.getVariable("fo");
	    String ft =(String) execution.getVariable("ft");
	    
	    if((fr.length()!=0 && fr!=null))
	    	if(fr.equalsIgnoreCase("mcq")|| fr.equalsIgnoreCase("gd") || fr.equalsIgnoreCase("ti") || fr.equalsIgnoreCase("mcr")|| fr.equalsIgnoreCase("hr")) {
	    		count++;
	    		choice=choice+" "+fr;  
	    	}
	    	else
	    		System.out.println("First Round Selection "+fr);
	    
	     if((sr.length()!=0 && sr!=null))
	    	if(sr.equalsIgnoreCase("mcq")|| sr.equalsIgnoreCase("gd") || sr.equalsIgnoreCase("ti") || sr.equalsIgnoreCase("mcr")|| sr.equalsIgnoreCase("hr")) {
	    		count++;
	    		choice=choice+" "+sr;  
	    	} 
	    	else
	    		System.out.println("Secound Round Selection "+sr);
	    
	    if((tr.length()!=0 && tr!=null))
	    	if(tr.equalsIgnoreCase("mcq")|| tr.equalsIgnoreCase("gd") || tr.equalsIgnoreCase("ti") || tr.equalsIgnoreCase("mcr")|| tr.equalsIgnoreCase("hr")) {
	    		count++;
	    		choice=choice+" "+tr;  
	    	}
	    	else
	    		System.out.println("Thired Round Selection "+tr);
	    
	    if((fo.length()!=0 && fo!=null))
	    	if(fo.equalsIgnoreCase("mcq")|| fo.equalsIgnoreCase("gd") || fo.equalsIgnoreCase("ti") || fo.equalsIgnoreCase("mcr")|| fo.equalsIgnoreCase("hr")) {
	    		count++;
	    		choice=choice+" "+fo;  	
	    	}
	    	else
	    		System.out.println("Fourth Round Selection "+fo);
	    if((ft.length()!=0 && ft!=null))
	    	if(ft.equalsIgnoreCase("mcq")|| ft.equalsIgnoreCase("gd") || ft.equalsIgnoreCase("ti") || ft.equalsIgnoreCase("mcr")|| ft.equalsIgnoreCase("hr")) {
	    		count++;
	    		choice=choice+" "+ft;  	
	    	}
	    	else
	    		System.out.println("Fith Round Selection "+ft);
	    else
	    	System.out.println("-------------Result");
	    
	    if(count<=2)
		    execution.setVariable("result",3);
	    else
	    	execution.setVariable("result",count);
	    
	    System.out.println("============choice========="+choice);
	    
	    execution.setVariable("choice",choice);
	    count=0;
	    
	    /*
	    execution.setVariable("fr",fr);
	    execution.setVariable("sr",sr);
	    execution.setVariable("tr",tr);
	    execution.setVariable("fo",fo);
	    execution.setVariable("ft",ft);
	    
	    */
		/*
		 * if(mcq==true && tr==true && hr==true) { if(ceo==true)
		 * execution.setVariable("result",4); else if(gd==true && coding==true )
		 * execution.setVariable("result",5); else execution.setVariable("result",3); }
		 * 
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
