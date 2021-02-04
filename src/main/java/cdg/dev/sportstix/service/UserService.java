package cdg.dev.sportstix.service;

import static cdg.dev.sportstix.enums.Role.ROLE_USER;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cdg.dev.sportstix.dto.UserDTO;
import cdg.dev.sportstix.entities.User;
import cdg.dev.sportstix.repositories.UserRepository;
import cdg.dev.sportstix.security.domain.UserPrincipal;

@Service
public class UserService implements UserDetailsService  {

	private UserRepository userRepository;
	private BCryptPasswordEncoder passwordEncoder;
	private AuthenticationManager authenticationManager;
	
	public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
	}

	public UserDTO register(UserDTO newUser) {
		User user = new User();
        user.setUserId(newUser.getUserId());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setJoinDate(new Date());
        user.setPassword(encodePassword(newUser.getPassword()));
        user.setRole(ROLE_USER.name());
        user.setAuthorities(ROLE_USER.getAuthorities());
		return new UserDTO(userRepository.save(user));
	}
	
	private String encodePassword(char[] password) {
		return passwordEncoder.encode(Arrays.toString(password));
	}


	public User findByUserId(String userId) {
		Optional<User> userOptional = userRepository.findByUserId(userId);
		if(userOptional.isPresent()) {
			return userOptional.get(); 
		} else {
			return new User();
		}
	}

	@Override
	public UserDetails loadUserByUsername(String userName) {
		return findUserPrincipalByUserId(userName);
		
	}

	public UserPrincipal findUserPrincipalByUserId(String userId) {
		User user = findByUserId(userId);
		return new UserPrincipal(user);		
	}
	
	private void authenticate(String userId, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
	}

}
