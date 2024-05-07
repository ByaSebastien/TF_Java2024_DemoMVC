package be.bstorm.tf_java2024_demomvc.pl.controllers;

import be.bstorm.tf_java2024_demomvc.bll.services.BookService;
import be.bstorm.tf_java2024_demomvc.domain.entities.Book;
import be.bstorm.tf_java2024_demomvc.pl.models.dtos.BookDetailsDTO;
import be.bstorm.tf_java2024_demomvc.pl.models.dtos.BookShortDTO;
import be.bstorm.tf_java2024_demomvc.pl.models.forms.BookForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<BookShortDTO> books = bookService.findAllBooks().stream()
                .sorted(Comparator.comparing(Book::getId))
                .map(BookShortDTO::fromEntity)
                .toList();
        model.addAttribute("books",books);
        return "book/list";
    }

    @GetMapping("/{id:^[0-9]+$}")
    public String getBookById(@PathVariable Long id, Model model) {
        BookDetailsDTO dto = BookDetailsDTO.fromEntity(bookService.findBookById(id));
        model.addAttribute("book",dto);
        return "book/details";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        model.addAttribute("form", new BookForm());
        return "book/create";
    }

    @PostMapping("/create")
    public String createBook(
            @ModelAttribute("form") @Valid BookForm form,
            BindingResult bindingResult,
            Model model
    ) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("form",form);
            return "book/create";
        }
        bookService.createBook(form.toEntity());
        return "redirect:/book";
    }

    @GetMapping("/update/{id:^[0-9]+$}")
    public String updateBook(@PathVariable Long id, Model model) {
        BookForm form = BookForm.fromEntity(bookService.findBookById(id));
        model.addAttribute("form",form);
        model.addAttribute("currentBookId",id);
        return "book/update";
    }

    @PostMapping("/update/{id:^[0-9]+$}")
    public String updateBook(
            @PathVariable Long id,
            @ModelAttribute("form") BookForm form,
            BindingResult bindingResult,
            Model model
            ){

        if(bindingResult.hasErrors()) {
            model.addAttribute("form",form);
            model.addAttribute("currentBookId",id);
            return "book/update";
        }
        bookService.updateBook(id, form.toEntity());
        return "redirect:/book";
    }

    @GetMapping("/delete/{id:^[0-9]+$}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }

    @GetMapping("/test")
    public String test(Model model) {
        throw new RuntimeException("My message");
    }

}
