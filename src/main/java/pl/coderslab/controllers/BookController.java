package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.entities.Book;
import pl.coderslab.interfaces.BookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(@Qualifier("mockBookService") BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("/all")
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping("/{bookId}")
    public Book getBookById(@PathVariable long bookId) {
        return this.bookService.getBookById(bookId).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void  addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void editBook(Book book) {
        bookService.update(book);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable long bookId) {
        bookService.deleteBook(bookId);
    }


}
