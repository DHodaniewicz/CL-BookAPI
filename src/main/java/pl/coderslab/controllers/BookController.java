package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.beans.Book;
import pl.coderslab.services.MockBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/books")
public class BookController {
    private MockBookService mockBookService;

    @Autowired
    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("/all")
    public List<Book> allBooks() {
        return mockBookService.getAllBooks();
    }

    @RequestMapping("/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        return mockBookService.getBookById(bookId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void  addBook(@RequestParam String isbn, @RequestParam  String title, @RequestParam String publisher,
                         @RequestParam String type, @RequestParam String author) {
        mockBookService.addBook(isbn, title, publisher, type, author);
    }
}
