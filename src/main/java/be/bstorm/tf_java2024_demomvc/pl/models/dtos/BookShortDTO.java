package be.bstorm.tf_java2024_demomvc.pl.models.dtos;

import be.bstorm.tf_java2024_demomvc.domain.entities.Book;

public record BookShortDTO(
        Long id,
        String title,
        String author
) {

    public static BookShortDTO fromEntity(Book book){
        return new BookShortDTO(book.getId(), book.getTitle(), book.getAuthor());
    }
}
