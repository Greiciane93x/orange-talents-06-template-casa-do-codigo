package br.com.zupacademy.ane.casadocodigo.cadastrolivro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class DetalheLivroController {

    @PersistenceContext
    EntityManager manager;

    @GetMapping(value="/livro/{id}")
    public ResponseEntity<DetalheLivroDto> detalharLivroEspecifico(@PathVariable("id") Long id) {
        Livro livro = manager.find(Livro.class, id);
        if(livro == null){
            return ResponseEntity.notFound().build();
        }
        DetalheLivroDto detalheLivroDto = new DetalheLivroDto(livro);
        return ResponseEntity.ok(detalheLivroDto);
    }
}
