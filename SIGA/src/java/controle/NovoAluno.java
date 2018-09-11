package controle;

import dao.GenericDao;
import java.io.Serializable;
import java.util.List;
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
    private List<Aluno> lista;
    
    public NovoAluno()
    {
        aluno = new Aluno();
        dao = new GenericDao(Aluno.class);
        lista = dao.listarAluno(Aluno.class);
    }
    
    public void inserirAluno()
    {
        dao.inserir(aluno);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno cadastrado", null));
        aluno = new Aluno();
    }
    
    public void excluir()
    {
        boolean temp = dao.excluir(aluno.getId());
        FacesContext contexto = FacesContext.getCurrentInstance();
        if(temp == false)
        {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aluno inexistente", null));
            return;
        }
        
        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno removido com sucesso", null));
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

    public List<Aluno> getLista() {
        return lista;
    }

    public void setLista(List<Aluno> lista) {
        this.lista = lista;
    }
}
