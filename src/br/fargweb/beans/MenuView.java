package br.fargweb.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@ViewScoped
public class MenuView {
	private MenuModel model;
	
	@PostConstruct
    public void init() {
        model = new DefaultMenuModel();
         
        //First submenu
        DefaultSubMenu submenu = new DefaultSubMenu("Eletrônica");
        
        DefaultMenuItem item = new DefaultMenuItem("Catálogo");
        item.setCommand("#{menuView.catalogo}");
        submenu.addElement(item); 
        
        item = new DefaultMenuItem("Blog ArduinoCC");
        item.setUrl("http://arduinoccbr.blogspot.com.br");
        submenu.addElement(item);
        model.addElement(submenu);
         
        //Second submenu
        submenu = new DefaultSubMenu("Java");
        item = new DefaultMenuItem("Exemplos");
        item.setCommand("#{menuView.javaExemplos}");
        submenu.addElement(item);
        model.addElement(submenu);
        
        //Second submenu
        submenu = new DefaultSubMenu("C++");
        item = new DefaultMenuItem("Exemplos");
        item.setCommand("#{menuView.cplusExemplos}");
        submenu.addElement(item);
        model.addElement(submenu);
        
        /*item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.addElement(item)*/
        
    }
 
	public String catalogo(){
		return "catalogo.jsf";
	}
	
    public MenuModel getModel() {
        return model;
    }   
}
