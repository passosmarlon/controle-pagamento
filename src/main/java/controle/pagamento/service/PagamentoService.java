package controle.pagamento.service;

import controle.pagamento.dto.PagamentoDTO;
import controle.pagamento.entity.Fatura;
import controle.pagamento.entity.Pagamento;
import controle.pagamento.mapper.PagamentoMapper;
import controle.pagamento.repositories.FaturaRepository;
import controle.pagamento.repositories.PagamentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository repository;
    private final FaturaRepository faturaRepository;
    private final PagamentoMapper mapper;

    @Transactional
    public Pagamento savePagamento(PagamentoDTO data) {
        Fatura fatura = faturaRepository.findById(data.faturaId())
                .orElseThrow(() -> new RuntimeException("Fatura não encontrada"));
        Pagamento pagamento = mapper.toEntity(data);
        pagamento.setFatura(fatura);

        pagamento.setDataPagamento(LocalDate.now());

        DadosPagamento dadosPagamento = new DadosPagamento();

        dadosPagamento.calculaPagamento(pagamento);

        return repository.save(pagamento);

    }

    public List<PagamentoDTO> getPagamento(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    public void deletePagamento(Long id){
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id de pagamento não existe"));

        DadosPagamento dados = new DadosPagamento();

        dados.deletarPagamento(pagamento);

        repository.deleteById(id);
    }
}
