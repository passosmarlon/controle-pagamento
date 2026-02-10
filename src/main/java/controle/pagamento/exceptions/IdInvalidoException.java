package controle.pagamento.exceptions;

public class IdInvalidoException extends RuntimeException{

    public IdInvalidoException() {
        super("Id não encontrado");
    }

    public IdInvalidoException(String message){
        super(message);
    }
}
