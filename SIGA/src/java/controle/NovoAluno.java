package controle;

import dao.GenericDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import usuarios.Aluno;

@ManagedBean (name="novoAluno")
@ViewScoped
public class NovoAluno implements Serializable
{
    private Aluno aluno;
    private GenericDao<Aluno> dao;
    
    public NovoAluno()
    {
        aluno = new Aluno();
        dao = new GenericDao(Aluno.class);
    }
    
    public void inserirAluno()
    {
        dao.inserir(aluno);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno cadastrado", null));
        aluno = new Aluno();
    }
    
    public void consulta()
    {
        Aluno temp = dao.searchByRA(getAluno().getRa());
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        if(temp != null)
        {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, temp.toString(), null));
        }else
        {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aluno não existe", null));
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public GenericDao<Aluno> getDao() {
        return dao;
    }

    public void setDao(GenericDao<Aluno> dao) 
    {
        this.dao = dao;
    }
}
