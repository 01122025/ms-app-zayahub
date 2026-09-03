package ms.app.zayahub.cadastrar_profissional.adapter.out.repository;

import ms.app.zayahub.cadastrar_profissional.adapter.out.entity.RegisterProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterProfessionalRepository extends JpaRepository<RegisterProfessionalEntity, Long> {
    boolean existsById(Long id);
    List<RegisterProfessionalEntity> findByActiveTrue();
}
