package controle.pagamento.dto;

import controle.pagamento.entity.Devolucao;
import controle.pagamento.entity.StatusFatura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public record FaturaDTO(Long id, Long clienteId, String nomeCliente, BigDecimal valorTotal,
                        BigDecimal saldoDevedor, BigDecimal valeCredito, StatusFatura status,
                        Month mesReferencia, List<PagamentoDTO> pagamentos,
                        List<DevolucaoDTO> devolucao) {
}
