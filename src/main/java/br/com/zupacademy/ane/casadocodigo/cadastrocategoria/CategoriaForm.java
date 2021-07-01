package br.com.zupacademy.ane.casadocodigo.cadastrocategoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    private Integer id;
    @NotBlank(message = "nome é obrigatório!")
    private String nome;


    public String getNome() {
        return nome;
    }

    public Categoria converter(CategoriaRepository categoriaRepository) {
        return new Categoria(id,nome);
    }
}
