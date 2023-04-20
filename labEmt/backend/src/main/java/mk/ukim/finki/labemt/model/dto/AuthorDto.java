package mk.ukim.finki.labemt.model.dto;

import lombok.Data;
import mk.ukim.finki.labemt.model.Country;

@Data
public class AuthorDto {
    private String name;
    private String surname;
    private Country country;
}
