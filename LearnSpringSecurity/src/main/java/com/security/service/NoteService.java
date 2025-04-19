package com.security.service;

import java.util.List;

import com.security.model.Notes;

public interface NoteService {
	
	Notes createNoteForUser (String username,String content);
	Notes updateNoteForUser (Long noteId, String content, String username);
	void deleteNoteForUser (Long noteId, String username);
	List<Notes> getNoteForUser (String username);
	
	

}
