package edu.uca.aca2016.impulse.validation;

import edu.uca.aca2016.impulse.objects.Client;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
import java.util.regex.Pattern;

@Component
public class ClientValidator implements Validator {

    private static final Logger logger = Logger.getLogger(ClientValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "client.firstName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "client.lastName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "client.address1.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "client.city.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "client.state.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "client.zip.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "client.email.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "client.phone.required");

        Client client = (Client) target;
        if (client.getFirstName().length() > 45) {
            errors.rejectValue("firstName", "client.firstName.length");
        }
        if (client.getLastName().length() > 45) {
            errors.rejectValue("lastName", "client.lastName.length");
        }
        if (client.getAddress1().length() > 128) {
            errors.rejectValue("address1", "client.address1.length");
        }
        if (client.getAddress2().length() > 128) {
            errors.rejectValue("address2", "client.address1.length");
        }
        if (client.getCity().length() > 45) {
            errors.rejectValue("city", "client.city.length");
        }
        if (client.getState().length() > 45) {
            errors.rejectValue("state", "client.state.length");
        }
        if (client.getZip().length() > 45) {
            errors.rejectValue("zip", "client.zip.length");
        }
        if (client.getEmail().length() > 45) {
            errors.rejectValue("email", "client.email.length");
        }
        if (client.getPhone().length() > 30) {
            errors.rejectValue("phone", "client.phone.length");
        }
        if (!client.getFirstName().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("firstName", "client.firstName.pattern");
        }
        if (!client.getLastName().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("lastName", "client.lastName.pattern");
        }
        if (client.getCity().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("city", "client.city.pattern");
        }
        if (!client.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            errors.rejectValue("email", "client.email.pattern");
        }
    }

}
