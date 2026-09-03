package ms.app.zayahub.cadastrar_profissional.adapter.out.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "role", nullable = false)
    private String role;
    @Column(name = "active")
    private boolean active;
    @Column(name = "inicio_expediente")
    private Time startBusinessHours;
    @Column(name = "fim_expediente")
    private Time endWorkday;
    @Column(name = "atend_domicilio")
    private String homeService;
    @Column(name = "specialization")
    private String specialization;
}