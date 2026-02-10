package controle.pagamento.exceptions;

public class PagamentoInvalidoException extends RuntimeException {

    public PagamentoInvalidoException() {
        super("O pagamento informado não pode ser nullo");
    }

    public PagamentoInvalidoException(String message) {
        super(message);
    }
}
