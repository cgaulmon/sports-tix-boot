package cdg.dev.sportstix.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cdg.dev.sportstix.dto.EventDTO;
import cdg.dev.sportstix.entities.Event;
import cdg.dev.sportstix.exception.EventDoesNotExistException;
import cdg.dev.sportstix.repositories.EventRepository;

@Service
public class EventService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);
	private EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		super();
		this.eventRepository = eventRepository;
	}

	public EventDTO findById(long id) throws EventDoesNotExistException {
		Optional<Event> eventOptional = eventRepository.findById(id);
		if(eventOptional.isPresent()) {
			return new EventDTO(eventOptional.get());
		} else {
			throw new EventDoesNotExistException("No event found for id " + id);
		}
	}
	
	public List<EventDTO> findAllByName(String name) {
		LOGGER.info("Finding all event with name like {}", name);
		return eventRepository.findAllByNameLike(name).stream().map(EventDTO::new).collect(Collectors.toList());
	}
}
