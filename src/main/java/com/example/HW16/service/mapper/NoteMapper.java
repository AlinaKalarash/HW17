package com.example.HW16.service.mapper;

import com.example.HW16.controller.request.CreateRequest;
import com.example.HW16.controller.request.UpdateRequest;
import com.example.HW16.controller.response.NoteResponse;
import com.example.HW16.data.entity.Note;
import com.example.HW16.service.dto.NoteDto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

//    FROM DTO TO NOTE
    public Note toNote(NoteDto dto) {
        Note entity = new Note();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        return entity;
    }
    public List<Note> toNotes(Collection<NoteDto> dtos) {
        return dtos.stream()
                .map(this::toNote)
                .collect(Collectors.toList());
    }

//    FROM NOTE TO DTO
    public NoteDto toNoteDto(Note entity) {
        NoteDto dto = new NoteDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        return dto;
    }
    public List<NoteDto> toNoteDtos(Collection<Note> entities) {
        return entities.stream()
                .map(this::toNoteDto)
                .collect(Collectors.toList());
    }

//    FROM DTO TO RESPONSE
    public NoteResponse toNoteResponse(NoteDto dto) {
        NoteResponse response = new NoteResponse();
        response.setId(dto.getId());
        response.setTitle(dto.getTitle());
        response.setContent(dto.getContent());
        return response;
    }
    public List<NoteResponse> toNoteResponses(Collection<NoteDto> dtos) {
        return dtos.stream()
                .map(this::toNoteResponse)
                .collect(Collectors.toList());
    }

//    FROM REQUEST TO DTO
    public NoteDto toNoteDto(CreateRequest request) {
        NoteDto dto = new NoteDto();
        dto.setTitle(request.getTitle());
        dto.setContent(request.getContent());
        return dto;
    }
    public NoteDto toNoteDto(Long id, UpdateRequest request) {
        NoteDto dto = new NoteDto();
        dto.setId(id);
        dto.setTitle(request.getTitle());
        dto.setContent(request.getContent());
        return dto;
    }
    public List<NoteDto> requestsToNoteDtos(Collection<CreateRequest> requests) {
        return requests.stream()
                .map(this::toNoteDto)
                .collect(Collectors.toList());
    }
}
