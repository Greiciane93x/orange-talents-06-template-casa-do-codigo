package br.com.zupacademy.ane.casadocodigo.cadastropaisestados;

import br.com.zupacademy.ane.casadocodigo.cadastrocliente.Cliente;

import javax.persistence.*;

@Entity
public class Pais {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false, unique=true)
    private String nome;


    @Deprecated
    public Pais() {
    }
    public Pais(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
