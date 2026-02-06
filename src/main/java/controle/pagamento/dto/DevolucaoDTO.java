package controle.pagamento.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DevolucaoDTO(Long id, BigDecimal valorDevolucao, String descricao, Long faturaId, LocalDate dataDevolucao) {
}
