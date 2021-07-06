package br.com.zupacademy.ane.casadocodigo.cadastrocliente;

import br.com.zupacademy.ane.casadocodigo.cadastropaisestados.Estado;
import ch.qos.logback.core.net.server.Client;

import javax.persistence.*;

@Entity
public class ClientePais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;


    @ManyToOne
    private ClienteEstado estado;

    public ClientePais() {
    }

    public ClientePais(String nome, ClienteEstado estado) {
        this.nome = nome;
        this.estado = estado;

    }

    public String getNome() {
        return nome;
    }

    public ClienteEstado getEstado() {
        return estado;
    }
}
