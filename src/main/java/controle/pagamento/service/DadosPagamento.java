package controle.pagamento.service;

import controle.pagamento.entity.Pagamento;
import controle.pagamento.entity.StatusFatura;
import controle.pagamento.exceptions.PagamentoInvalidoException;
import controle.pagamento.exceptions.PagamentoNegativoException;
import controle.pagamento.repositories.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DadosPagamento {


    public void calculaPagamento(Pagamento data) {

        BigDecimal getSaldo = data.getFatura().getSaldoDevedor();
        BigDecimal getPagamento = data.getValorPago();
        BigDecimal credito = data.getFatura().getValeCredito();

        if (getPagamento == null || getSaldo == null) {
            throw new PagamentoInvalidoException();
        } else if (getPagamento.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PagamentoNegativoException();
        }

        if (getSaldo.compareTo(BigDecimal.ZERO) > 0) {
            if (getPagamento.compareTo(getSaldo) >= 0) {
                BigDecimal sobra = getPagamento.subtract(getSaldo);

                data.getFatura().setSaldoDevedor(BigDecimal.ZERO);
                data.getFatura().setValeCredito(credito.add(sobra));
                data.getFatura().setStatus(StatusFatura.PAGO);
            } else {
                data.getFatura().setSaldoDevedor(getSaldo.subtract(getPagamento));
            }


        } else {
            data.getFatura().setValeCredito(credito.add(getPagamento));
        }
    }

    public void deletarPagamento(Pagamento pagamento){

        BigDecimal valorTotal = pagamento.getFatura().getSaldoDevedor();
        BigDecimal valor = pagamento.getValorPago();
        BigDecimal valeCredito = pagamento.getFatura().getValeCredito();

        //BigDecimal newValor = valorTotal.add(valor);

        if (valeCredito.compareTo(valor) > 0){
            pagamento.getFatura().setValeCredito(pagamento.
                    getFatura().
                    getValeCredito().
                    subtract(valor));

        } else {
            BigDecimal newValor = valorTotal.add(valor.subtract(valeCredito));

            pagamento.getFatura().setSaldoDevedor(newValor);

            pagamento.getFatura().setValeCredito(BigDecimal.ZERO);
        }
    }
}
