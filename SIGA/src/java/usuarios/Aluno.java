package usuarios;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String nome;
    @Column
    private Integer ra;
    @Column
    private float nota;
    @Column
    private Integer faltas;
    
    public Aluno()
    {
        id = 0;
        nome = "";
        ra = 0;
        nota = 0.0f;
        faltas = 0;
    }
    
    public Aluno(String nome, Integer ra, float nota, Integer faltas)
    {
        setNome(nome);
        setRa(ra);
        setNota(nota);
        setFaltas(faltas);
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    public float getNota() 
    {
        return nota;
    }

    public void setNota(float nota) 
    {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (Float.floatToIntBits(this.nota) != Float.floatToIntBits(other.nota)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ra, other.ra)) {
            return false;
        }
        if (!Objects.equals(this.faltas, other.faltas)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString()
    {
        return "Aluno[" + "id= " + id + ", nome = " + nome + ", RA = " + ra + ", Nota: " + nota + ", Faltas: " + faltas + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }
}
