package ms.app.zayahub.cadastrar_profissional.adapter.in;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.application.DeleteProfessional;
import ms.app.zayahub.cadastrar_profissional.application.RegisterProfessional;
import ms.app.zayahub.cadastrar_profissional.application.UpdateProfessional;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registerProfessional")
@RequiredArgsConstructor
@Slf4j
public class RegisterProfessionalController {

    private final RegisterProfessional registerProfessional;
    private final UpdateProfessional updateProfessional;
    private final DeleteProfessional deleteProfessional;


    @PostMapping("/registeringProfessional")
    public ResponseEntity<ProfessionalDTO> registerProfessional(
            @RequestHeader("Authorization") String authorization,
            @RequestBody @Valid ProfessionalDTO professionalDTO) {
        log.info("Register Professional  -  request received : {}", professionalDTO);
        var request = registerProfessional.registerProfessional(professionalDTO);
        log.info("Register Professional  -  response : {}", request.toString());
        return ResponseEntity.ok().body(request);
    }

    @PutMapping("/updateProfessional")
    public ResponseEntity<ProfessionalDTO> updateClient(@RequestBody @Valid ProfessionalDTO professionalDTO) {
        log.info("updating professional in the database...");
        var update = updateProfessional.updateProfessional(professionalDTO);
        log.info("professional updated successfully Professional Name: {}, Professional Number: {}",update.nome(),update.phone());
        return ResponseEntity.ok().body(update);
    }

}
