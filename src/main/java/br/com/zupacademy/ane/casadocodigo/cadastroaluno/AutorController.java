package br.com.zupacademy.ane.casadocodigo.cadastroaluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository alunoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrarUsuario(@RequestBody @Valid AutorForm form){
        Autor aluno = form.converter(alunoRepository);
        alunoRepository.save(aluno);

        return ResponseEntity.ok().build();

    }


}

