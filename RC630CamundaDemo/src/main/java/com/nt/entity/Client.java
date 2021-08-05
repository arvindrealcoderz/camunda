package com.nt.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.camunda.bpm.engine.impl.test.RequiredDatabase;

import lombok.Data;

@Data
@Entity

@Table(name = "Client_Table")
public class Client {

	@Id 
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "clientId")
	private Integer id;
	private String percentage;
	private String day;
	private String profile;
	private String password;
	private String experience;
	private String  interviewerName;
	@OneToOne(cascade = CascadeType.ALL)
	private InterView view;
	
}
