package br.com.zupacademy.ane.casadocodigo.cadastrolivro;

import br.com.zupacademy.ane.casadocodigo.cadastroaluno.Autor;
import br.com.zupacademy.ane.casadocodigo.cadastroaluno.AutorRepository;
import br.com.zupacademy.ane.casadocodigo.cadastrocategoria.Categoria;
import br.com.zupacademy.ane.casadocodigo.cadastrocategoria.CategoriaRepository;
import br.com.zupacademy.ane.casadocodigo.validacao.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

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
    @NotNull
    private Integer idAutor;
    @NotNull
    private Integer idCategoria;

    public LivroForm() {
    }

    public LivroForm(String titulo,
                     String resumo,
                     String sumario,
                     BigDecimal preco,
                     Long numeroPaginas,
                     String isbn,
                     LocalDate dataPublicacao,
                     Integer idAutor,
                     Integer idCategoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
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

    public Integer getIdAutor() {
        return idAutor;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public Livro converter(EntityManager manager) {

        @NotNull Autor autor = manager.find(Autor.class, idAutor);
        @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);

        return new Livro(titulo, resumo, sumario, preco, isbn, numeroPaginas, dataPublicacao, autor, categoria
        );

    }
}
