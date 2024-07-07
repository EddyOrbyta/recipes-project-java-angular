package it.orbyta.backend_test_cert.controller;

import it.orbyta.backend_test_cert.controller.constants.PasaggioRicettaApiConsts;
import it.orbyta.backend_test_cert.dto.request.PassaggioRicettaForRicettaRequest;
import it.orbyta.backend_test_cert.dto.response.PassaggioRicettaListResponse;
import it.orbyta.backend_test_cert.exceptions.PassaggioForRicettaAlreadyExistsException;
import it.orbyta.backend_test_cert.exceptions.RicettaNotFoundException;
import it.orbyta.backend_test_cert.service.PassaggioRicettaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(PasaggioRicettaApiConsts.BASE_PATH)
public class PassaggioRicettaController {

    private final PassaggioRicettaService passaggioricettaservice;
    @PostMapping(PasaggioRicettaApiConsts.ADD)
    public ResponseEntity<String> addComment(@RequestBody PassaggioRicettaForRicettaRequest request) throws PassaggioForRicettaAlreadyExistsException, RicettaNotFoundException {

        passaggioricettaservice.addComment(request);

        return ResponseEntity.ok("Passaggio added");
    }
    @GetMapping(PasaggioRicettaApiConsts.GET_BY_RICETTA)
    public ResponseEntity<PassaggioRicettaListResponse> addComment(@PathVariable("idRicetta") int idRicetta) throws RicettaNotFoundException {
        return ResponseEntity.ok(passaggioricettaservice.getListByRicetta(idRicetta));
    }
}
