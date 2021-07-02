package br.com.zupacademy.ane.casadocodigo.validacao;

import br.com.zupacademy.ane.casadocodigo.cadastrocategoria.Categoria;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ValorUnicoValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValorUnico {

    String message() default "Valor inválido. Este campo não deve receber valor duplicado";
    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    Class<?> domainClass();

    String fieldName();
}
