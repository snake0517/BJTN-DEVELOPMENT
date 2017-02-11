package edu.uca.aca2016.impulse.validation;

import edu.uca.aca2016.impulse.objects.Interactions;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
import java.util.regex.Pattern;

@Component
public class InteractionsValidator implements Validator {

    private static final Logger logger = Logger.getLogger(InteractionsValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Interactions.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "occurredOn", "interactions.occurredOn.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactPerson", "interactions.contactPerson.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactType", "interactions.contactType.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "notes", "interactions.notes.required");

        Interactions interactions = (Interactions) target;
        if (interactions.getOccurredOn().length() > 45) {
            errors.rejectValue("occurredOn", "interactions.occurredOn.length");
        }
        if (interactions.getOccurredOn().length() > 45) {
            errors.rejectValue("contactPerson", "interactions.contactPerson.length");
        }
        if (interactions.getOccurredOn().length() > 45) {
            errors.rejectValue("contactType", "interactions.contactType.length");
        }

        if (!interactions.getOccurredOn().matches("(/^(0[1-9]|1[0-2])\\/(0[1-9]|1\\d|2\\d|3[01])\\/(19|20)\\d{2}$/")) {
            errors.rejectValue("occurredOn", "interactions.occuredOn.pattern");
        }
    }
}
