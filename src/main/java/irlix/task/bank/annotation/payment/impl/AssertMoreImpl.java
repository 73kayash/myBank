package irlix.task.bank.annotation.payment.impl;

import irlix.task.bank.annotation.payment.AssertMore;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AssertMoreImpl implements ConstraintValidator<AssertMore, Float> {
    @Override
    public void initialize(AssertMore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Float sum, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
