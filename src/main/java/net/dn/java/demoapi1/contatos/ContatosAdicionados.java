package net.dn.java.demoapi1.contatos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContatosAdicionados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long contId;

	@Column(length = 255)
	private Long contUserIdPrimary;
	
	@Column(length = 255) 
	private Long contUserIdContato;

	public Long getContId() {
		return contId;
	}

	public void setContId(Long contId) {
		this.contId = contId;
	}

	public Long getContUserIdPrimary() {
		return contUserIdPrimary;
	}

	public void setContUserIdPrimary(Long contUserIdPrimary) {
		this.contUserIdPrimary = contUserIdPrimary;
	}

	public Long getContUserIdContato() {
		return contUserIdContato;
	}

	public void setContUserIdContato(Long contUserIdContato) {
		this.contUserIdContato = contUserIdContato;
	}
}
