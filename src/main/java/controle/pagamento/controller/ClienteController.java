package controle.pagamento.controller;

import controle.pagamento.dto.ClienteDTO;
import controle.pagamento.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO data) {
        service.saveCliente(data);
        return ResponseEntity.ok(data);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> get() {
        var get = service.getCliente();
        return ResponseEntity.ok(get);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO data) {
        service.updateCliente(data);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> delete(ClienteDTO data) {
        service.desativarCliente(data);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("ativo")
    public ResponseEntity<List<ClienteDTO>> getActive() {
        var get = service.getActive();
        return ResponseEntity.ok(get);
    }

    @GetMapping("nome")
    public ResponseEntity<List<ClienteDTO>> getName(String nome) {
        var get = service.getName(nome);
        return ResponseEntity.ok(get);
    }
}
