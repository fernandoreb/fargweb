package br.fargweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GrupoComponente {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="descricao")
	private String decricao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDecricao() {
		return decricao;
	}
	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}
	
}
