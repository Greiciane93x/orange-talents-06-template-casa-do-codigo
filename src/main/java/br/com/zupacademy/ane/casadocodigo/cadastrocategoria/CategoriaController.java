package br.com.zupacademy.ane.casadocodigo.cadastrocategoria;

import br.com.zupacademy.ane.casadocodigo.cadastroaluno.Autor;
import br.com.zupacademy.ane.casadocodigo.cadastroaluno.AutorForm;
import br.com.zupacademy.ane.casadocodigo.cadastroaluno.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarCategoria(@RequestBody @Valid CategoriaForm form){
        Optional<Categoria> nome = categoriaRepository.findCategoriaByName(form.getNome());
        Categoria categoria = form.converter(categoriaRepository);
        if(nome.isPresent()) {
            return ResponseEntity.status(400).body("Nome inválido");
        }
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }

}
