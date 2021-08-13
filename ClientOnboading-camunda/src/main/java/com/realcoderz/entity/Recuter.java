package com.realcoderz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity
@Table(name = "recruiter")
@Data
public class Recuter {
	
	@Id
	@GenericGenerator(name = "recruiter_seq",strategy = "sequence")
	@GeneratedValue(generator = "recruiter_seq")
	@Column(name = "recruiter_id")
	private Integer recuterId;
	private String recuterName;
	private String recutercategory;
	private String recruiterEmail;
	

}
