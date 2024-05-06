package be.bstorm.tf_java2024_demomvc.dal;

import be.bstorm.tf_java2024_demomvc.dal.repositories.BookRepository;
import be.bstorm.tf_java2024_demomvc.domain.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {

            List<Book> books = new ArrayList<>();

            books.add(new Book("To Kill a Mockingbird", "Harper Lee", "A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by virulent prejudice."));
            books.add(new Book("1984", "George Orwell", "1984 is a dystopian novel by George Orwell published in 1949. The story takes place in an imagined future, the year 1984, when much of the world has fallen victim to perpetual war, omnipresent government surveillance, historical negationism, and propaganda."));
            books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "The Great Gatsby, F. Scott Fitzgerald’s third book, stands as the supreme achievement of his career. This exemplary novel of the Jazz Age has been acclaimed by generations of readers. The story is of the fabulously wealthy Jay Gatsby and his new love for the beautiful Daisy Buchanan, of lavish parties on Long Island at a time when The New York Times noted “gin was the national drink and sex the national obsession,” it is an exquisitely crafted tale of America in the 1920s."));
            books.add(new Book("Pride and Prejudice", "Jane Austen", "Pride and Prejudice is a romantic novel of manners written by Jane Austen in 1813. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and eventually comes to appreciate the difference between superficial goodness and actual goodness."));
            books.add(new Book("To the Lighthouse", "Virginia Woolf", "To the Lighthouse is a 1927 novel by Virginia Woolf. The novel centres on the Ramsay family and their visits to the Isle of Skye in Scotland between 1910 and 1920."));

            for (Book book : books) {
                bookRepository.save(book);
            }
        }
    }
}
