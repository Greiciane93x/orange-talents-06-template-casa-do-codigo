package br.com.zupacademy.ane.casadocodigo.cadastroaluno;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

    @Query("select a from Autor a where a.email like ?1")
    Optional<Autor> findAutorByEmail(String email);

}
