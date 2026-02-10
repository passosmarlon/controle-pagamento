package controle.pagamento.exceptions;

public class PagamentoNegativoException extends RuntimeException{

    public PagamentoNegativoException() {
        super("O pagamento não pode ser negativo");
    }

    public PagamentoNegativoException(String message) {
        super(message);
    }
}
