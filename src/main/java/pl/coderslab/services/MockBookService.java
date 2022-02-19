package pl.coderslab.services;

import org.springframework.stereotype.Component;
import pl.coderslab.beans.Book;
import pl.coderslab.interfaces.BookInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MockBookService implements BookInterface {
    private List<Book> list;
    private static Long nextId = 5L;


    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay	Horstmann, Gary Cornell", "Helion",
                "programming"));
        list.add(new Book(4L, "9788349531742", "Droga Szamana. Etap 7: Na tropie stwórcy", "Wasilij Machanienko",
                "Insignis", "fantasy"));

    }

    public List<Book> getAllBooks() {
        return this.list;
    }

    @Override
    public Optional<Book> getBookById(long id) {
        return list.stream().
                filter(book -> book.getId().equals(id)).
                findFirst();
    }

    public void addBook(String isbn, String title, String publisher, String type, String author) {
            Book book = new Book(nextId, isbn, title, author, publisher, type);
            list.add(book);
            nextId++;
    }

    public void editBook(long id, String isbn, String title, String publisher, String type, String author) {

        if (getBookById(id).isPresent()) {
            Book book = getBookById(id).get();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setPublisher(publisher);
            book.setType(type);
            book.setAuthor(author);
        }
    }

    public void deleteBook(long id) {
        if (getBookById(id).isPresent()) {
            Book book = getBookById(id).get();
            int index = list.indexOf(book);
            list.remove(index);
        }
    }
}
