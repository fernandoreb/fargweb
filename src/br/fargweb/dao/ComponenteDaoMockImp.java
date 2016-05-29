package br.fargweb.dao;

import java.util.ArrayList;
import java.util.List;

import br.fargweb.model.Componente;

public class ComponenteDaoMockImp implements ComponenteDao {

	@Override
	public List<Componente> getLista() {
		// TODO Auto-generated method stub
		
		List<Componente> componentes = new ArrayList<Componente>();
		Componente componente = null;
		
		for(int i = 0; i < 10; i++){
			componente = new Componente();
			componente.setId(i);
			componente.setDescricao("teste"+i);
			componentes.add(componente);
		}

		
		return componentes;
	}

	@Override
	public void addComponente(Componente componente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Componente busca(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Componente altera(Componente componente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Componente> buscaPorGrupo(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
