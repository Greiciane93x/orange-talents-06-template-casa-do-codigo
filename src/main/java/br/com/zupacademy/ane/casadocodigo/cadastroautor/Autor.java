package br.com.zupacademy.ane.casadocodigo.cadastroautor;

import br.com.zupacademy.ane.casadocodigo.cadastrolivro.Livro;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 400)
    private String descricao;
    @Column(nullable = false)
    @JsonProperty("data")
    private LocalDateTime data;

    @JoinColumn(name = "livro_id")
    @ManyToOne
    private Livro livro;

    @Deprecated
    public Autor() {

    }

    public Autor(String nome, String email, String descricao, LocalDateTime data, Livro livro) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.data = data;
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() { return data; }
}
