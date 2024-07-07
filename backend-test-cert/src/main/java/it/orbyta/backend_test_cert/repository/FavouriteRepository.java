package it.orbyta.backend_test_cert.repository;

import it.orbyta.backend_test_cert.entity.Favourite;
import it.orbyta.backend_test_cert.entity.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer>{
    List<Favourite> findAllByUserUid(String userUid);

    Favourite findByUserUidAndRicetta(String userUid, Ricetta ricetta);
}
