package com.realcoderz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "job_profile")
@Data
public class JobProfile {
	@Id
	@GenericGenerator(name = "job_profile_seq",strategy = "sequence")
	@GeneratedValue(generator = "job_profile_seq")
	@Column(name = "profile_id")
	private Integer profileId;
	private Integer interviwerNumber;
	private String profile;
	private String category;
	private String recuterName;
private Integer complete;
}