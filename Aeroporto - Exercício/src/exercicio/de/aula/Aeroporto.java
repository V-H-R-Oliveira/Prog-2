package exercicio.de.aula;

import java.util.ArrayList;

public class Aeroporto 
{
    private String nome;
    private int prefixo;
    private ArrayList<Aviao> patio;
    private ArrayList<Aviao> saida;
    private ArrayList<Aviao> entrada;
    
    public Aeroporto(String n, int p)
    {
        this.setNome(n);
        this.setPrefixo(p);
        this.patio = new ArrayList();
        this.saida = new ArrayList();
        this.entrada = new ArrayList();
    }
    
    public void setNome(String n)
    {
        this.nome = n;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setPrefixo(int c)
    {
        this.prefixo = c;
    }
    
    public int getPrefixo()
    {
        return this.prefixo;
    }
    
    public void aterrissar(Aviao a)
    {
        this.patio.add(a);
        this.entrada.add(a);
    }
    
    public void exibirAeroporto()
    {
        int c = 1;
        
        for(Aviao x: this.patio)
        {
            System.out.println("----------------------Avião " + c + " -----------------------------------------------");
            System.out.println("Prefixo: " + x.getPrefixo());
            System.out.println("Companhia: " + x.getCompanhia());
            System.out.println("-----------------------------------------------------------------------------");
            c++;
        }
    }
    
    public void decolar(Aviao x)
    {
        for(int i = 0; i < this.patio.size(); i++)
        {
            if(x.getPrefixo() == this.patio.get(i).getPrefixo())
            {
                this.saida.add(x);
                this.patio.remove(x);
            }
        }
  
    }
}
