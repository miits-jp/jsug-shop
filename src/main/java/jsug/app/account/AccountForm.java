package jsug.app.account;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import jsug.domain.validation.Confirm;
import jsug.domain.validation.UnusedEmail;
import lombok.Data;

@Data
@Confirm(field = "password")
public class AccountForm implements Serializable{
	@Email
	@Size(min = 1, max = 100)
	@NotNull
	@UnusedEmail
	private String email;
	
	@Size(min = 6)
	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;
	
	@Size(min = 1, max = 40)
	@NotNull
	private String name;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull
	private LocalDate birthDay;
	
	@Pattern(regexp = "[0-9]{7}")
	@NotNull
	private String zip;
	
	@Size(min = 1, max = 100)
	@NotNull
	private String address;
}
