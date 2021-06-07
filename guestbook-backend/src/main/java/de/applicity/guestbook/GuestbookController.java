package de.applicity.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("/guestbook")
@CrossOrigin(origins="*")
public class GuestbookController {
	
	
	@Autowired
	private GuestbookRepository repository;
	
	@RequestMapping(value="/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> getEntries(){
		
		//1. Daten laden
		
		List<GuestbookEntry> entries = repository.findAllByOrderByIdDesc();
		
		
		//2. Daten zurückgeben
		
		return ResponseEntity.ok(entries);
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createEntry (@RequestBody GuestbookEntry entry){
	
		//1. Daten speichern
		
		entry = repository.save(entry);
		
		//2. Daten zurückgeben
		return ResponseEntity.ok(entry);
		
	}
	

}
