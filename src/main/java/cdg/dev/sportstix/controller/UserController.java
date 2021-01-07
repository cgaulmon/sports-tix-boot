package cdg.dev.sportstix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdg.dev.sportstix.dto.UserDTO;
import cdg.dev.sportstix.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}


	@PostMapping
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO requestBody) {
		return new ResponseEntity<>(userService.register(requestBody), HttpStatus.OK);
	}

}
