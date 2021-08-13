package com.realcoderz.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;



@Entity
@Table(name = "interviewer")
@Data
public class InterView {
	@Id
	@GenericGenerator(name = "interviewer_seq",strategy = "sequence")
	@GeneratedValue(generator = "interviewer_seq")
	@Column(name = "interviewerId")
	private Integer interviwerNumber;
	private String interviwerName;
	private String category;
	private String profile;
	private String interviwerEmail;
	private Date interviewDate;
	private Integer Experience;
	private Integer complete;
	//========================================================
	
	//private 
	//=============================================
}
