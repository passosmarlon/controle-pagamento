package controle.pagamento.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoDTO(Long id, BigDecimal valorPago,
                           LocalDate dataPagamento, String tipoPagamento,
                           Long faturaId) {
}
