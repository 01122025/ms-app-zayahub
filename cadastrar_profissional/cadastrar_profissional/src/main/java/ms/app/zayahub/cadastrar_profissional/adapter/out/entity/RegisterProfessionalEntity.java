package ms.app.zayahub.cadastrar_profissional.adapter.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;


@Table(name = "register_professional")
@Entity(name = "register_professional")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterProfessionalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id_professional;
    @Column(name = "name", nullable = false, unique = true)
    private String nome;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "role", nullable = false, unique = true)
    private String role;

    @Column(name = "inicio_expediente", nullable = false, unique = true)
    private Time inicioExpediente;
    @Column(name = "fim_expediente", nullable = false, unique = true)
    private Time fimExpediente;
    @Column(name = "atend_domicilio", nullable = false, unique = true)
    private String atendDomicilio;

    @Column(name = "specialization", nullable = false, unique = true)
    private String Specialization;
}