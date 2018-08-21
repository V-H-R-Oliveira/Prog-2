package exercicio.de.aula;

public class ExercicioDeAula 
{
    public static void main(String[] args) 
    {
        Aviao a = new Aviao("Emirates", 47);
        Aviao b = new Aviao("GOL", 31);
        Aviao c = new Aviao("Boing", 32);
        Aviao d = new Aviao("TAP", 47);
        Aeroporto aeroporto = new Aeroporto("Garulhos", 32);
        Aeroporto a2 = new Aeroporto("Curitiba", 47);
        aeroporto.aterrissar(a);
        aeroporto.aterrissar(b);
        a2.aterrissar(c);
        a2.aterrissar(d);
        aeroporto.exibirAeroporto();
        a2.exibirAeroporto();
    }
}
