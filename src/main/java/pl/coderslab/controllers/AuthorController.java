package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.entities.Author;
import pl.coderslab.services.MocAuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    MocAuthorService mocAuthorService;

    @Autowired
    public AuthorController(MocAuthorService mocAuthorService) {
        this.mocAuthorService = mocAuthorService;
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return mocAuthorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return mocAuthorService.getAuthorById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
    }




}
