package pl.coderslab.interfaces;

import pl.coderslab.beans.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> getBookById(long id);
    void addBook(Book book);
    List<Book> getAllBooks();
    void update(Book book);
    void deleteBook(long id);
}
