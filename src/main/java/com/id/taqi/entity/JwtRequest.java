package com.id.taqi.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtRequest implements Serializable{

	private static final long serialVersionUID = 3952815549793778104L;
	private String username;
	private String password;
	
	public JwtRequest() {
		
	}
	
	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
}
