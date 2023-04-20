package mk.ukim.finki.labemt.service;



import mk.ukim.finki.labemt.model.Book;
import mk.ukim.finki.labemt.model.dto.BookDto;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    List<Book> findAllBooksByPage(Pageable pageable);

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);
    void markBookAsTaken(Long id);
}

