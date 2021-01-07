package cdg.dev.sportstix.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import cdg.dev.sportstix.entities.Event;
import lombok.Data;

@Data
public class EventDTO {
	
	private long id;
	private String name;
	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "US/Central")
	private Date startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "US/Central")
	private Date endDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a", timezone = "US/Central")
	private Date time;
	private long homeTeamId;
	private long awayTeamId;
	private long sportId;
	private long tickets;
	
	public EventDTO() {
		
	}

	public EventDTO(Event event) {
		this.id = event.getId();
		this.name = event.getName();
		this.description = event.getDescription();
		this.startDate = event.getStartDate();
		this.endDate = event.getEndDate();
		this.time = event.getTime();
		this.homeTeamId = event.getHomeTeamId();
		this.awayTeamId = event.getAwayTeamId();
		this.sportId = event.getSportId();
		this.tickets = event.getTickets();
	}

}
