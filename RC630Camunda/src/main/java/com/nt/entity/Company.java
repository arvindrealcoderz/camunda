package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Company {
	@Id
	private Integer companyId;
	private String companyName;
	private String companyCid;
	private String state;
	private String pinCode;
	private String country;
	private String address;
	private String email;
	private Long mobile;
	private String password;
	private String category;
	private String subCategory;
	private String companyClass;

}
