package controle.pagamento.repositories;

import controle.pagamento.dto.ClienteDTO;
import controle.pagamento.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByActiveTrue();
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
