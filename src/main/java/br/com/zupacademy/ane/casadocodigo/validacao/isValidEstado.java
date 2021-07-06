package br.com.zupacademy.ane.casadocodigo.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = isValidEstadoValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface isValidEstado {

    String message() default "{ O valor submetido não obedece às regras definidas }";
    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    Class<?> domainClass();

    String fieldName();
}
