package com.example.HW16.repository;

import com.example.HW16.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
public class NoteRepositoryImpl {
    private final List<Note> notes = new ArrayList<>();

    public Note save(Note note) {
        if (Objects.isNull(note.getId())) {
            note.setId(new Random().nextLong());
            this.notes.add(note);
        } else {
            Optional<Note> optionalNote = this.notes.stream()
                    .filter(c -> c.getId().equals(note.getId()))
                    .findFirst();
            if (optionalNote.isPresent()) {
                this.notes.remove(optionalNote.get());
                this.notes.add(note);
            }
        }

        return note;
    }

    public Optional<Note> findById(Long id) {
        return this.notes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public List<Note> findAll() {
        return this.notes;
    }

    public void deleteById(Long id) {
        this.notes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .ifPresent(this.notes::remove);
    }

}
