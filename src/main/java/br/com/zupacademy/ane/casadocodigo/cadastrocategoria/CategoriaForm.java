package br.com.zupacademy.ane.casadocodigo.cadastrocategoria;

import br.com.zupacademy.ane.casadocodigo.validacao.ValorUnico;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    private Integer id;
    @NotBlank(message = "nome é obrigatório!")
    @ValorUnico(domainClass = Categoria.class, fieldName ="nome")
    private String nome;


    public String getNome() {
        return nome;
    }

    public Categoria converter(CategoriaRepository categoriaRepository) {
        return new Categoria(id,nome);
    }
}
