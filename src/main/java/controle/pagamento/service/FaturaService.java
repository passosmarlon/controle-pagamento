package controle.pagamento.service;

import controle.pagamento.dto.FaturaDTO;
import controle.pagamento.entity.Cliente;
import controle.pagamento.entity.Fatura;
import controle.pagamento.entity.Pagamento;
import controle.pagamento.entity.StatusFatura;
import controle.pagamento.exceptions.IdInvalidoException;
import controle.pagamento.mapper.FaturaMapper;
import controle.pagamento.mapper.FaturaUpdate;
import controle.pagamento.repositories.ClienteRepository;
import controle.pagamento.repositories.FaturaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FaturaService {

    private final FaturaRepository repository;
    private final FaturaMapper mapper;
    private final FaturaUpdate mapperUpdate;
    private final ClienteRepository clienteRepository;

    public Fatura saveFatura(FaturaDTO data) {
        Cliente cliente = clienteRepository.findById(data.clienteId())
                .orElseThrow(IdInvalidoException::new);
        Fatura fatura = mapper.toEntity(data);
        fatura.setCliente(cliente);

        fatura.setSaldoDevedor(fatura.getValorTotal());
        fatura.setStatus(StatusFatura.EM_ABERTO);
        fatura.setMesReferencia(Month.from(LocalDate.now().getMonth()));
        fatura.setValeCredito(BigDecimal.ZERO);

        return repository.save(fatura);
    }

    public List<FaturaDTO> getFatura() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<FaturaDTO> getFaturaCliente(String nome) {
        return repository.findByClienteNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<FaturaDTO> getFaturaMes(Month mes) {
        return repository.findByMesReferencia(mes)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    public Fatura updateFatura(FaturaDTO data) {
        Fatura fatura = repository.findById(data.id())
                .orElseThrow(IdInvalidoException::new);

        mapperUpdate.updateFatura(data, fatura);
        return repository.save(fatura);
    }
}
