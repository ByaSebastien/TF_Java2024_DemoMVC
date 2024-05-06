package be.bstorm.tf_java2024_demomvc.dal.repositories;

import be.bstorm.tf_java2024_demomvc.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
