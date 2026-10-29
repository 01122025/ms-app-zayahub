package br.com.api.salaohub.adapter.out.entity;

import br.com.api.salaohub.shared.enums.Accessibility;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
    @Column(name = "active")
    private boolean active;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private AddressEntity address;

    @Enumerated(EnumType.STRING)
    private Accessibility accessibility;
}