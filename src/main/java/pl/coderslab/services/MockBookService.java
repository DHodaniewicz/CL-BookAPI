package pl.coderslab.services;

import org.springframework.stereotype.Component;
import pl.coderslab.beans.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MockBookService {
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

    public Book getBookById(long id) {
        for (Book book : list) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(String isbn, String title, String publisher, String type, String author) {
            Book book = new Book(nextId, isbn, title, author, publisher, type);
            list.add(book);
            nextId++;
    }

    public void editBook(int id) {

    }

    public void deleteBook(int id) {

    }
}
