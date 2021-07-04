package br.com.zupacademy.ane.casadocodigo.cadastrocategoria;

import br.com.zupacademy.ane.casadocodigo.cadastrolivro.Livro;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToOne
    private Livro livro;

    @Deprecated
    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
