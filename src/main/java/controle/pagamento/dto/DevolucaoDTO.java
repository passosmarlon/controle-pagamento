package controle.pagamento.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public record DevolucaoDTO(Long id, BigDecimal valorDevolucao, String descricao, Long faturaId, LocalDate dataDevolucao) {
}
