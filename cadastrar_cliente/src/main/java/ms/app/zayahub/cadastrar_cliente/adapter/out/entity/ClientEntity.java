package ms.app.zayahub.cadastrar_cliente.adapter.out.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ms.app.zayahub.cadastrar_cliente.shared.enums.Accessibility;

@Table(name = "register_client")
@Entity(name = "register_client")
@Data
@RequiredArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idClient;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private AddressEntity address;

    @Enumerated(EnumType.STRING)
    private Accessibility accessibility;
}