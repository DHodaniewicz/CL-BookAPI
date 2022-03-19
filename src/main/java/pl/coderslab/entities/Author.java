package pl.coderslab.entities;

import org.springframework.stereotype.Component;

@Component
public class Author {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String nationality;


    public Author(Integer id, String name, String surname, Integer age, String nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nationality = nationality;
    }

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
