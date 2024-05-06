package be.bstorm.tf_java2024_demomvc.bll.services;

import be.bstorm.tf_java2024_demomvc.domain.entities.Book;

import java.util.List;

public interface BookService {

    void createBook(Book book);
    void updateBook(Long id, Book book);
    void deleteBook(Long id);
    List<Book> findAllBooks();
    Book findBookById(Long id);
}
