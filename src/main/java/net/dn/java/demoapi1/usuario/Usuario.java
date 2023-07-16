package net.dn.java.demoapi1.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long userId;

	@Column(length = 255)
	private String userNome;

	@Column(length = 255)
	private String userEmail; 

	@Column(length = 255)
	private String userIdFirebase;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserNome() {
		return userNome;
	}

	public void setUserNome(String userNome) {
		this.userNome = userNome;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserIdFirebase() {
		return userIdFirebase;
	}

	public void setUserIdFirebase(String userIdFirebase) {
		this.userIdFirebase = userIdFirebase;
	}
}
