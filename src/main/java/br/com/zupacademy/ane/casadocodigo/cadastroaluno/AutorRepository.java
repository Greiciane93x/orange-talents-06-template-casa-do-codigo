package br.com.zupacademy.ane.casadocodigo.cadastroaluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
