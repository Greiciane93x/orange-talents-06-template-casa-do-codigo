package br.com.zupacademy.ane.casadocodigo.cadastroautor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {


}
