package com.example.HW16.controller.controller;

import com.example.HW16.data.entity.Note;
import com.example.HW16.service.dto.NoteDto;
import com.example.HW16.service.mapper.NoteMapper;
import com.example.HW16.service.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;
import java.util.UUID;
@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired private NoteService service;
    @Autowired private NoteMapper mapper;

    @PostMapping("/create")
    public ModelAndView createNote(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content) {
        NoteDto dto = new NoteDto();
        dto.setTitle(title);
        dto.setContent(content);
        service.add(dto);
        return listAllNotes();
    }

    @GetMapping("/list")
    public ModelAndView listAllNotes() {
        ModelAndView result = new ModelAndView("note/listAll");
        result.addObject("notes", mapper.toNoteResponses(service.listAll()));
        return result;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(
            @RequestParam(value = "id") Long id) throws HttpClientErrorException.NotFound {
        service.deleteById(id);
        return listAllNotes();
    }
    @GetMapping("/edit")
    public ModelAndView editById(@RequestParam(name = "id") long id) throws HttpClientErrorException.NotFound {
        return new ModelAndView("note/updatesNotes").addObject("note", service.getById(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content) {
        NoteDto dto = new NoteDto();
        dto.setId(id);
        dto.setTitle(title);
        dto.setContent(content);
        service.update(dto);
        return listAllNotes();
    }
}
