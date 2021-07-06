package br.com.zupacademy.ane.casadocodigo.cadastrolivro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Page<Livro> findById(Long id, Pageable paginacao);
}
