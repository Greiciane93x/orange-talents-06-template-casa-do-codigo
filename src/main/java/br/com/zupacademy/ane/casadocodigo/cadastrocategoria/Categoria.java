package br.com.zupacademy.ane.casadocodigo.cadastrocategoria;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria(Integer id, String nome) {
        this.nome = nome;
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
