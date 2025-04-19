package com.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Notes;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long> {
	
	List<Notes> findByOwnerUsername(String ownserUsername);

}
