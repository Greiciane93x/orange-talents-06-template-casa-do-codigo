package br.com.zupacademy.ane.casadocodigo.cadastropaisestados;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @PostMapping
    public String cadastrarEstado(@RequestBody @Valid EstadoForm EstadoForm){

        Estado estado = EstadoForm.converter(manager);
        manager.persist(estado);
        return estado.toString();

    }
}
