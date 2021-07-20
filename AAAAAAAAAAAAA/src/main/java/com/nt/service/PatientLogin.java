package com.nt.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("login")
public class PatientLogin implements JavaDelegate {
	private static final String Insert_Query="select count(*) as count from corona_registration where pname=? and pmobile=?";
	@Autowired
	private DataSource ds;
  public void execute(DelegateExecution execution) throws Exception {
	  Connection con=ds.getConnection();
	  PreparedStatement pst=con.prepareStatement(Insert_Query);

	  String name=((String)execution.getVariable("name"));
	  String mobile=((String)execution.getVariable("mobile"));
	  pst.setString(1, name);
	  pst.setString(2, mobile);
	  
	  ResultSet rs=pst.executeQuery();
	  String result=null;
	  long count=0;
	  if(rs!=null)
		  if(rs.next())
			  count= rs.getInt(1);
	  
	  execution.setVariable("logresult",count);
	  
	  
	  System.out.println(count);
  }

}
