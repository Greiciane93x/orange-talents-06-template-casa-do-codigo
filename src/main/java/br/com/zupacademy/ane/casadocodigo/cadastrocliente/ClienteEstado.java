package br.com.zupacademy.ane.casadocodigo.cadastrocliente;

import javax.persistence.*;

@Entity
public class ClienteEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    public ClienteEstado() {
    }

    public String getNome() {
        return nome;
    }

    public ClienteEstado(String nome) {
        this.nome = nome;
    }
}
