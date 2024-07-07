package it.orbyta.backend_test_cert.controller;

import it.orbyta.backend_test_cert.controller.constants.RicettaApiConsts;
import it.orbyta.backend_test_cert.dto.response.ListRicettaResponse;
import it.orbyta.backend_test_cert.dto.response.ListRicettaResponseWithScore;
import it.orbyta.backend_test_cert.dto.request.RicettaRequest;
import it.orbyta.backend_test_cert.exceptions.IllegalArgumentExceptionForPagination;
import it.orbyta.backend_test_cert.security.serivce.AuthService;
import it.orbyta.backend_test_cert.service.RicettaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(RicettaApiConsts.BASE_URL)
@AllArgsConstructor
public class RicettaController {
    private final RicettaService ricettaService;
    private final AuthService authService;


    @PostMapping(RicettaApiConsts.ADD_RICETTA)
    public ResponseEntity<String> addRicetta(@RequestBody RicettaRequest ricettaReq, @RequestHeader(value = "Authorization") String jwt) {

        String userUid = authService.getUsername(jwt);

        log.info("Start method - addRicetta - ricettaReq: {}, userUid: {}", ricettaReq, userUid);


        ricettaService.addRicetta(ricettaReq, userUid);

        log.info("End method - addRicetta - ricettaReq: {}, userUid: {}", ricettaReq, userUid);
        return ResponseEntity.status(201).body("Ricetta aggiunta correttamente");
    }
    @GetMapping(value = RicettaApiConsts.GET_ALL_RICETTE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListRicettaResponse> getAllRicette(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "20") int size,
                                                                       @RequestParam(defaultValue = "createdAt") String sortBy,
                                                                       @RequestParam(defaultValue = "true") boolean asc,
                                                                       @RequestParam(required = false) String ricettaFilter) throws IllegalArgumentExceptionForPagination {
        String userId = "Giorgione-Admin";

        if (page < 0 && size < 1) {
            throw new IllegalArgumentExceptionForPagination("Invalid page : " + page + " or size " + size);
        } else if (size < 1) {
            throw new IllegalArgumentExceptionForPagination("Invalid size " + size);
        } else if (page < 0) {
            throw new IllegalArgumentExceptionForPagination("Invalid page : " + page);
        }

        log.info("API call received - getAllRicette - for user {}  with params: page={}, size={}, sortBy={}, asc={}", userId, page, size, sortBy, asc);

        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        ListRicettaResponse response = ricettaService.getListRicette(pageable, userId, ricettaFilter);

        return ResponseEntity.ok(response);
    }
    @GetMapping(value = RicettaApiConsts.GET_RICETTE_5_STAR, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListRicettaResponseWithScore> getRicetteBestStar(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "20") int size,
                                                                       @RequestParam(defaultValue = "createdAt") String sortBy,
                                                                       @RequestParam(defaultValue = "true") boolean asc,
                                                                       @RequestParam(required = false) String ricettaFilter) throws IllegalArgumentExceptionForPagination {
        String userId = "Giorgione";

        if (page < 0 && size < 1) {
            throw new IllegalArgumentExceptionForPagination("Invalid page : " + page + " or size " + size);
        } else if (size < 1) {
            throw new IllegalArgumentExceptionForPagination("Invalid size " + size);
        } else if (page < 0) {
            throw new IllegalArgumentExceptionForPagination("Invalid page : " + page);
        }

        log.info("API call received - getRicetteBestStar - for user {}  with params: page={}, size={}, sortBy={}, asc={}", userId, page, size, sortBy, asc);

        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        //TODO aggiungere rating value alle ricette nella lista
        ListRicettaResponseWithScore response = ricettaService.getListRicetteBestRating(pageable, userId, ricettaFilter);

        return ResponseEntity.ok(response);
    }
    @GetMapping(value = RicettaApiConsts.GET_RICETTE_EASY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListRicettaResponse> getListRicetteMostEasy(@RequestParam(defaultValue = "0") int page,
                                                                           @RequestParam(defaultValue = "20") int size,
                                                                           @RequestParam(defaultValue = "createdAt") String sortBy,
                                                                           @RequestParam(defaultValue = "true") boolean asc,
                                                                           @RequestParam(required = false) String ricettaFilter, String userId) throws IllegalArgumentExceptionForPagination {
        userId = "Giorgione";

        if (page < 0 && size < 1) {
            throw new IllegalArgumentExceptionForPagination("Invalid page : " + page + " or size " + size);
        } else if (size < 1) {
            throw new IllegalArgumentExceptionForPagination("Invalid size " + size);
        } else if (page < 0) {
            throw new IllegalArgumentExceptionForPagination("Invalid page : " + page);
        }

        log.info("API call received - getListRicetteMostEasy - for user {}  with params: page={}, size={}, sortBy={}, asc={}", userId, page, size, sortBy, asc);

        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        //TODO aggiungere rating value alle ricette nella lista
        ListRicettaResponse response = ricettaService.getListRicetteMostEasy(pageable, userId, ricettaFilter);

        return ResponseEntity.ok(response);
    }
    //TODO: implementare
}
