package com.example.HW16.repository;

import com.example.HW16.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    public Optional<Note> findById(Long id);
}
