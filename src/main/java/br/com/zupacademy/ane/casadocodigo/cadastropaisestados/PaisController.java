package br.com.zupacademy.ane.casadocodigo.cadastropaisestados;


import br.com.zupacademy.ane.casadocodigo.cadastrolivro.Livro;
import br.com.zupacademy.ane.casadocodigo.cadastrolivro.LivroForm;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public String cadastrarPais(@RequestBody @Valid PaisForm paisForm){

        Pais pais = paisForm.converter();
        manager.persist(pais);
        return pais.toString();

    }
}
