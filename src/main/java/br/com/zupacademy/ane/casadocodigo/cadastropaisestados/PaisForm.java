package br.com.zupacademy.ane.casadocodigo.cadastropaisestados;

import br.com.zupacademy.ane.casadocodigo.validacao.ValorUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PaisForm {

    @NotBlank
    @ValorUnico(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public PaisForm() {
    }
    public PaisForm(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public Pais converter() {
        return new Pais(nome);
    }
}
