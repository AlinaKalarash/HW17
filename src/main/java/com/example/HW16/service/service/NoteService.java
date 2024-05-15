package com.example.HW16.service.service;

import com.example.HW16.service.dto.NoteDto;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface NoteService {

    List<NoteDto> listAll();

    NoteDto add(NoteDto dto);

    void deleteById(Long id);

    void update(NoteDto dto);

    NoteDto getById(Long id);


}
