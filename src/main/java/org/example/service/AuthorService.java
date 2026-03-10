package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Author;
import org.example.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author create(String name) {
        Author a = new Author();
        a.setName(name);
        return authorRepository.save(a);
    }
}
