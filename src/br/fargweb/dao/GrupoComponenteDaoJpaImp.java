package br.fargweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.fargweb.model.GrupoComponente;

@Transactional
@Repository
public class GrupoComponenteDaoJpaImp implements GrupoComponenteDao{

	@PersistenceContext
	private EntityManager manager;
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GrupoComponente> getLista() {
		
		String query = "select t from GrupoComponente t";
		
		return (List<GrupoComponente>)getManager().createQuery(query).getResultList();

	}

	@Override
	public void addGrupoComponente(GrupoComponente componente) {

		getManager().persist(componente);
	}

	@Override
	public void remove(long id) {

		GrupoComponente gComponente = busca(id);
		getManager().remove(gComponente);
		
	}

	@Override
	public GrupoComponente busca(long id) {

		GrupoComponente gComponente = getManager().find(GrupoComponente.class, id);
		
		return gComponente;
	}

	@Override
	public GrupoComponente altera(GrupoComponente componente) {
		
		return getManager().merge(componente);
	}

}
