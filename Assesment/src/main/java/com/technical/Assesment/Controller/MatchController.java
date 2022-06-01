package com.technical.Assesment.Controller;

import com.technical.Assesment.Interface.MatchRepository;
import com.technical.Assesment.Model.Match;
import com.technical.Assesment.Errors.MatchNotFoundException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MatchController {

    private final MatchRepository matchRepository;

    MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping("/matches")
    List<Match> all() {
        return matchRepository.findAll();
    }

    @PostMapping("/matches")
    Match newMatch(@RequestBody Match newMatch) {
        return matchRepository.save(newMatch);
    }

    // Single item

    @GetMapping("/matches/{id}")
    Match one(@PathVariable Long id) {

        return matchRepository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException(id));
    }

    @PutMapping("/matches/{id}")
    Match replaceMatch(@RequestBody Match newMatch, @PathVariable Long id) {

        return matchRepository.findById(id)
                .map(match -> {
                    match.setDescription(newMatch.getDescription());
                    match.setMatch_date(newMatch.getMatch_date());
                    match.setMatch_time(newMatch.getMatch_time());
                    match.setTeam_a(newMatch.getTeam_a());
                    match.setTeam_b(newMatch.getTeam_b());
                    match.setSport(newMatch.getSport());
                    return matchRepository.save(match);
                })
                .orElseGet(() -> {
                    newMatch.setId(id);
                    return matchRepository.save(newMatch);
                });
    }

    @DeleteMapping("/matches/{id}")
    ResponseEntity<String> deleteMatch(@PathVariable Long id) throws Exception {
        try {

            matchRepository.deleteById(id);
            return new ResponseEntity<>("Match with id " + id + " deleted successfully!", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {

            return new ResponseEntity<>("Match with id " + id + " not found!", HttpStatus.OK);
        }

    }
}
