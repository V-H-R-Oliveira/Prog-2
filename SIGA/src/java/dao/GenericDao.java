package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import usuarios.Aluno;
import usuarios.Professor;
import util.JPAUtil;

public class GenericDao <T> implements Serializable
{
    private final Class<T> classe;
    EntityManager manager;

    public GenericDao(Class<T> classe) 
    {
        this.classe = classe;
    }
    
    public void inserir(T objeto)
    {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(objeto);
        tx.commit();
        return;
    }
    
    public Aluno searchByRA(Integer ra)
    {
        Aluno temp = null;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Aluno a WHERE a.ra = :n";
        TypedQuery<Aluno> query = manager.createQuery(sql, Aluno.class);
        query.setParameter("n", ra);
        
        try 
        {
            temp = query.getSingleResult();
        } catch (Exception e) 
        {  
            throw e;
        }finally 
        {
            manager.close();
        }
        
        return temp;
        
    }
       
    public Professor validarLogin(Integer ra, String senha)
    {
        Professor temp = null;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Professor a WHERE a.ra = :ra AND a.senha =:senha";
        TypedQuery<Professor> query = manager.createQuery(sql, Professor.class);
        query.setParameter("ra", ra);
        query.setParameter("senha", senha);
        try 
        {
            temp = query.getSingleResult();
        } catch(Exception e) 
        {  
            return null;
        }finally 
        {
            manager.close();
        }
        
        return temp;
        
    }
    
    public List<T> listarTodos(Class objeto) 
    {        
        manager = JPAUtil.getEntityManager();
        CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(objeto);
        query.select(query.from(objeto));
        List<T> lista = manager.createQuery(query).getResultList();
        manager.close();      
        return lista;
    }
    
    public T alterar(T objeto) 
    {
        manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        objeto = manager.merge(objeto);
        manager.getTransaction().commit();
        manager.close();
        return objeto;
    }
}
