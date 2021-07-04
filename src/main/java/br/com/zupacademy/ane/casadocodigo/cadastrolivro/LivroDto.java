package br.com.zupacademy.ane.casadocodigo.cadastrolivro;

import br.com.zupacademy.ane.casadocodigo.validacao.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LivroDto {

    @NotBlank
    @ValorUnico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Length(max = 500, message = "Não pode exceder de 500 caracteres")
    private String resumo;
    private String sumario;
    @Min(20)
    @NotNull
    private BigDecimal preco;
    @Min(100)
    @NotNull
    private Long numeroPaginas;
    @ValorUnico(domainClass = Livro.class, fieldName = "isbn")
    @NotBlank
    private String isbn;
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @NotNull
    private LocalDate dataPublicacao;


    public LivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
    }

    public static Page<LivroDto> converter(Page<Livro> livros) {
        return livros.map(LivroDto::new);
    }


    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Long getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }
}
