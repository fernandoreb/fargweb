package br.fargweb.dao;

import java.util.List;

import br.fargweb.model.Componente;

public interface ComponenteDao {
	
	public List<Componente> getLista();
	
	public void addComponente(Componente componente);
	
	public void remove(long id);
	
	public Componente busca(long id);
	
	public List<Componente> buscaPorGrupo(long id);
	
	public Componente altera(Componente componente);
}
