package controle.pagamento.service;

import controle.pagamento.entity.Devolucao;
import controle.pagamento.entity.Fatura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@RequiredArgsConstructor
@Service
public class DadosDevolucao {


    public void calcularDevolucao(Devolucao devolucao, Fatura fatura) {

        devolucao.setDataDevolucao(LocalDate.now());


        BigDecimal valorDevolucao = devolucao.getValorDevolucao();
        BigDecimal valorTotal = fatura.getValorTotal();
        BigDecimal saldoDevedor = fatura.getSaldoDevedor();

        fatura.setValorTotal(valorTotal.subtract(valorDevolucao));
        fatura.setSaldoDevedor(saldoDevedor.subtract(valorDevolucao));

        if (fatura.getSaldoDevedor().compareTo(BigDecimal.ZERO) <= 0) {
            var getValor = fatura.getSaldoDevedor().abs();
            fatura.setValeCredito(fatura.getValeCredito().add(getValor));
            fatura.setSaldoDevedor(BigDecimal.ZERO);
        }

    }
}
