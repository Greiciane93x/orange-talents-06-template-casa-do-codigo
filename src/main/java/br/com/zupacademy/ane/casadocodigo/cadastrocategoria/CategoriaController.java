package br.com.zupacademy.ane.casadocodigo.cadastrocategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> cadastrarCategoria(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.converter(categoriaRepository);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }

}
