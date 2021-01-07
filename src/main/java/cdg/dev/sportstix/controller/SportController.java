package cdg.dev.sportstix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdg.dev.sportstix.dto.SportDTO;
import cdg.dev.sportstix.service.SportService;

@RestController
@RequestMapping("/api/sports")
public class SportController {

	private SportService sportService;

	public SportController(SportService sportService) {
		super();
		this.sportService = sportService;
	}

	@GetMapping("")
	public String getGreeting() {
		return "Hello!";
	}

	@GetMapping("/list")
	public ResponseEntity<List<SportDTO>> findAll() {
		return new ResponseEntity<>(sportService.findAll(), HttpStatus.OK);
	}
}
