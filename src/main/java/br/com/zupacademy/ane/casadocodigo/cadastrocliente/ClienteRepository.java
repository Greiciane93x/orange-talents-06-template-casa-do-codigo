package br.com.zupacademy.ane.casadocodigo.cadastrocliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
