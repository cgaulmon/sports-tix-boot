package cdg.dev.sportstix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cdg.dev.sportstix.dto.SportDTO;
import cdg.dev.sportstix.entities.Sport;
import cdg.dev.sportstix.repositories.SportRepository;

@Service
public class SportService {

	private SportRepository sportRepository;

	public SportService(SportRepository sportRepository) {
		super();
		this.sportRepository = sportRepository;
	}

	public List<SportDTO> findAll() {
		List<Sport> sports = sportRepository.findAll();

		return sports.stream().map(s -> new SportDTO(s)).collect(Collectors.toList());

	}

}
