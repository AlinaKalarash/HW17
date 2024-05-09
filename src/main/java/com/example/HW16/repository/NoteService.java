package com.example.HW16.repository;

import com.example.HW16.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository repository;

    public Note saveNote(Note note) {
        return repository.save(note);
    }

    public Note getNoteById(Long id) {
        if (doesNoteExist(id)) {
            return repository.getById(id);
        } else {
            return new Note();
        }
    }

    public Iterable<Note> findAllNotes() {
        return repository.findAll();
    }

    public void deleteNote(Note note) {
        if (doesNoteExist(note.getId())) {
            repository.delete(note);
        } else {
            System.out.println("There's no note with that id");
        }
    }

    public boolean doesNoteExist(Long id) {
        return repository.existsById(id);
    }
}
