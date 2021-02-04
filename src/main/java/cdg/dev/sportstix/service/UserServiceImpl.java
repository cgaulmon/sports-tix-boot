package cdg.dev.sportstix.service;

import static cdg.dev.sportstix.enums.Role.ROLE_USER;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cdg.dev.sportstix.dto.UserDTO;
import cdg.dev.sportstix.entities.User;
import cdg.dev.sportstix.exception.EmailExistException;
import cdg.dev.sportstix.exception.EmailNotFoundException;
import cdg.dev.sportstix.exception.MessagingException;
import cdg.dev.sportstix.exception.UserNotFoundException;
import cdg.dev.sportstix.exception.UsernameExistException;
import cdg.dev.sportstix.repositories.UserRepository;
import cdg.dev.sportstix.security.domain.UserPrincipal;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService  {

	private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
	
    @Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
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
	
	private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

	@Override
	public UserPrincipal findUserPrincipalByUserId(String userId) {
		User user = findByUserId(userId);
		return new UserPrincipal(user);		
	}
	

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addNewUser(String firstName, String lastName, String username, String email, String role,
			boolean isNonLocked, boolean isActive, MultipartFile profileImage)
			throws UserNotFoundException, UsernameExistException, EmailExistException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername,
			String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage)
			throws UserNotFoundException, UsernameExistException, EmailExistException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String username) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPassword(String email) throws MessagingException, EmailNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
