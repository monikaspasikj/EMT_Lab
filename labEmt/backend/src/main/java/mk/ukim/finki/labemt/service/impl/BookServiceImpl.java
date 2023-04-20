package mk.ukim.finki.labemt.service.impl;


import mk.ukim.finki.labemt.model.Author;
import mk.ukim.finki.labemt.model.Book;
import mk.ukim.finki.labemt.model.dto.BookDto;
import mk.ukim.finki.labemt.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.labemt.model.exceptions.BookNotFoundException;
import mk.ukim.finki.labemt.repository.AuthorRepository;
import mk.ukim.finki.labemt.repository.BookRepository;
import mk.ukim.finki.labemt.service.BookService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findAllBooksByPage(Pageable pageable) {
        return this.bookRepository.findAll((Sort) pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author=authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(()->new AuthorNotFoundException(bookDto.getAuthor()));
        this.bookRepository.deleteByName(bookDto.getName());
        Book book=new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=this.bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        Author author=authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(()->new AuthorNotFoundException(bookDto.getAuthor()));
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void markBookAsTaken(Long id) {
        Book book=this.bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        if (book==null){
            return;
        }
        book.setAvailableCopies(book.getAvailableCopies()-1);
        this.bookRepository.save(book);
    }
}
