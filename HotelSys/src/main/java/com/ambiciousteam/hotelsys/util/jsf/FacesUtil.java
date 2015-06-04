package com.ambiciousteam.hotelsys.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

    FacesContext facesContext = FacesContext.getCurrentInstance();

    public void successMessage(String message) {
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        message, message));
    }

    public void warningMessage(String message) {
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        message, message));
    }

    public void errorMessage(String message) {
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        message, message));
    }

    public void rapaint(String componente) {
        facesContext.getPartialViewContext().getRenderIds().add(componente);
    }

}
