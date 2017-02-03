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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "client.name.required");
        
        Client client = (Client)target;
		if(client.getFirstName().length() > 120) {
			errors.rejectValue("name","client.name.length");
		}
        
        if (!client.getFirstName().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("name","client.name.pattern");
        }
	}
}
