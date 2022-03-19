package pl.coderslab.services;

import org.springframework.stereotype.Component;
import pl.coderslab.beans.Book;
import pl.coderslab.interfaces.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService {
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

    @Override
    public List<Book> getAllBooks() {
        return this.list;
    }

    @Override
    public Optional<Book> getBookById(long id) {
        return list.stream().
                filter(book -> book.getId().equals(id)).
                findFirst();
    }

    @Override
    public void addBook(Book book) {
            book.setId(nextId++);
            list.add(book);

    }
    @Override
    public void update(Book book) {
        if (this.getBookById(book.getId()).isPresent()) {
            int indexOf = list.indexOf(this.getBookById(book.getId()).get());
            list.set(indexOf, book);
        }
    }


    @Override
    public void deleteBook(long id) {
        if (getBookById(id).isPresent()) {
            Book book = getBookById(id).get();
            int index = list.indexOf(book);
            list.remove(index);
        }
    }
}
