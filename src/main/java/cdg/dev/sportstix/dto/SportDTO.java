package cdg.dev.sportstix.dto;

import cdg.dev.sportstix.entities.Sport;
import lombok.Data;

@Data
public class SportDTO {

	private long id;
	private String name;
	private String description;
	
	public SportDTO() {
	
	}
	
	public SportDTO(Sport sport) {
		this.id = sport.getId();
		this.name = sport.getName();
		this.description = sport.getDescription();
	}
}
