package it.orbyta.backend_test_cert.repository;

import it.orbyta.backend_test_cert.entity.Rating;
import it.orbyta.backend_test_cert.entity.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findAllByRicetta(Ricetta ricetta);

    List<Rating> findAllByUserUid(String userUid);

}
