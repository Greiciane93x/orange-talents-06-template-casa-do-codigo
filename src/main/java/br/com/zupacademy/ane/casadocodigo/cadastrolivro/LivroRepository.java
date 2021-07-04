package br.com.zupacademy.ane.casadocodigo.cadastrolivro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    Page<Livro> findById(Long id, Pageable paginacao);
}
