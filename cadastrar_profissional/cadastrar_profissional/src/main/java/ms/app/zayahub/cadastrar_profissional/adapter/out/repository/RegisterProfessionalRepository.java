package br.com.api.cadastro_barbeiro.adapter.out.repository;

import br.com.api.cadastro_barbeiro.adapter.out.entity.RegisterProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterProfessionalRepository extends JpaRepository<RegisterProfessionalEntity, Long> {
    boolean existsById(Long id);
    boolean existsByNome(String nome);
}
