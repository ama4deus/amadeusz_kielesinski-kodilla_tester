package com.kodilla.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty; // Dodaj ten import
import java.util.Objects;

public class BookDto {
    private String title;
    private String author;

    public BookDto() {
    }

    public BookDto(@JsonProperty("title") String title, @JsonProperty("author") String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(title, bookDto.title) &&
                Objects.equals(author, bookDto.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}