package it.orbyta.backend_test_cert.repository;

import it.orbyta.backend_test_cert.entity.PassaggioRicetta;
import it.orbyta.backend_test_cert.entity.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassaggioRicettaRepository extends JpaRepository<PassaggioRicetta, Integer> {
        List<PassaggioRicetta> findByRicetta (Ricetta ricetta);
}
