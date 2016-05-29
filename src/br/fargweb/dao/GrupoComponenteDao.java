package br.fargweb.dao;

import java.util.List;

import br.fargweb.model.GrupoComponente;

public interface GrupoComponenteDao {

	public List<GrupoComponente> getLista();
	
	public void addGrupoComponente(GrupoComponente componente);
	
	public void remove(long id);
	
	public GrupoComponente busca(long id);
	
	public GrupoComponente altera(GrupoComponente componente);

	
}
