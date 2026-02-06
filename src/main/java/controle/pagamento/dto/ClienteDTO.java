package controle.pagamento.dto;

import jakarta.validation.constraints.NotNull;

public record ClienteDTO(Long id, String nome, String telefone, String email, Boolean active) {
}
