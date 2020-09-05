package com.example.demo;

import com.example.MyConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
    /**
     * @Description: Error message display
     */
    String message() default "Please enter name of first tier city in China";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
