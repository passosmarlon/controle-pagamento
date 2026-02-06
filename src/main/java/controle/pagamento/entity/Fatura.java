package controle.pagamento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    private BigDecimal valorTotal;
    private BigDecimal saldoDevedor;
    private BigDecimal valeCredito;
    @Enumerated(EnumType.STRING)
    private StatusFatura status;
    private Month mesReferencia;
    @OneToMany(mappedBy = "fatura")
    private List<Pagamento> historicoPagamento;
    @OneToMany(mappedBy = "fatura")
    private List<Devolucao> devolucao;
}
