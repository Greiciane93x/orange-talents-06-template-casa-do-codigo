package br.com.zupacademy.ane.casadocodigo.cadastrocategoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDto {

    @NotBlank(message = "nome é obrigatório!")
    private String nome;

    public CategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
