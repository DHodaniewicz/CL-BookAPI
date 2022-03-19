package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Book;
import pl.coderslab.interfaces.BookService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class BookControllerMvc {
    private final BookService bookService;

    @Autowired
    public BookControllerMvc(@Qualifier("jpaBookService") BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String addBookView(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "books/add";
        }
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String editBookView(Model model, @PathVariable long id) {
        Optional bookOptional = bookService.getBookById(id);
        if (bookOptional.isEmpty()) {
            model.addAttribute("book", new Book());
        }
        model.addAttribute("book", bookOptional.get());
        return "books/update";
    }

    @PostMapping("/edit")
    public String editBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()){
            return "books/update";
        }
        bookService.update(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books/all";
    }


    @ModelAttribute
    public void availableCategories(Model model) {
        List<String> availableCategories = Arrays.asList("History","Sport","Thriller","Sci-fi","Programming");
        model.addAttribute("availableCategories", availableCategories);
    }


}
