/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.de.aula;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitor Oliveira
 */
public class AeroportoTest {
    
    public AeroportoTest() {
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

    @Test
    public void testarAterrisarExibir() 
    {
        System.out.println("Utilizando um método de teste");
        Aviao a = new Aviao("Emirates", 47);
        Aviao b = new Aviao("GOL", 31);
        Aviao c = new Aviao("Boing", 32);
        Aviao d = new Aviao("TAP", 47);
        Aeroporto aeroporto = new Aeroporto("Garulhos", 32);
        aeroporto.aterrissar(a);
        aeroporto.aterrissar(b);
        aeroporto.exibirAeroporto();
    }
    
}
