package br.fargweb.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.fargweb.dao.GrupoComponenteDao;
import br.fargweb.model.GrupoComponente;


@ManagedBean
@ViewScoped
public class CadastroGrupoComponenteView {

	@ManagedProperty("#{grupoComponenteDaoJpaImp}")
	private GrupoComponenteDao grupoComponenteDao;

	public void setGrupoComponenteDao(GrupoComponenteDao grupoComponenteDao) {
		this.grupoComponenteDao = grupoComponenteDao;
	}
	
	private String descricao;
	
	private String erro;
	
	public String salvar(){
		
		if(descricao==null||descricao.equals("")||descricao.length()<5 ){
			erro = "Tamanho mínimo de 5";
			return "cadastroGrupo.jsf";
		}
		
		GrupoComponente gComponente = new GrupoComponente();
		gComponente.setDecricao(descricao);
		
		grupoComponenteDao.addGrupoComponente(gComponente);
		
		return "catalogo.jsf";
	}
	
	public String cancelar(){
		return "catalogo.jsf";
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
}
