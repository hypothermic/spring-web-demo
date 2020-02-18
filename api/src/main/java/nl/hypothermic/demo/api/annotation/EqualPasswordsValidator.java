package nl.hypothermic.demo.api.annotation;

import nl.hypothermic.demo.api.model.Form;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualPasswordsValidator implements ConstraintValidator<EqualPasswords, Form> {

    @Override
    public void initialize(EqualPasswords constraint) {

    }

    @Override
    public boolean isValid(Form form, ConstraintValidatorContext context) {
        return form.getPassword().equals(form.getRepeated());
    }
}