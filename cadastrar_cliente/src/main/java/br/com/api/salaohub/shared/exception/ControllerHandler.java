package br.com.api.salaohub.shared.exception;


import br.com.api.salaohub.shared.dto.ErrorDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLException;

@ControllerAdvice
@Slf4j
public class ControllerHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDTO> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        log.error("Entidade não encontrada: {}", ex.getMessage());
        return createErrorResponse("NOT_FOUND", ex.getMessage(), "Entity not found", HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDTO> handleNoResourceFoundException(NoResourceFoundException ex) {
        log.error("Recurso não encontrado: {}", ex.getMessage());
        return createErrorResponse("NOT_FOUND", ex.getMessage(), "Resource not found", HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var fiedErrors = ex.getFieldErrors();
        log.info("Validação falhou: {}", fiedErrors.toString());
        return ResponseEntity.badRequest().body(new ErrorDTO("BAD_REQUEST", "Validation failed", fiedErrors.toString(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("Erro inesperado: {}", ex.getMessage());
        return createErrorResponse("BAD_REQUEST", ex.getMessage(), "Invalid argument provided", HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleIllegalStateException(IllegalStateException ex) {
        log.error("Erro inesperado: {}", ex.getMessage());
        return createErrorResponse("BAD_REQUEST", ex.getMessage(), "Invalid state provided", HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDTO> handleSQLException(SQLException ex) {
        log.error("Erro na camada de serviço: {}", ex.getMessage());
        return createErrorResponse("Erro interno da aplicação", ex.getMessage(), "Database error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    private ResponseEntity<ErrorDTO> createErrorResponse(String code, String message, String reason, int statusCode) {;
        ErrorDTO errorDTO = new ErrorDTO(code, message, reason, statusCode);
        return ResponseEntity.status(statusCode).body(errorDTO);
    }
}
