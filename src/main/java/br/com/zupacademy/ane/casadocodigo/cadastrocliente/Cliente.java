package br.com.zupacademy.ane.casadocodigo.cadastrocliente;


import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false, unique = true)
    private String cpfcnpj;
    @Column(nullable= false)
    private String endereco;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable= false)
    private String telefone;
    @Column(nullable= false)
    private String cep;


    @OneToOne
    @JoinColumn(name="estado_id")
    private ClienteEstado estado;

    @OneToOne
    @JoinColumn(name= "pais_id")
    private ClientePais pais;

    public Cliente() {
    }

    public Cliente(String email, String nome, String sobrenome, String cpfcnpj, String endereco, String complemento, String telefone, String cep, ClienteEstado estado, ClientePais pais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfcnpj = cpfcnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }


    public ClienteEstado getEstado() {
        return estado;
    }

    public ClientePais getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id + "}";
    }
}
