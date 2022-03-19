package pl.coderslab.services;

import org.springframework.stereotype.Component;
import pl.coderslab.entities.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MocAuthorService {
    private List<Author> authors;
    private static Integer nextId = 5;

    public MocAuthorService() {
        authors = new ArrayList<>();
        authors.add(new Author(1,"Vasilij", "Machanienko", 46, "RU"));
        authors.add(new Author(2, "Jane", "Rowling", 52, "UK"));
        authors.add(new Author(3,"Andrzej", "Sapkowski", 61, "PL"));
        authors.add(new Author(4, "J.R.R", "Tolkien", 75, "UK"));
    }


    public List<Author> getAllAuthors() {
        return this.authors;
    }

    public Optional<Author> getAuthorById(int id) {
        Optional authorO = authors.stream().filter(author -> author.getId() == id).findFirst();
        return authorO;
    }


}
