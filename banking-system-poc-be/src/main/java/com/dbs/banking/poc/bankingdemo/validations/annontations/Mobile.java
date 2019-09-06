package com.dbs.banking.poc.bankingdemo.validations.annontations;


import com.dbs.banking.poc.bankingdemo.validations.validators.EmailValidator;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Mobile {

    String message() default "Invalid mobile number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
