package mk.ukim.finki.labemt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id){
        super(String.format("Book with this id: %d is not found", id));
    }
}
