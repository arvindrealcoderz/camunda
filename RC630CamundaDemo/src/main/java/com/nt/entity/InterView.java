package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity

@Table(name = "Client_Interview")
public class InterView {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer regInterview;
	private String interviewhanges;
	private Integer firstInterviewRound;
	private Integer interviewNo;
	private String  firstInterviewerName;
	private String   no_of_interviewers;
	private String firstInterviewDate;
	private Integer secoundInterviewRound;
	private String secoundInterviewDate;
	private String  secoundInterviewerName;
	private String nameOfTheInterviewer;
}
