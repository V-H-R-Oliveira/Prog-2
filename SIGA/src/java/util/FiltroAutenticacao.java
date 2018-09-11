package util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import usuarios.Professor;

public class FiltroAutenticacao implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        String pagina = facesContext.getViewRoot().getViewId();
        if (pagina.contains("/index"))
        {
            return;
        }else if(pagina.contains("/usuario/cadProfessor"))
        {
            return;
        }else if(pagina.contains("/usuario/login"))
        {
            return;
        }else if(pagina.contains("/usuario/consultarNota"))
        {
            return;
        }else if(pagina.contains("/usuario/loginAdm"))
        {
            return;
        }
        
        Professor usuarioLogado = (Professor) session.getAttribute("usuarioLogado");
        if(usuarioLogado == null) 
        {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/index?faces-redirect=true");
            facesContext.renderResponse();
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {        

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW; 
    }

}