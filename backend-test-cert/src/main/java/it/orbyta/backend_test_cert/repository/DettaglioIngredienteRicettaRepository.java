package it.orbyta.backend_test_cert.repository;

import it.orbyta.backend_test_cert.entity.DettaglioIngredienteRicetta;
import it.orbyta.backend_test_cert.entity.Ingrediente;
import it.orbyta.backend_test_cert.entity.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DettaglioIngredienteRicettaRepository extends JpaRepository<DettaglioIngredienteRicetta, Integer> {
    DettaglioIngredienteRicetta findByRicettaAndIngrediente(Ricetta ricetta, Ingrediente ingrediente);

    List<DettaglioIngredienteRicetta> findAllByRicetta(Ricetta ricetta);
}
