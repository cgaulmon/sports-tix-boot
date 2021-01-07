package cdg.dev.sportstix.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cdg.dev.sportstix.dto.UserDTO;
import cdg.dev.sportstix.entities.User;
import cdg.dev.sportstix.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService  {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public UserDTO findById(long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isPresent()) {
			return new UserDTO(userOptional.get());
		}
		
		return new UserDTO();
	}

	public UserDTO register(UserDTO newUser) {
		User user = new User();
		user.setEmail(newUser.getEmail());
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setPassword(newUser.getPassword().toString());
		return new UserDTO(userRepository.save(user));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
