package cdg.dev.sportstix.dto;

import org.springframework.security.core.userdetails.UserDetails;

import cdg.dev.sportstix.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

	private Long id;	
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private char[] password;
	
	public UserDTO(UserDetails user) {
		this.userId = user.getUsername();
		this.password = user.getPassword().toCharArray();
	}

	public UserDTO(User user) {
		this.userId = user.getUserId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.id = user.getId();
		this.password = user.getPassword().toCharArray();
	}
}
