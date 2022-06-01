package com.technical.Assesment.Controller;

import com.technical.Assesment.Interface.MatchOddsRepository;

import com.technical.Assesment.Model.MatchOdds;

import com.technical.Assesment.Errors.MatchNotFoundException;

import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MatchOddsController {

    private final MatchOddsRepository matchOddsRepository;

    MatchOddsController(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    @GetMapping("/matchOdds")
    List<MatchOdds> all() {
        return matchOddsRepository.findAll();
    }

    @PostMapping("/matchOdds")
    MatchOdds newMatch(@RequestBody MatchOdds newMatchOdds) {
        return matchOddsRepository.save(newMatchOdds);
    }

    // Single item

    @GetMapping("/matchOdds/{id}")
    MatchOdds one(@PathVariable Long id) {

        return matchOddsRepository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException(id));
    }

    @PutMapping("/matchOdds/{id}")
    MatchOdds replaceMatch(@RequestBody MatchOdds newMatchOdds, @PathVariable Long id) {

        return matchOddsRepository.findById(id)
                .map(matchOdds -> {
                    matchOdds.setSpecifier(newMatchOdds.getSpecifier());
                    matchOdds.setOdd(newMatchOdds.getOdd());
                    return matchOddsRepository.save(matchOdds);
                })
                .orElseGet(() -> {
                    newMatchOdds.setId(id);
                    return matchOddsRepository.save(newMatchOdds);
                });
    }

    @DeleteMapping("/matchOdds/{id}")
    ResponseEntity<String> deleteMatch(@PathVariable Long id) throws Exception {

        try {

            matchOddsRepository.deleteById(id);
            return new ResponseEntity<>("MatchOdd with id " + id + " deleted successfully!", HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("MatchOdd with id " + id + " not found!", HttpStatus.OK);
        }
    }

}
