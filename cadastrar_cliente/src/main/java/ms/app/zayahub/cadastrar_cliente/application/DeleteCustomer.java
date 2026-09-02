package ms.app.zayahub.cadastrar_cliente.application;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_cliente.application.service.RegisterClientService;
import ms.app.zayahub.cadastrar_cliente.shared.dto.ClientDTO;

@Slf4j
@RequiredArgsConstructor
public class DeleteCustomer {

    private final RegisterClientService registerClientService;

    public ClientDTO deleteClient(ClientDTO clientDTO) {
        return registerClientService.deleteClient(clientDTO);
    }
}
