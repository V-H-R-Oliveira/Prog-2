package controle;

import dao.GenericDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import usuarios.Professor;

@ManagedBean (name="novoProfessor")
@ViewScoped
public class NovoProfessor implements Serializable
{
    private Professor professor;
    private GenericDao<Professor> dao;
    
    public NovoProfessor()
    {
        professor = new Professor();
        dao = new GenericDao(Professor.class);
    }

    public void inserirProfessor()
    {
        dao.inserir(professor);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Professor cadastrado", null));
        professor = new Professor();
    }
    
    public String logarProfessor()
    {
        Professor temp = dao.validarLogin(getProfessor().getRa(), getProfessor().getSenha());
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        if(temp == null)
        {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível logar", null));
            return null;
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        session.setAttribute("usuarioLogado", temp);
        return "/posLogin";
    }
    
    public void deslogar()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(false);
        session.setAttribute("usuarioLogado", null);
    }
    
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public GenericDao<Professor> getDao() {
        return dao;
    }

    public void setDao(GenericDao<Professor> dao) {
        this.dao = dao;
    }
}
