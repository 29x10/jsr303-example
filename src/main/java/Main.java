import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
        EmailDTO email = gson.fromJson("{\"email\":\"wrong email address\", \"user\": \"aa\", \"id\": \"wrong id\"}", EmailDTO.class);

        Validator validator;
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
            Set<ConstraintViolation<EmailDTO>> violations = validator.validate(email);
            if (!violations.isEmpty()) {
                System.out.println("invaid email");
                for (ConstraintViolation<EmailDTO> violation : violations) {
                    System.out.println(violation.getMessage()); 
                }
            }
        }
    }
}