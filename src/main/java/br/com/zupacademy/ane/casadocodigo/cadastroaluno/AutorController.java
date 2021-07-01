package br.com.zupacademy.ane.casadocodigo.cadastroaluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository alunoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid AutorForm form){

        Optional<Autor> email = alunoRepository.findAutorByEmail(form.getEmail());
        Autor autor = form.converter(alunoRepository);
        if(email.isPresent()) {
           return ResponseEntity.status(400).body("Email inválido!");
        }
        alunoRepository.save(autor);
        return ResponseEntity.ok().build();

    }
}

