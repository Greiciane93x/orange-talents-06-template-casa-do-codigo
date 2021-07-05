package br.com.zupacademy.ane.casadocodigo.cadastrolivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {


    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public String cadastrarLivro(@RequestBody @Valid LivroForm livroForm){

        Livro livro = livroForm.converter(manager);
        manager.persist(livro);
        return livro.toString();

    }

    @GetMapping
    public Page<LivroDto> lista(@RequestParam(required = true)Long id, @PageableDefault(sort ="id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){
        if(id == null){
            Page<Livro> livros = livroRepository.findAll(paginacao);
            return LivroDto.converter(livros);
        }else {
            Page<Livro> livros = livroRepository.findById(id, paginacao);
            return LivroDto.converter(livros);
        }

    }

//        if(nomeCurso == null){
//        Page<Topico> topicos = topicoRepository.findAll(paginacao);
//        return TopicoDto.converter(topicos);
//    }else{
//        Page<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
//        return TopicoDto.converter(topicos);
//    }
//}








}
