package edu.uca.aca2016.impulse.validation;

import edu.uca.aca2016.impulse.objects.Users;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
import java.util.regex.Pattern;

@Component
public class UsersValidator implements Validator {

    private static final Logger logger = Logger.getLogger(UsersValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "users.name.required");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "users.username.required");

        Users users = (Users) target;
        if (users.getName().length() > 120) {
            errors.rejectValue("name", "users.name.length");
        }
if (users.getUsername().length() > 120) {
            errors.rejectValue("username", "users.username.length");
        }
        if (!users.getName().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("name", "users.name.pattern");
        }
        if (!users.getUsername().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("username", "users.username.pattern");
        }
    }
}
