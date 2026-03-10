package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final BookService bookService;

    @GetMapping("/books")
    public String booksPage(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}