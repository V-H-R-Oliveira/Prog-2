package exercicio.de.aula;

public class Aviao 
{
    private String companhia;
    private int prefixo;
    
    public Aviao(String c, int p)
    {
        this.setCompanhia(c);
        this.setPrefixo(p);
    }
    
    public void setCompanhia(String c)
    {
        this.companhia = c;
    }
    
    public String getCompanhia()
    {
        return this.companhia;
    }
    
    public void setPrefixo(int c)
    {
        this.prefixo = c;
    }
    
    public int getPrefixo()
    {
        return this.prefixo;
    }
}
