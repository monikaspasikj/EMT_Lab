package mk.ukim.finki.labemt.model.dto;


import lombok.Data;
import mk.ukim.finki.labemt.model.Author;
import mk.ukim.finki.labemt.model.enumerations.Category;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long author;
    private Integer availableCopies;
}