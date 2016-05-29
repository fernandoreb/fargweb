package br.fargweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Propriedade {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Componente componente; 
	
	private String nome;
	private String label;
	private String valor;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Componente getComponente() {
		return componente;
	}
	public void setComponente(Componente componente) {
		this.componente = componente;
	}
	
}
