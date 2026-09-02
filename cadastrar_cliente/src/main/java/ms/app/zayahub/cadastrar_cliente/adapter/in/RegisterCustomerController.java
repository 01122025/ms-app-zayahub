package ms.app.zayahub.cadastrar_cliente.adapter.in;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_cliente.application.DeleteCustomer;
import ms.app.zayahub.cadastrar_cliente.application.RegisterCustomer;
import ms.app.zayahub.cadastrar_cliente.application.UpdateCustomer;
import ms.app.zayahub.cadastrar_cliente.shared.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customers")
@RestController
@RequiredArgsConstructor
@Slf4j
public class RegisterCustomerController {

    private final RegisterCustomer registerCustomer;
    private final UpdateCustomer updateCustomer;
    private final DeleteCustomer deleteCustomer;


    @PostMapping("/registerCustomer")
    public ResponseEntity<ClientDTO> registerCustomer(
            @RequestHeader("Authorization") String auth,
            @RequestBody @Valid ClientDTO clientDTO) {
        log.info("registering client in the database...");
        var result = registerCustomer.registerCustomer(clientDTO);
        log.info("client registered successfully Client Name: {}, Client Number: {}",clientDTO.name(),clientDTO.phone());
        return ResponseEntity.ok(result);
    }

    @PutMapping("/updateClient")
    public void updateClient(@RequestBody @Valid ClientDTO clientDTO) {
        log.info("updating client in the database...");
        var update = updateCustomer.updateClient(clientDTO);
        log.info("client updated successfully Client Name: {}, Client Number: {}",update.name(),update.phone());
    }

    @DeleteMapping("/deleteClient")
    public ResponseEntity<Long> deleteClient(@RequestBody @Valid ClientDTO clientDTO) {
        log.info("deleting client in the database...");
        var delete = deleteCustomer.deleteClient(clientDTO);
        log.info("client deleted successfully Client ID: {}, Client Name: {}, ",delete.idClient(),delete.name());
        return ResponseEntity.ok(delete.idClient());
    }

}
