package pl.coderslab.interfaces;

import pl.coderslab.beans.Book;

import java.util.Optional;

public interface BookInterface {
    Optional<Book> getBookById(long id);
}
