package br.com.api.cadastro_barbeiro.adapter.in;

import br.com.api.cadastro_barbeiro.application.DeleteProfessional;
import br.com.api.cadastro_barbeiro.application.RegisterProfessional;
import br.com.api.cadastro_barbeiro.application.UpdateProfessional;
import br.com.api.cadastro_barbeiro.shared.dto.ProfessionalDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PutMapping("/updateClient")
    public void updateClient(@RequestBody @Valid ProfessionalDTO professionalDTO) {
        log.info("updating professional in the database...");
        var update = updateProfessional.updateProfessional(professionalDTO);
        log.info("professional updated successfully Professional Name: {}, Professional Number: {}",update.nome(),update.telefone());
    }

    @DeleteMapping("/deleteClient")
    public ResponseEntity<Long> deleteClient(@RequestBody @Valid ProfessionalDTO professionalDTO) {
        log.info("deleting client in the database...");
        var delete = deleteProfessional.deleteProfessional(professionalDTO);
        log.info("client deleted successfully Client ID: {}, Client Name: {}",delete.id(),delete.nome());
        return ResponseEntity.ok(delete.id());
    }
}
