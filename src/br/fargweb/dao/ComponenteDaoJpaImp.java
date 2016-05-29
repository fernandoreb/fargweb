package br.fargweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.fargweb.model.Componente;

@Transactional
@Repository
public class ComponenteDaoJpaImp implements ComponenteDao {

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
	public List<Componente> getLista() {
		
		String query = "select t from Componente t";
		
		return (List<Componente>)getManager().createQuery(query).getResultList();
	}

	@Override
	public void addComponente(Componente componente) {
		
		getManager().persist(componente);
	}

	@Override
	public void remove(long id) {
		
		Componente componente = busca(id);
		getManager().remove(componente);
	}

	@Override
	public Componente busca(long id) {
		Componente componente = getManager().find(Componente.class, id);
		
		return componente;
	}

	@Override
	public Componente altera(Componente componente) {
		return getManager().merge(componente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Componente> buscaPorGrupo(long id) {
		
		String sQuery = "select t from Componente t where t.grupoId=:Id";
		
		Query query = getManager().createQuery(sQuery);
		query.setParameter("Id", id);
		
		return (List<Componente>)query.getResultList();
	}

}
