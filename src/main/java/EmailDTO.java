import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

public @Data class EmailDTO {
    @NotNull(message = "user cannot be null")
    @Size(min = 3, max = 10, message = "user string length can only between 3 and 10")
    private String user;
    
    @NotNull(message = "email cannot be be null")
    @Email(message = "email field need to be a valid email address")
    private String email;
    
    @NotNull(message = "id cannot be null")
    @Pattern(regexp = "\\d+", message = "user can only contain numbers")
    private String id;
}