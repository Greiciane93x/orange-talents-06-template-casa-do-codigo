package br.com.zupacademy.ane.casadocodigo.cadastroaluno;
import br.com.zupacademy.ane.casadocodigo.cadastrolivro.Livro;
import br.com.zupacademy.ane.casadocodigo.validacao.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AutorForm {

        private Integer id;
        @NotNull
        @NotBlank
        @NotEmpty(message="Nome é obrigatório!")
        private String nome;
        @NotNull
        @NotBlank(message="Email é obrigatório!")
        @NotEmpty @Email
        @ValorUnico(domainClass = Autor.class, fieldName = "email")
        private String email;
        @NotEmpty @NotNull
        @NotBlank @Length(max = 400, message = "Não pode exceder de 400 caracteres")
        private String descricao;
        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        private LocalDateTime data = LocalDateTime.now();

        private Livro livro;

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getDescricao() {
            return descricao;
        }

        public LocalDateTime getData() { return data; }

        public Livro getLivro() {
                return livro;
        }

        public Autor converter(AutorRepository alunoRepository) {
                return new Autor(nome, email, descricao,data, livro);
        }


}

