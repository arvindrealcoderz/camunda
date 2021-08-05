
package com.nt;

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
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;

public class TaskAssignmentListener implements TaskListener,ExecutionListener {

	private static final String HOST = "smtp.gmail.com";
	private static final String USER = "arvind7238realcoderz@gmail.com";
	private static final String PWD = "Realcoderz7238@";
	private final static Logger LOGGER = Logger.getLogger(TaskAssignmentListener.class.getName());

	@Override
	public void notify(DelegateTask delegateTask) {

		System.out.println("inside listener");
		String assignee = delegateTask.getAssignee();
		String taskId = delegateTask.getId();
		System.out.println("=============="+assignee+"================="+taskId);
		if (assignee != null) {
			IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
			User user = identityService.createUserQuery().userId(assignee).singleResult();
			System.out.println(user+"------------------------");
			//if (user != null) {
			//String recipient = user.getEmail();
			System.out.println("user========"+user);
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.debug", "true");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(USER,PWD);
				}
			});


			try {

				Transport transport = session.getTransport();
				InternetAddress addressFrom = new InternetAddress(USER);

				MimeMessage message = new MimeMessage(session);
				message.setSender(addressFrom);
				message.setSubject("Task assigned: " + delegateTask.getName());
				message.setContent("Please complete: http://localhost:8083/forms/Requirement.html?taskId=" + taskId+ "&callbackUrl=http://localhost:8083/camunda/app/tasklist/default/#/","text/plain");
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(assignee));
				transport.connect();
				Transport.send(message);
				transport.close();
				LOGGER.info("Task Assignment Email successfully sent to user '" + assignee + "' with address '" + assignee + "'.");

			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Could not send email to assignee", e);
			}
			//} else {
			//	LOGGER.warning("Not sending email to user " + assignee + "', user has no email address.");
			//}
		} else {
			LOGGER.warning("Not sending email to user " + assignee + "', user is not enrolled with identity service.");
		}
	}

	@Override
	public void notify(DelegateExecution execution) throws Exception {System.out.println("TaskAssignmentListener.notify()");
		
	}


}
