package br.fargweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.fargweb.model.GrupoComponente;

@Repository
public class GrupoComponenteDaoMockImp implements GrupoComponenteDao {

	@Override
	public List<GrupoComponente> getLista() {
		List<GrupoComponente> componentes = new ArrayList<GrupoComponente>();
		GrupoComponente componente = null;
		
		for(int i = 0; i < 10; i++){
			componente = new GrupoComponente();
			componente.setId(i);
			componente.setDecricao("teste"+i);
			componentes.add(componente);
		}

		
		return componentes;
	}

	@Override
	public void addGrupoComponente(GrupoComponente componente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public GrupoComponente busca(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoComponente altera(GrupoComponente componente) {
		// TODO Auto-generated method stub
		return null;
	}

}
