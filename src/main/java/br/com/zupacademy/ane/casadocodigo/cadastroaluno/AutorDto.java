package br.com.zupacademy.ane.casadocodigo.cadastroaluno;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class AutorDto {

    private Integer id;
    @NotBlank(message="Nome é obrigatório!")
    private String nome;
    @NotBlank(message="Email é obrigatório!")
    @Email
    private String email;
    @NotBlank
    @Size(max = 400 , message = "Valor deve ser menor do que 400")
    private String descricao;
    @NotNull
    private LocalDateTime data = LocalDateTime.now();

    public AutorDto(Autor aluno) {
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.descricao = aluno.getDescricao();
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

}


