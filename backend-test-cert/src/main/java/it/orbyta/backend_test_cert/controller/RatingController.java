package it.orbyta.backend_test_cert.controller;

import it.orbyta.backend_test_cert.controller.constants.RatingApiConsts;
import it.orbyta.backend_test_cert.dto.request.RatingRequest;
import it.orbyta.backend_test_cert.entity.Rating;
import it.orbyta.backend_test_cert.service.RatingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(RatingApiConsts.BASE_PATH)
@AllArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @RequestMapping(RatingApiConsts.GET_BY_RICETTA)
    public ResponseEntity<List<Rating>> getRatingsByRicetta(@PathVariable("idRicetta") Integer idRicetta) {
        log.info("Getting ratings of ricetta {}", idRicetta);
        List<Rating> ratings = ratingService.getRatingsByRicetta(idRicetta);
        log.info("Got {} ratings for ricetta {}", ratings.size(), idRicetta);
        return ResponseEntity.ok(ratings);
    }

    @RequestMapping(RatingApiConsts.GET_BY_USER)
    public ResponseEntity<List<Rating>> getRatingsByUser(String userUid) {
        log.info("Getting ratings of user {}", userUid);
        List<Rating> ratings = ratingService.getRatingsByUser(userUid);
        log.info("Got {} ratings of users {}", ratings.size(), userUid);
        return ResponseEntity.ok(ratings);
    }

    @RequestMapping(RatingApiConsts.ADD)
    public ResponseEntity<String> addRating(@RequestBody RatingRequest rating, String userUid) {
        log.info("Adding rating of user {} with score {}", userUid, rating.getScore());
        ratingService.addRating(rating, userUid);
        log.info("Rating added");
        return ResponseEntity.ok("Rating aggiunto");
    }

    @RequestMapping(RatingApiConsts.MODIFY)
    public ResponseEntity<Integer> modifyRating(@RequestBody RatingRequest rating, @RequestParam int idRating, String userUid) {
        log.info("Changing rating of user {} with id {} to {}", userUid, idRating, rating.getScore());
        int newRatingValue = ratingService.modifyRating(idRating, rating, userUid);
        log.info("Rating changed to value: {}", newRatingValue);
        return ResponseEntity.ok(newRatingValue);
    }

    @RequestMapping(RatingApiConsts.DELETE)
    public ResponseEntity<String> deleteRating(@RequestParam("idRating") int idRating, String userUid) {
        log.info("Deleting rating of user {} with id {}", userUid, idRating);
        ratingService.deleteRating(idRating);
        log.info("Rating with id {} deleted ", idRating);
        return ResponseEntity.ok("Rating eliminato");
    }

}
