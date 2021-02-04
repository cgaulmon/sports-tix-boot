package cdg.dev.sportstix.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdg.dev.sportstix.dto.UserDTO;
import cdg.dev.sportstix.security.domain.UserPrincipal;
import cdg.dev.sportstix.security.utility.JwtProvider;
import cdg.dev.sportstix.service.UserService;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "*")
public class UserController {
	public static final String JWT_TOKEN_HEADER = "Jwt-Token";
	private UserService userService;
	private JwtProvider jwtProvider;
	
	public UserController(UserService userService, JwtProvider jwtProivder) {
		super();
		this.userService = userService;
		this.jwtProvider = jwtProivder;
	}


	@PostMapping("/register")
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO requestBody) {
		return new ResponseEntity<>(userService.register(requestBody), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO requestBody) {
		UserPrincipal userPrincipal = userService.findUserPrincipalByUserId(requestBody.getUserId());
		UserDTO userDTO = new UserDTO(userPrincipal);
		HttpHeaders jwtHeader = createJwtHeader(userPrincipal);
		return new ResponseEntity<>(userDTO, jwtHeader, HttpStatus.OK);
	}


	private HttpHeaders createJwtHeader(UserPrincipal user) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(JWT_TOKEN_HEADER, jwtProvider.createJWT(user));
		return headers;
	}

}
