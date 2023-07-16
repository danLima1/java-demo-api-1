package net.dn.java.demoapi1.mensagens;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Mensagens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long mensId; 

	@Column(length = 255)
	private Long mensUserIdContato;

	@Column(length = 255)
	private Long mensUserIdPrimary;

	@Column(length = 500)
	private String mensMensagem;

	@Column(length = 5)
	private String mensStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private String mensData;

	public Long getMensId() {
		return mensId;
	}

	public void setMensId(Long mensId) {
		this.mensId = mensId;
	}

	public Long getMensUserIdContato() {
		return mensUserIdContato;
	}

	public void setMensUserIdContato(Long mensUserIdContato) {
		this.mensUserIdContato = mensUserIdContato;
	}

	public Long getMensUserIdPrimary() {
		return mensUserIdPrimary;
	}

	public void setMensUserIdPrimary(Long mensUserIdPrimary) {
		this.mensUserIdPrimary = mensUserIdPrimary;
	}

	public String getMensMensagem() {
		return mensMensagem;
	}

	public void setMensMensagem(String mensMensagem) {
		this.mensMensagem = mensMensagem;
	}

	public String getMensStatus() {
		return mensStatus;
	}

	public void setMensStatus(String mensStatus) {
		this.mensStatus = mensStatus;
	}

	public String getMensData() {
		return mensData;
	}

	public void setMensData(String mensData) {
		this.mensData = mensData;
	}
}
