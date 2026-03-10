package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.parser.ExternalBookParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ParserController {

    private final ExternalBookParser parser;

    @GetMapping("/api/parse")
    public String parse(@RequestParam String q) throws Exception {
        parser.loadBooks(q);
        return "OK";
    }
}
