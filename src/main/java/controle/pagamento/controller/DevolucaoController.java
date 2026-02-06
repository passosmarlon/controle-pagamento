package controle.pagamento.controller;

import controle.pagamento.dto.DevolucaoDTO;
import controle.pagamento.service.DevolucaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("devolucao")
public class DevolucaoController {

    private final DevolucaoService service;

    @PostMapping
    public ResponseEntity<DevolucaoDTO> registerDevolucao(@RequestBody DevolucaoDTO data) {
        service.registerDevolucao(data);
        return ResponseEntity.ok(data);
    }

    @GetMapping
    public ResponseEntity<List<DevolucaoDTO>> get(){
        var get = service.getDevolucao();
        return ResponseEntity.ok(get);
    }
}
