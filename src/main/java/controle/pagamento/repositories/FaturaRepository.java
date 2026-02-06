package controle.pagamento.repositories;

import controle.pagamento.entity.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Month;
import java.util.List;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {

    List<Fatura> findByClienteNomeContainingIgnoreCase(String nome);
    List<Fatura> findByMesReferencia(Month mes);
}
