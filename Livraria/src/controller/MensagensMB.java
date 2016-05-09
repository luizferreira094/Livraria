package controller;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class MensagensMB {
     
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns!", " Sua compra foi efetuada!."));
    }
}