package controle.pagamento.service;

import controle.pagamento.dto.DevolucaoDTO;
import controle.pagamento.entity.Devolucao;
import controle.pagamento.entity.Fatura;
import controle.pagamento.exceptions.IdInvalidoException;
import controle.pagamento.mapper.DevolucaoMapper;
import controle.pagamento.repositories.DevolucaoRepository;
import controle.pagamento.repositories.FaturaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DevolucaoService {

    private final DevolucaoRepository repository;
    private final DevolucaoMapper mapper;
    private final DadosDevolucao dados;
    private final FaturaRepository faturaRepository;

    @Transactional
    public Devolucao registerDevolucao(DevolucaoDTO data) {

        Fatura fatura = faturaRepository.findById(data.faturaId())
                .orElseThrow(IdInvalidoException::new);

        Devolucao devolucao = mapper.toEntity(data);
        devolucao.setFatura(fatura);

        dados.calcularDevolucao(devolucao, fatura);

        return repository.save(devolucao);
    }

    public List<DevolucaoDTO> getDevolucao(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
