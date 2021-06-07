package de.applicity.guestbook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Datenzugriffsschicht
//erster Parameter: zu verwaltende Klasse, zweiter Parameter: Typ des Primärschlüssels

public interface GuestbookRepository extends JpaRepository <GuestbookEntry, Long>{

	public List<GuestbookEntry> findAllByOrderByIdDesc ();
	
}
