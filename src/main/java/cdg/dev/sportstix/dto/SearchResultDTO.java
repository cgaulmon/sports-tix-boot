package cdg.dev.sportstix.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SearchResultDTO {
	private long id;
	private String eventName;
	private Date eventDate;
	private float price;
	private String location;
	
}
