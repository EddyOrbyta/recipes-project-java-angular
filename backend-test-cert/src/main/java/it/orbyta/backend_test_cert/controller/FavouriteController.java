package it.orbyta.backend_test_cert.controller;

import it.orbyta.backend_test_cert.controller.constants.FavouriteApiConsts;
import it.orbyta.backend_test_cert.exceptions.RicettaNotFoundException;
import it.orbyta.backend_test_cert.service.FavouriteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(FavouriteApiConsts.BASE_URL)
@Slf4j
@AllArgsConstructor
public class FavouriteController {

    private final FavouriteService favouriteService;
    @GetMapping(FavouriteApiConsts.GET_ALL_FAVORUITES)
    public ResponseEntity<List<Integer>> getAllFavourites(String userUid) {
        List<Integer> favIds = favouriteService.getAllIdsFavourites(userUid);
        return ResponseEntity.ok(favIds);
    }
    @PostMapping(FavouriteApiConsts.ADD_FAVORUITES)
    public ResponseEntity<String> addFavourite(@RequestBody Integer ricettaId, String userUid) {
        favouriteService.addFavourite(ricettaId, userUid);
        return ResponseEntity.ok("Ricetta aggiunta ai preferiti");
    }
    @DeleteMapping(FavouriteApiConsts.REMOVE_FAVORUITES)
    public ResponseEntity<String> removeFavourites(@RequestBody Integer ricettaId, String userUid) throws RicettaNotFoundException {
        favouriteService.removeFavourite(ricettaId, userUid);
        return ResponseEntity.ok("Ricetta rimossa dai preferiti");

    }

}

