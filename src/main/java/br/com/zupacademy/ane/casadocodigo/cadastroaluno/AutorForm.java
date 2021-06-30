package br.com.zupacademy.ane.casadocodigo.cadastroaluno;
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
        private String email;
        @NotEmpty @NotNull
        @NotBlank @Length(max = 400, message = "Não pode exceder de 400 caracteres")
        private String descricao;
        @NotNull
        private LocalDateTime instanteCriacaoAutor = LocalDateTime.now();


        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getDescricao() {
            return descricao;
        }


    public Autor converter(AutorRepository alunoRepository) {
            return new Autor(nome,email,descricao,instanteCriacaoAutor
            );
    }
}




