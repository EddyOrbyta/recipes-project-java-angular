package it.orbyta.backend_test_cert.repository;

import it.orbyta.backend_test_cert.entity.Ricetta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RicettaRepository extends JpaRepository<Ricetta, Integer> {
    @Query("SELECT r FROM Ricetta r WHERE r.userUid = :userId ORDER BY r.visualizzazioni DESC")
    Page<Ricetta> findByUserUid(String userId, Pageable pageable);

    //TODO aggiungere rating value alle ricette nella lista
    @Query("SELECT rt.ricetta, AVG(rt.score) " +
            "FROM Rating rt " +
            "WHERE rt.ricetta.userUid = :userId " +
            "GROUP BY rt.ricetta " +
            "HAVING AVG(rt.score) >= 4 " +
            "ORDER BY AVG(rt.score) DESC, rt.ricetta.visualizzazioni DESC")
    Page<Object> findRicetteWithHighAvgScoreByUser(String userId, Pageable pageable);

    @Query("SELECT r FROM Ricetta r WHERE r.userUid = :userId AND (r.difficolta = 0 or r.difficolta = 1) AND r.tempoPreparazione <= 30  ORDER BY r.tempoPreparazione ASC")
    Page<Ricetta> findRicetteEasyByUser(String userId, Pageable pageable);
}
