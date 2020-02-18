package nl.hypothermic.demo.api.test;

import nl.hypothermic.demo.api.model.Form;
import org.junit.Before;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.Assert.assertEquals;

public class RegistrationFormTest {

    private Validator validator;

    @Before
    public void setUp() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void shouldRejectDifferentPasswords() throws Exception {
        Form form = new Form("user@example.com", "password", "differentPass", true);

        assertEquals(1, validator.validate(form).size());
    }

    @Test
    public void shouldRejectCheckbox() throws Exception {
        Form form = new Form("user@example.com", "password", "password", false);

        assertEquals(1, validator.validate(form).size());
    }

    @Test
    public void shouldRejectEmail() throws Exception {
        Form form = new Form("user at example dot com", "password", "password", true);

        assertEquals(1, validator.validate(form).size());
    }

}
