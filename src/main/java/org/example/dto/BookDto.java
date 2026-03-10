package org.example.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private Long authorId;
}
