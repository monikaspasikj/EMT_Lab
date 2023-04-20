package mk.ukim.finki.labemt.web;


import mk.ukim.finki.labemt.model.Country;
import mk.ukim.finki.labemt.model.dto.CountryDto;
import mk.ukim.finki.labemt.service.CoutryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
@RequestMapping("/api/countries")
public class CoutryRestController {
    private final CoutryService coutryService;

    public CoutryRestController(CoutryService coutryService) {
        this.coutryService = coutryService;
    }
    @GetMapping("/list")
    public List<Country> findAll(){
        return coutryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return this.coutryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody CountryDto countryDto){
        return this.coutryService.save(countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Country> edit(@PathVariable Long id,@RequestBody CountryDto countryDto){
        return this.coutryService.edit(id, countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> delete(@PathVariable Long id){
        this.coutryService.deleteById(id);
        if(this.coutryService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}

