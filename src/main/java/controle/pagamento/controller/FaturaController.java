package controle.pagamento.controller;

import controle.pagamento.dto.FaturaDTO;
import controle.pagamento.service.FaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("fatura")
public class FaturaController {

    private final FaturaService service;

    @PostMapping
    public ResponseEntity<FaturaDTO> save(@RequestBody FaturaDTO data) {
        service.saveFatura(data);
        return ResponseEntity.ok(data);
    }

    @GetMapping
    public ResponseEntity<List<FaturaDTO>> get (){
        var get = service.getFatura();
        return ResponseEntity.ok(get);
    }

    @GetMapping("cliente")
    public ResponseEntity<List<FaturaDTO>> getNomeCliente(String nome) {
        var get = service.getFaturaCliente(nome);
        return ResponseEntity.ok(get);
    }

    @GetMapping("mes")
    public ResponseEntity<List<FaturaDTO>> getMes(Month mes) {
        var get = service.getFaturaMes(mes);
        return ResponseEntity.ok(get);
    }

    @PutMapping
    public ResponseEntity<FaturaDTO> update(@RequestBody FaturaDTO data){
        service.updateFatura(data);
        return ResponseEntity.ok(data);
    }
}
