package org.springframework.samples.exito.usuario;

import java.io.Serializable;

public class AuthClienteRequest implements Serializable {

	private String username;

	private String password;

	public AuthClienteRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public AuthClienteRequest() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
