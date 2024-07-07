package it.orbyta.backend_test_cert.service;

import it.orbyta.backend_test_cert.entity.Favourite;
import it.orbyta.backend_test_cert.entity.Ricetta;
import it.orbyta.backend_test_cert.exceptions.RicettaNotFoundException;
import it.orbyta.backend_test_cert.repository.FavouriteRepository;
import it.orbyta.backend_test_cert.repository.RicettaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FavouriteService {
    private final FavouriteRepository favouriteRepository;
    private final RicettaRepository ricettaRepository;

    public List<Integer> getAllIdsFavourites(String userUid) {
        log.info("Start ricerca di tutti i preferiti per utente {}", userUid);
        List<Favourite> listFavourites = favouriteRepository.findAllByUserUid(userUid);
        log.info("End ricerca di tutti i preferiti per utente {}", userUid);
        return listFavourites.stream().map(Favourite::getId).toList();
    }

    public void addFavourite(Integer ricettaId, String userUid) {
        log.info("Ricetta {} da aggiungere ai preferiti per utente {}", ricettaId, userUid);

        Ricetta ricetta = ricettaRepository.findById(ricettaId).orElseThrow(() -> new RuntimeException("Ricetta not found")); // TODO remove with appropriate exception

        favouriteRepository.save(buildFavourite(ricetta, userUid));

        log.info("Ricetta {} aggiunta ai preferiti per utente {}", ricettaId, userUid);
    }

    private Favourite buildFavourite(Ricetta ricettaOpt, String userUid) {
    return Favourite.builder()
            .userUid(userUid)
            .ricetta(ricettaOpt)
            .build();
    }

    public void removeFavourite(Integer ricettaId, String userUid) throws RicettaNotFoundException {
        log.info("Ricetta {} da rimuovere dai preferiti per utente {}", ricettaId, userUid);

        Ricetta ricetta = ricettaRepository.findById(ricettaId).orElseThrow(() -> new RicettaNotFoundException("Ricetta not found")); // TODO remove with appropriate exception

        Favourite favOpt = favouriteRepository.findByUserUidAndRicetta(userUid, ricetta);

        if (favOpt == null) throw new IllegalArgumentException("Favourite non trovato");

        favouriteRepository.delete(favOpt);
        log.info("Ricetta {} rimossa dai preferiti per utente {}", ricettaId, userUid);
    }
}

