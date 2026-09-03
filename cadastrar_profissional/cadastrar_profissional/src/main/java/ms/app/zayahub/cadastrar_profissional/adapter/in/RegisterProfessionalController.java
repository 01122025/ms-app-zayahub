package ms.app.zayahub.cadastrar_profissional.adapter.in;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.application.DeleteProfessional;
import ms.app.zayahub.cadastrar_profissional.application.GetListProfessional;
import ms.app.zayahub.cadastrar_profissional.application.RegisterProfessional;
import ms.app.zayahub.cadastrar_profissional.application.UpdateProfessional;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registerProfessional")
@RequiredArgsConstructor
@Slf4j
public class RegisterProfessionalController {

    private final GetListProfessional listAllProfessionals;
    private final RegisterProfessional registerProfessional;
    private final UpdateProfessional updateProfessional;
    private final DeleteProfessional deleteProfessional;

    @GetMapping("/listAllProfessionals")
    public ResponseEntity<List<ProfessionalDTO>>getAllProfessionals(){
        log.info("Listing all professionals in the database - request received");
        var request = listAllProfessionals.listProfessionals();
        log.info("Listing all professionals in the database - response : {}", request.toString());
        return ResponseEntity.ok(request);
    }

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
        log.info("professional updated successfully Professional Name: {}, Professional Number: {}",update.name(),update.phone());
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/deleteProfessional")
    public ResponseEntity<Long> deleteClient(@RequestBody @Valid ProfessionalDTO professionalDTO) {
        log.info("deleting client in the database...");
        var delete = deleteProfessional.deleteProfessional(professionalDTO);
        log.info("client deleted successfully Client ID: {}, Client Name: {}",delete.id_professional(),delete.name());
        return ResponseEntity.ok().body(delete.id_professional());
    }

}
