package br.fargweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Componente {
	
	@Id
	@GeneratedValue
	private long id;
	private String descricao;
	
	private String observacoes;
	
	@OneToMany
	private List<Propriedade> propriedades;
	
	private long quantidade; 
	private long grupoId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Propriedade> getPropriedades() {
		return propriedades;
	}
	public void setPropriedades(List<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	public long getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(long grupoId) {
		this.grupoId = grupoId;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}
