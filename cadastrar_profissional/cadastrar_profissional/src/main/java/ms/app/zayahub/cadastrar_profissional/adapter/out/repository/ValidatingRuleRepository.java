package ms.app.zayahub.cadastrar_profissional.adapter.out.repository;

import ms.app.zayahub.cadastrar_profissional.adapter.out.entity.RegisterProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidatingRuleRepository extends JpaRepository<RegisterProfessionalEntity, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByName(String name);

    @Query("SELECT CASE WHEN (COUNT(r) > 0) THEN true ELSE false END FROM register_professional r WHERE r.active = true")
    Boolean existsActiveUsers();

}
