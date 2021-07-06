package br.com.zupacademy.ane.casadocodigo.cadastrocliente;

import br.com.zupacademy.ane.casadocodigo.validacao.CPFouCNPJ;
import br.com.zupacademy.ane.casadocodigo.validacao.ValorUnico;
import br.com.zupacademy.ane.casadocodigo.validacao.isValidEstado;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ClienteForm {

    @NotBlank
    @Email
    @ValorUnico(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CPFouCNPJ
    private String cpfcnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @NotNull
    @isValidEstado(domainClass = ClienteEstado.class, fieldName = "id")
    private Long idEstado;
    @NotNull
    private Long idPais;

    public ClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String cpfcnpj, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String telefone, @NotBlank String cep, @NotNull Long idEstado, @NotNull Long idPais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfcnpj = cpfcnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.telefone = telefone;
        this.cep = cep;
        this.idEstado = idEstado;
        this.idPais = idPais;
    }

    @Deprecated
    public ClienteForm() {
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

    public Long getIdEstado() {
        return idEstado;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Cliente converter(EntityManager manager)  {
        @NotNull ClienteEstado estado = manager.find(ClienteEstado.class, idEstado);
        @NotNull ClientePais pais = manager.find(ClientePais.class, idPais);

        return new Cliente(nome, sobrenome, email, cpfcnpj, endereco, complemento, telefone, cep, estado, pais);
    }

}
