package com.realcoderz.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity
@Table(name = "recruiting_managers ")
@Data
public class RecuterManager {
	
	@Id
	@GenericGenerator(name = "recruiting_managers_seq",strategy = "sequence")
	@GeneratedValue(generator = "recruiting_managers_seq")
	@Column(name = "recruiting_manager_id")
	private Integer recuterManagerId;
	private Integer noOfInterview;
	private String experience;
	private String jobProfile;
	private String recruiterEmail;
	private String addProfile;
	//private SuperAdmin admin_id;
	private Integer adminId;
	
	
 
}
