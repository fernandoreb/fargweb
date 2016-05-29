package br.fargweb.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.transaction.annotation.Transactional;

import br.fargweb.dao.ComponenteDao;
import br.fargweb.dao.GrupoComponenteDao;
import br.fargweb.model.Componente;
import br.fargweb.model.GrupoComponente;

@Transactional
@ManagedBean
@SessionScoped
public class CatalogoView {
	
	@ManagedProperty("#{grupoComponenteDaoJpaImp}")
	private GrupoComponenteDao grupoComponenteDao;
	
	public void setGrupoComponenteDao(GrupoComponenteDao grupoComponenteDao) {
		this.grupoComponenteDao = grupoComponenteDao;
	}

	@ManagedProperty("#{componenteDaoJpaImp}")
	private ComponenteDao componenteDao;
	
	public void setComponenteDao(ComponenteDao componenteDao) {
		this.componenteDao = componenteDao;
	}

	private GrupoComponente selected;
	
	public List<Componente> getListaComponentes(){
		List<Componente> lComponentes = null;
		
		lComponentes = componenteDao.buscaPorGrupo(selected.getId());
		
		return lComponentes;
	}
	
	public List<GrupoComponente> getLista(){
		
		return grupoComponenteDao.getLista();
	}
	
	public GrupoComponente getSelected() {
		return selected;
	}

	public void setSelected(GrupoComponente selected) {
		this.selected = selected;
	}
	
	public String cadastroGrupo(){
		return "cadastroGrupo.jsf";
	}
	
	public void excluirComponente(long id){
		
		componenteDao.remove(id);
		
	}
}
