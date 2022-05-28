package irlix.task.bank.annotation.payment;


import irlix.task.bank.annotation.payment.impl.AssertMoreImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AssertMoreImpl.class)
public @interface AssertMore {
    String message() default "Не может превышать баланс";
    float balance = 0;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
