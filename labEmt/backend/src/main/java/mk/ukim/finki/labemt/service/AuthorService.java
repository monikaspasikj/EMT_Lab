package mk.ukim.finki.labemt.service;



import mk.ukim.finki.labemt.model.Author;
import mk.ukim.finki.labemt.model.Country;
import mk.ukim.finki.labemt.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);

    List<Author> findAll();

    Optional<Author> save(String name, String surname, Country country);
    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> edit(Long id, AuthorDto authorDto);
    void deleteById(Long id);
}
