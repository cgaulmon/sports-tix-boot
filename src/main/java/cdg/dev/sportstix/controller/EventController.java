package cdg.dev.sportstix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdg.dev.sportstix.dto.EventDTO;
import cdg.dev.sportstix.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

	private EventService eventService;
	
	
	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}


	@GetMapping("/name/{name}")
	public ResponseEntity<List<EventDTO>> findAllByName(@PathVariable String name) {
		return new ResponseEntity<>(eventService.findAllByName(name), HttpStatus.OK);
	}
}
