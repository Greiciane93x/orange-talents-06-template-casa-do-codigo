package br.com.zupacademy.ane.casadocodigo.cadastrolivro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer> {

}
