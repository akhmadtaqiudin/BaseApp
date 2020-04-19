package com.id.taqi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	@Size(min = 3, max = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	@Size(min = 3, max = 50)
	private String lastName;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	@Size(min = 10)
	private String address;
	
	@Email
	private String email;
}