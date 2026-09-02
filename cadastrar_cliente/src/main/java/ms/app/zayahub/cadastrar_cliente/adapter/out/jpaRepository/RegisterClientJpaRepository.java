package ms.app.zayahub.cadastrar_cliente.adapter.out.jpaRepository;


import ms.app.zayahub.cadastrar_cliente.adapter.out.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegisterClientJpaRepository extends JpaRepository<ClientEntity, Long> {

}
