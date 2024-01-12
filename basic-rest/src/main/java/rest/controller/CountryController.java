//: rest.controller.CountryController.java


package rest.controller;


import com.google.common.collect.ImmutableList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.domain.model.Country;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/countries")
class CountryController {

    static final Map<String, Country> POPULATION = Map.of(
            "france", Country.of("france", 65),
            "india", Country.of("india", 1428),
            "canada", Country.of("canada", 39),
            "china", Country.of("china", 1426),
            "usa", Country.of("usa", 340));

    @GetMapping("/{name}")
    ResponseEntity<Country> country(@PathVariable("name") String name) {

        Country country = POPULATION.get(name.toLowerCase());
        country = country == null ? Country.of("unknown", -1) : country;

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("example-code", "sq-ch10-ex4")
                .body(country);
    }

    @GetMapping
    List<Country> allCountries() {
        return ImmutableList.copyOf(POPULATION.values());
    }

}///:~