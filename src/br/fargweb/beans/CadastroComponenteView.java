package br.fargweb.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.fargweb.dao.ComponenteDao;
import br.fargweb.dao.GrupoComponenteDao;
import br.fargweb.model.Componente;
import br.fargweb.model.GrupoComponente;
import br.fargweb.model.Propriedade;


@ManagedBean
@SessionScoped
public class CadastroComponenteView {

	@ManagedProperty("#{componenteDaoJpaImp}")
	private ComponenteDao componenteDao;
	
	@ManagedProperty("#{grupoComponenteDaoJpaImp}")
	private GrupoComponenteDao grupoComponenteDao;

	public void setComponenteDao(ComponenteDao componenteDao) {
		this.componenteDao = componenteDao;
	}
	
	public void setGrupoComponenteDao(GrupoComponenteDao grupoComponenteDao) {
		this.grupoComponenteDao = grupoComponenteDao;
	}
	
	private boolean alteracao;
	
	//componente temporário
	private Componente componente;
	

	private String grupoSelecionado;
	
	private Propriedade propriedade1;
	private Propriedade propriedade2;
	
	@PostConstruct
	private void init(){
		alteracao = false;
		componente = new Componente();
		propriedade1 = new Propriedade();
		propriedade2 = new Propriedade();
	}
	
	private String erro;
	
	public String salvar(){

		componente.setGrupoId(Long.parseLong(grupoSelecionado));
		
		if(alteracao){
			componenteDao.altera(componente);
		}
		else{
			componenteDao.addComponente(componente);
		}
		
		return "catalogo.jsf";
	}
	
	public String cancelar(){
		return "catalogo.jsf";
	}
	
	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public List<SelectItem> getListaGrupos() {
		
		List<GrupoComponente> listaTemp = null;
		
		List<SelectItem> listaGrupos = new ArrayList<SelectItem>();
			
		listaTemp = grupoComponenteDao.getLista();
			
		if(listaTemp!=null)
			for (GrupoComponente grupoComponente : listaTemp) {
				listaGrupos.add(new SelectItem(grupoComponente.getId(), grupoComponente.getDecricao()));
		}
		
		return listaGrupos;
	}


	public String getGrupoSelecionado() {
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(String grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}

	public Propriedade getPropriedade1() {
		return propriedade1;
	}

	public void setPropriedade1(Propriedade propriedade1) {
		this.propriedade1 = propriedade1;
	}

	public Propriedade getPropriedade2() {
		return propriedade2;
	}

	public void setPropriedade2(Propriedade propriedade2) {
		this.propriedade2 = propriedade2;
	}
	
	public String cadastroComponente(){
		
		componente = new Componente();
		propriedade1 = new Propriedade();
		propriedade2 = new Propriedade();
		alteracao = false;
		
		return "cadastroComponente.jsf";
	}
	
	public String cadastroComponenteGrupoSel(long idGrupo){
		componente = new Componente();
		propriedade1 = new Propriedade();
		propriedade2 = new Propriedade();
		alteracao = false;
		grupoSelecionado = idGrupo+"";
		
		return "cadastroComponente.jsf";
	}
	
	public String alterarComponente(long id){
		
		componente = componenteDao.busca(id);
		grupoSelecionado = componente.getGrupoId()+""; 
		alteracao = true;
		
		return "cadastroComponente.jsf";
	}
	
}

