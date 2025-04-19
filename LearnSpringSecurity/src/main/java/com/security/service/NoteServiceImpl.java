package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.model.Notes;
import com.security.repositories.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	NoteRepository noteRepository;

	@Override
	public Notes createNoteForUser(String username, String content) {
		Notes notes = new Notes();
		notes.setContent(content);
		notes.setOwnerUsername(username);
		Notes savedNotes = noteRepository.save(notes);
		
		// TODO Auto-generated method stub
		return savedNotes;
	}

	@Override
	public Notes updateNoteForUser(Long noteId, String content, String username) {
		
		// TODO Auto-generated method stub
		
		Notes notes = noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note Not Found"));
		notes.setContent(content);
		Notes updatedNote = noteRepository.save(notes);
		return updatedNote;
	}

	@Override
	public void deleteNoteForUser(Long noteId, String username) {
		// TODO Auto-generated method stub
		noteRepository.deleteById(noteId);
		
	}

	@Override
	public List<Notes> getNoteForUser(String username) {
		List<Notes> byOwnerUsername = noteRepository.findByOwnerUsername(username);
		// TODO Auto-generated method stub
		return byOwnerUsername;
	}

}
