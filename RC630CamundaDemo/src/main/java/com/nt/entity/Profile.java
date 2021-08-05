package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Profile {
	@Id
	private Integer profileId;
	private String profileName;
	private String type;
	

}
