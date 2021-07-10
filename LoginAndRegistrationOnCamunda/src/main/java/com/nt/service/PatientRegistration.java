package com.nt.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("reg")
public class PatientRegistration implements JavaDelegate {
	private static final String Insert_Query="Insert into corona_registration (pname , paddr ,page , pmobile) values (?,?,?,?)";
	@Autowired
	private DataSource ds;
  public void execute(DelegateExecution execution) throws Exception {
	  Connection con=ds.getConnection();
	  PreparedStatement pst=con.prepareStatement(Insert_Query);

	  String name=((String)execution.getVariable("name"));
	  String addr=((String)execution.getVariable("addr"));
	  String age=((String)execution.getVariable("age"));
	  String mobile=((String)execution.getVariable("mobile"));
	  pst.setString(1, name);
	  pst.setString(2, addr);
	  pst.setString(3, age);
	  pst.setString(4, mobile);
	  
	  int count=pst.executeUpdate();
	  String result=count!=0?"registration Success":"registration failue";
	  execution.setVariable("result",result);
	  
	  System.out.println(result);
  }

}
