package br.com.zupacademy.ane.casadocodigo.validacao;
import br.com.zupacademy.ane.casadocodigo.cadastroaluno.AutorForm;
import br.com.zupacademy.ane.casadocodigo.cadastroaluno.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Validated
public class ErroFormValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    AutorRepository autorRepository;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormDto> handle(MethodArgumentNotValidException exception){
        List<ErroFormDto> formDto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e-> {
                String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
                ErroFormDto erro = new ErroFormDto(e.getField(), mensagem);
                formDto.add(erro);
                }
        );
        return formDto;
    }


}
