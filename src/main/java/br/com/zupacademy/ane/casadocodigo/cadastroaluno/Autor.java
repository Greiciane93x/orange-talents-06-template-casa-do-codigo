package br.com.zupacademy.ane.casadocodigo.cadastroaluno;

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
    private LocalDateTime data;

    @Deprecated
    public Autor() {

    }
    public Autor(String nome, String email, String descricao,LocalDateTime data) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.data = data;
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
