package br.com.apssystem.scfapssystem.domain.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {CpfCnpjFaker.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface ValidationCpfCnpj {

   String message() default "CPF/CNPJ inválido";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}
