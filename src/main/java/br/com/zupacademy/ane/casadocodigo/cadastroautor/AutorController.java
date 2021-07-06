package br.com.zupacademy.ane.casadocodigo.cadastroautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository alunoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrarUsuario(@RequestBody @Valid AutorForm form){
        Autor autor = form.converter(alunoRepository);

        alunoRepository.save(autor);
        return ResponseEntity.ok().build();

    }
}

