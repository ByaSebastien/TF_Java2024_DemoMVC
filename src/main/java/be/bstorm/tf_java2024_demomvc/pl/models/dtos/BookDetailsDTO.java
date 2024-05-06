package be.bstorm.tf_java2024_demomvc.pl.models.dtos;

import be.bstorm.tf_java2024_demomvc.domain.entities.Book;

public record BookDetailsDTO(
        Long id,
        String title,
        String author,
        String description
) {

    public static BookDetailsDTO fromEntity(Book book) {
        return new BookDetailsDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getDescription());
    }
}
