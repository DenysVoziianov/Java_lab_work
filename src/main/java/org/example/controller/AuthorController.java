package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Author;
import org.example.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> all() {
        return authorService.findAll();
    }

    @PostMapping
    public Author create(@RequestParam("name") String name) {
        return authorService.create(name);
    }
}
