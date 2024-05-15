package com.example.HW16.service.service;

import com.example.HW16.data.entity.Note;
import com.example.HW16.data.repository.NoteRepository;
import com.example.HW16.service.dto.NoteDto;
import com.example.HW16.service.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired private NoteRepository repository;
    @Autowired private NoteMapper mapper;

    @Override
    public List<NoteDto> listAll() {
        return mapper.toNoteDtos(repository.findAll());
    }

    @Override
    public NoteDto add(NoteDto dto) {
        Note note = mapper.toNote(dto);
        return mapper.toNoteDto(repository.save(note));
    }

    @Override
    public void deleteById(Long id) {
        NoteDto dto = getById(id);
        repository.deleteById(id);
    }

    @Override
    public void update(NoteDto dto) {
        getById(dto.getId());
        repository.save(mapper.toNote(dto));
    }

    @Override
    public NoteDto getById(Long id) {
        Optional<Note> note = repository.findById(id);
        return mapper.toNoteDto(note.get());
    }

}
