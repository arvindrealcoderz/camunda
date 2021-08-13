package com.realcoderz.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.core.annotation.Order;

import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class Client {
	
	@Id
	@GenericGenerator(name = "client_seq",strategy = "sequence" )
	@GeneratedValue(generator = "client_seq")
	@Column(name = "id")
	private Integer Id;
	
	
	@Column(name="name")
	@Order(3)
	private String Name;
	
	@Column(name="email")
	@Order(2)
	private String Email;
	
	@Column(name="licence")
	@Order(1)
	private String Licence;
	
	@Column(name="description")
	
	private String Description;
	
}