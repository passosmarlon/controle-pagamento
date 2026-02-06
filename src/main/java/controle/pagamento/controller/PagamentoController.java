package controle.pagamento.controller;

import controle.pagamento.dto.PagamentoDTO;
import controle.pagamento.service.PagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamento")
@AllArgsConstructor
public class PagamentoController {

    private final PagamentoService service;

    @PostMapping
    public ResponseEntity<PagamentoDTO> save(@RequestBody PagamentoDTO data) {
        service.savePagamento(data);
        return ResponseEntity.ok(data);
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> get(){
        var get = service.getPagamento();
        return ResponseEntity.ok(get);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.deletePagamento(id);
        return ResponseEntity.notFound().build();
    }
}
