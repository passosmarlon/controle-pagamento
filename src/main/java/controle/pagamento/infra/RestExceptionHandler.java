package controle.pagamento.infra;

import controle.pagamento.exceptions.IdInvalidoException;
import controle.pagamento.exceptions.PagamentoInvalidoException;
import controle.pagamento.exceptions.PagamentoNegativoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PagamentoNegativoException.class)
    private ResponseEntity<String> pagamentoNegativoHandler(PagamentoNegativoException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Valor do Pagamento negativo");
    }

    @ExceptionHandler(PagamentoInvalidoException.class)
    private ResponseEntity<String> pagamentoInvalidoHandler(PagamentoInvalidoException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Valor do Pagamento nulo");
    }

    @ExceptionHandler(IdInvalidoException.class)
    private ResponseEntity<String> idInvalidoHandler(IdInvalidoException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
    }
}
