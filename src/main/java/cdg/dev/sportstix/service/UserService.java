package cdg.dev.sportstix.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cdg.dev.sportstix.dto.UserDTO;
import cdg.dev.sportstix.entities.User;
import cdg.dev.sportstix.exception.EmailExistException;
import cdg.dev.sportstix.exception.EmailNotFoundException;
import cdg.dev.sportstix.exception.MessagingException;
import cdg.dev.sportstix.exception.UserNotFoundException;
import cdg.dev.sportstix.exception.UsernameExistException;
import cdg.dev.sportstix.security.domain.UserPrincipal;

public interface UserService {

    UserDTO register(UserDTO user) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;

    List<User> getUsers();

    User findUserByUsername(String username);
    
    UserPrincipal findUserPrincipalByUserId(String userId);

    User findUserByEmail(String email);

    User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;

    void deleteUser(String username) throws IOException;

    void resetPassword(String email) throws MessagingException, EmailNotFoundException;

  
}
