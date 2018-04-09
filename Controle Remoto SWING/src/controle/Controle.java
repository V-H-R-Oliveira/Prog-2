package controle;

/**
 * @author Arthur Diniz
 * @author Vitor Oliveira
 */
public class Controle {
    
    private int sliderVolume;
    private boolean btnState;
    private int canal;
    
    public Controle() {
     this.setVolume(50);
     this.setState(false);
     this.setCanal(0);
    }
    
    public void setVolume(int valor) {
        this.sliderVolume = valor;
    }
    
    public int getVolume() {
        return this.sliderVolume;
    }
    
    public void setState(boolean state) { 
        this.btnState = state;
    }
    
    public boolean isOn() {
        return this.btnState;
    }
    
    public void setCanal(int c)
    {
        this.canal = c;
    }
    
    public int getCanal()
    {
        return this.canal;
    }
    
    public void changeCanal(int ncanal)
    {
       this.setCanal(ncanal);
    }
}