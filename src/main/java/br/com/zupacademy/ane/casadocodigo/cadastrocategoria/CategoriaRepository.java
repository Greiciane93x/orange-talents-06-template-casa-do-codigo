package br.com.zupacademy.ane.casadocodigo.cadastrocategoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query("select c from Categoria c where c.nome like ?1")
    Optional<Categoria> findCategoriaByName(String nome);
}
