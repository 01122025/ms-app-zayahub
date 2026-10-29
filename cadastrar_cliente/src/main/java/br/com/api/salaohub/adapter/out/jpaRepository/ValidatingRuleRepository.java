package br.com.api.salaohub.adapter.out.jpaRepository;

import br.com.api.salaohub.adapter.out.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ValidatingRuleRepository extends JpaRepository<ClientEntity, Long> {
    @Query("SELECT CASE WHEN (COUNT(r) > 0) THEN true ELSE false END FROM register_client r WHERE r.active = true")
    Boolean existsActiveClient();
}
