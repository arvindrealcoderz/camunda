package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Patient implements Serializable{
	private Integer regNo;
	private String pname;
	private String paddr;
	private String page;
	private String mobile;
	

}
