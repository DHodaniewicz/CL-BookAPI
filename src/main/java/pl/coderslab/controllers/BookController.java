package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
    public Book getBookById(@PathVariable long bookId) {
        return this.mockBookService.getBookById(bookId).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void  addBook(@RequestParam String isbn, @RequestParam  String title, @RequestParam String publisher,
                         @RequestParam String type, @RequestParam String author) {
        mockBookService.addBook(isbn, title, publisher, type, author);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void editBook(@RequestParam int id, @RequestParam String isbn, @RequestParam  String title, @RequestParam String publisher,
                         @RequestParam String type, @RequestParam String author) {
        mockBookService.editBook(id, isbn, title, publisher, type, author);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable long bookId) {
        mockBookService.deleteBook(bookId);
    }


}
