package br.com.zupacademy.ane.casadocodigo.cadastrolivro;

import br.com.zupacademy.ane.casadocodigo.cadastroaluno.Autor;
import br.com.zupacademy.ane.casadocodigo.cadastroaluno.AutorForm;
import br.com.zupacademy.ane.casadocodigo.cadastroaluno.AutorRepository;
import br.com.zupacademy.ane.casadocodigo.cadastrocategoria.Categoria;
import br.com.zupacademy.ane.casadocodigo.cadastrocategoria.CategoriaDto;
import br.com.zupacademy.ane.casadocodigo.cadastrocategoria.CategoriaForm;
import br.com.zupacademy.ane.casadocodigo.cadastrocategoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {


    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public String cadastrarAutor(@RequestBody @Valid LivroForm livroForm){

        Livro livro = livroForm.converter(manager);
        manager.persist(livro);
        return livro.toString();

    }

}
