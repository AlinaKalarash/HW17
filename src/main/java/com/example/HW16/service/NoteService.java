package com.example.HW16.service;

import com.example.HW16.entity.Note;
import com.example.HW16.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
//    private List<Note> notes = new ArrayList<>();
    private final NoteRepository repository;


    public List<Note> listAll() {
        return repository.findAll();
    }

    public Note add(Note note) {
        return repository.save(note);
    }

    public void deleteById(Long id) {
        if (doesNoteExist(id)) {
            repository.delete(getById(id));
        } else {
            System.out.println("There's no note with that id");
        }
    }

    public boolean doesNoteExist(Long id) {
        return repository.existsById(id);
    }


    public void update(Note note) {
        Long id = note.getId();
        Note updateNote = getById(id);
        updateNote.setTitle(note.getTitle());
        updateNote.setContent(note.getContent());
        repository.save(updateNote);
    }

    public Note getById(Long id) {
        if (doesNoteExist(id)) {
            return repository.getById(id);
        } else {
            return new Note();
        }
    }

}
