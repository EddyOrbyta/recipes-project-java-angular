package it.orbyta.backend_test_cert.service;

import it.orbyta.backend_test_cert.dto.request.RatingRequest;
import it.orbyta.backend_test_cert.entity.Rating;
import it.orbyta.backend_test_cert.entity.Ricetta;
import it.orbyta.backend_test_cert.repository.RatingRepository;
import it.orbyta.backend_test_cert.repository.RicettaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final RicettaRepository ricettaRepository;

    public List<Rating> getRatingsByRicetta(Integer idRicetta) {
        Ricetta ricetta = ricettaRepository.findById(idRicetta).orElseThrow(() -> new RuntimeException("Ricetta not found"));
        return ratingRepository.findAllByRicetta(ricetta);
    }
    public static double getAvgRating(List<Rating> ratingListOfRicetta) {
        return ratingListOfRicetta.stream().mapToDouble(Rating::getScore).average().orElse(0.0);
    }
    public List<Rating> getRatingsByUser(String userUid) {
        return ratingRepository.findAllByUserUid(userUid);
    }

    public void addRating(RatingRequest rating, String userUid) {
        Rating newRating = new Rating();
        newRating.setUserUid(userUid);
        newRating.setScore(rating.getScore());
        newRating.setRicetta(
                ricettaRepository.findById(rating.getIdRicetta())
                        .orElseThrow(() -> new RuntimeException("Ricetta not found"))
        );
        ratingRepository.save(newRating);
    }

    public int modifyRating(int idRating, RatingRequest rating, String userUid) {
        Rating oldRating = ratingRepository.findById(idRating)
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        oldRating.setScore(rating.getScore());

        ratingRepository.save(oldRating);
        return rating.getScore();
    }

    public void deleteRating(int idRating) {
        ratingRepository.deleteById(idRating);
    }
}
