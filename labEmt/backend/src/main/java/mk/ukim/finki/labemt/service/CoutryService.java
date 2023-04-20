package mk.ukim.finki.labemt.service;


import mk.ukim.finki.labemt.model.Country;
import mk.ukim.finki.labemt.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CoutryService {
    Optional<Country> findById(Long id);
    List<Country> findAll();
    Optional<Country> save(CountryDto countryDto);
    Optional<Country> edit(Long id, CountryDto countryDto);
    void deleteById(Long id);
}
