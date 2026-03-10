package org.example.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@RequiredArgsConstructor
public class ExternalBookParser {

    private final BookRepository bookRepository;

    public void loadBooks(String query) throws Exception {
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + query;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new URL(url));
        JsonNode items = root.get("items");
        if (items == null) return;

        for (JsonNode item : items) {
            String title = item.get("volumeInfo").get("title").asText();

            Book b = new Book();
            b.setTitle(title);
            b.setAuthor(null); // можно не заполнять автора

            bookRepository.save(b);
        }
    }
}
