package mk.ukim.finki.labemt.service.impl;


import mk.ukim.finki.labemt.model.Country;
import mk.ukim.finki.labemt.model.dto.CountryDto;
import mk.ukim.finki.labemt.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.labemt.repository.CountryRepository;
import mk.ukim.finki.labemt.service.CoutryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CoutryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        return Optional.of(this.countryRepository.save(new Country(countryDto.getName(), countryDto.getContinent())));
    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {
        Country country=this.countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException(id));
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
