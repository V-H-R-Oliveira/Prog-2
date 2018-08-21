package dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import usuarios.Administrador;
import usuarios.Aluno;
import usuarios.Professor;

public class GenericDaoTest {
    
    public GenericDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   /* @Test
    public void testInserir() 
    {
      Administrador adm = new Administrador("Vitor Oliveira", "teste");
      Professor professor = new Professor("JAVA", 111111, "javasucks");
      Aluno aluno = new Aluno("Vitor Oliveira", 120151, 7.00f, 2);
      GenericDao<Aluno> alunoManager = new GenericDao(Aluno.class);
      GenericDao<Administrador> admManager = new GenericDao(Administrador.class);
      GenericDao<Professor> professorManager = new GenericDao(Professor.class);
      admManager.inserir(adm);
      professorManager.inserir(professor);
      alunoManager.inserir(aluno);
    }*/
    
   /*@Test
    public void testSearch() 
    {
        GenericDao<Aluno> aluno = new GenericDao(Aluno.class);   
        System.out.println(aluno.searchByRA(120151));
    }
    */
    
    /*@Test
    public void testList()
    {
        GenericDao<Professor> professor = new GenericDao(Professor.class);
        List<Professor> listarTodos = professor.listarTodos(Aluno.class);
        System.out.println(listarTodos);
    }*/
    
    /*
    @Test
    public void testAlterar()
    {
        GenericDao<Aluno> aluno = new GenericDao(Aluno.class);
        Aluno student = aluno.searchByRA(120151);
        student.setNota(7.5f);
        student.setFaltas(2);
        aluno.alterar(student);
        System.out.println(student);
    }*/
    
    /*
    @Test
    public void testBuscaRaProfessor()
    {
        GenericDao<Professor> professor = new GenericDao(Professor.class);
        Professor p = professor.buscaRaProfessor(111111);
        System.out.println(p);
    }*/
    
    /*
    @Test
    public void testBuscaSenhaProfessor()
    {
        GenericDao<Professor> professor = new GenericDao(Professor.class);
        Professor p = professor.validarLogin(111111, "javasuckss");
    }
    */
}
