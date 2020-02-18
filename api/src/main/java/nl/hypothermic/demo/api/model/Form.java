package nl.hypothermic.demo.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import nl.hypothermic.demo.api.annotation.EqualPasswords;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EqualPasswords
public class Form {

    @NotNull
    @NotBlank(message = "You must enter your e-mail address.")
    @Email(message = "Invalid e-mail address format.")
    @Size(max = 320)
    public String email;

    @NotNull
    @NotBlank(message = "You must enter a new password.")
    @Size(min = 8, max = 256, message = "Password length must be between 8 and 256 characters.")
    public String password;

    @NotNull
    @NotBlank(message = "You must repeat your password.")
    @Size(min = 8, max = 256, message = "Password length must be between 8 and 256 characters.")
    public String repeated;

    @NotNull
    @AssertTrue(message = "You must be over 18 and you must accept the ToS to continue.")
    public Boolean accept;

}
