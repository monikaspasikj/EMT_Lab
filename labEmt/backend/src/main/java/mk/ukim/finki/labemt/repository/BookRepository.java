package mk.ukim.finki.labemt.repository;


import mk.ukim.finki.labemt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteByName(String name);
    void deleteById(Long id);
}
