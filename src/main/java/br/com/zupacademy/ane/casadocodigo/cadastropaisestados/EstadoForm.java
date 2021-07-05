package br.com.zupacademy.ane.casadocodigo.cadastropaisestados;

import br.com.zupacademy.ane.casadocodigo.validacao.ValorUnico;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {

    @NotBlank
    @ValorUnico(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    private Long idPais;

    public EstadoForm(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado converter(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        return new Estado(nome, pais);
    }
}
