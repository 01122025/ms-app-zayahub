package ms.app.zayahub.cadastrar_profissional.adapter.out.repository;

import ms.app.zayahub.cadastrar_profissional.adapter.out.entity.RegisterProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterProfessionalRepository extends JpaRepository<RegisterProfessionalEntity, Long> {
    boolean existsById(Long id);
    boolean existsByNome(String nome);
}
