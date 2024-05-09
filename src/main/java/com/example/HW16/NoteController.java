package com.example.HW16;

import com.example.HW16.entity.Note;
import com.example.HW16.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@RequestMapping("/note")
@RequiredArgsConstructor
@RestController
public class NoteController {
    private final NoteService service;

    @PostMapping("/create")
    public ModelAndView createNote(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content) {
        Note note = new Note();
        note.setId(new Random().nextLong());
        note.setTitle(title);
        note.setContent(content);
        service.add(note);
        return listAllNotes();
    }

    @GetMapping("/list")
    public ModelAndView listAllNotes() {
        ModelAndView resul = new ModelAndView("note/listAll");
        resul.addObject("notes", service.listAll());
        return resul;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(
            @RequestParam(value = "id") Long id) throws HttpClientErrorException.NotFound {
        service.deleteById(id);
        return listAllNotes();
    }

    @GetMapping("/edit")
    public ModelAndView editById(@RequestParam(name = "id") Long id) throws HttpClientErrorException.NotFound {
        return new ModelAndView("note/updatesNotes").addObject("note", service.getById(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        service.update(note);
        return listAllNotes();
    }
}
