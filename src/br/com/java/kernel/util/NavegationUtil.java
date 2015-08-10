package br.com.java.kernel.util;

import java.io.IOException;

import javax.faces.context.FacesContext;

public class NavegationUtil {

	
	private String contexto;
	private MessageUtil messageUtil;
	
	public void redirect(String redirect){
		try {
			
			this.contexto = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
			FacesContext.getCurrentInstance().getExternalContext().redirect(contexto +"/"+ redirect);
			
		} catch (IOException e) {
			messageUtil.messageInfo( "<MENSAGEM> Pagina não enccontrada");
		}
	}
}
