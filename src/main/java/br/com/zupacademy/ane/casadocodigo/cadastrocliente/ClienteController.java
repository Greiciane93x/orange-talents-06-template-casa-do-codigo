package br.com.zupacademy.ane.casadocodigo.cadastrocliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController

public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping(value = "/clientes")
    @Transactional
    private String cadastrarCliente(@RequestBody @Valid ClienteForm clienteForm){

        Cliente cliente = clienteForm.converter(manager);
        clienteRepository.save(cliente);

        return cliente.toString();
    }

}
