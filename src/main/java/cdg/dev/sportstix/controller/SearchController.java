package cdg.dev.sportstix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdg.dev.sportstix.service.SearchService;

@RestController
@RequestMapping("/api/search")
public class SearchController {

	private SearchService searchService;
	
	public SearchController(SearchService searchService) {
		super();
		this.searchService = searchService;
	}


	@PostMapping
	public ResponseEntity<Object> findResults(@RequestBody String searchText) {
		return new ResponseEntity<>(searchService.findBySearchText(searchText), HttpStatus.OK);
	}
}
