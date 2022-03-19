package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entities.Book;
import pl.coderslab.interfaces.BookService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

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

    @ModelAttribute
    public void availableCategories(Model model) {
        List<String> availableCategories = Arrays.asList("History","Sport","Thriller","Sci-fi","Programming");
        model.addAttribute("availableCategories", availableCategories);
    }


}
