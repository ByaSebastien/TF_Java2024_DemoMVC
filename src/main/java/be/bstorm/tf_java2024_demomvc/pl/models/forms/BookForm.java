package be.bstorm.tf_java2024_demomvc.pl.models.forms;

import be.bstorm.tf_java2024_demomvc.domain.entities.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {

    @NotBlank(message = "Remplis le titre mon brave")
    @Size(min = 2, max = 100)
    private String title;
    @NotBlank
    @Size(min = 2, max = 100)
    private String author;
    @NotBlank
    @Size(min = 2, max = 500)
    private String description;

    public Book toEntity() {
        return new Book(title, author, description);
    }

    public static BookForm fromEntity(Book book) {
        return new BookForm(book.getTitle(),book.getAuthor(),book.getDescription());
    }
}
