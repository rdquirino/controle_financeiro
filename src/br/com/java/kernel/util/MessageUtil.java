package br.com.java.kernel.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageUtil {

	private FacesMessage facesMessage;
	
	public void messageGeneric(String message){
		
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", message);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
    public void messageInfo(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atenção!", message));
    }
     
    public void messageWarn(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", message));
    }
     
    public void messageError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção!", message));
    }
     
    public void messageFatal(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atenção!", message));
    }
}
