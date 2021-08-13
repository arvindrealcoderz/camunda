package com.realcoderz.mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.impl.context.Context;

	public class InterviewPaneTaskAndExecution implements ExecutionListener ,TaskListener{
		@Override
		public void notify(DelegateExecution execution) throws Exception {
			String email= (String)execution.getVariable("recruiteremail");
			execution.setVariable("recruiteremail", email);
		}

		@Override
		public void notify(DelegateTask delegateTask) {
			String email= (String) delegateTask.getVariable("recruiteremail");
			if(email!=null) {
			//	SendMail.sendEmail(delegateTask,email,"interview");
			}
			else 
				System.out.println("email not found "+email);
			
		}
		
		

}
