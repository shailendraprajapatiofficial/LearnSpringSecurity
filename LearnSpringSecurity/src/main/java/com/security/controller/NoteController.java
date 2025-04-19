package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Notes;
import com.security.service.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@PostMapping
	public Notes createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {

		String username = userDetails.getUsername();
		System.out.println("user Deatils: " + username);
		return noteService.createNoteForUser(username, content);

	}

	@GetMapping
	public List<Notes> getUserNotes(@AuthenticationPrincipal UserDetails userDetails) {
		String username = userDetails.getUsername();
		System.out.println("user Deatils: " + username);
		return noteService.getNoteForUser(username);

	}

	@PutMapping("/{noteId}")
	public Notes updateNote(@PathVariable Long noteId, @RequestBody String content,
			@AuthenticationPrincipal UserDetails userDetails) {

		String username = userDetails.getUsername();
		System.out.println("user Deatils: " + username);
		Notes updateNoteForUser = noteService.updateNoteForUser(noteId, content, username);
		return updateNoteForUser;

	}

	@DeleteMapping("/{noteId}")
	public void deleteNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails) {
		String username = userDetails.getUsername();
		System.out.println("user Deatils: " + username);
		noteService.deleteNoteForUser(noteId, username);
	}
}
