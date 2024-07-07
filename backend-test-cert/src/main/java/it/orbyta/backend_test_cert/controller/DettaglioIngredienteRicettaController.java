package it.orbyta.backend_test_cert.controller;

import it.orbyta.backend_test_cert.controller.constants.DettaglioIngredienteRicettaApiConsts;
import it.orbyta.backend_test_cert.dto.request.DettaglioIngredienteRicettaRequest;
import it.orbyta.backend_test_cert.dto.response.IngredientiRicettaResponse;
import it.orbyta.backend_test_cert.exceptions.IngredienteNotFoundException;
import it.orbyta.backend_test_cert.exceptions.RicettaNotFoundException;
import it.orbyta.backend_test_cert.service.DettaglioIngredienteRicettaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(DettaglioIngredienteRicettaApiConsts.BASE_URL)
@AllArgsConstructor
@RestController
public class DettaglioIngredienteRicettaController {

    private final DettaglioIngredienteRicettaService dettaglioIngredienteRicettaService;

    @PostMapping(DettaglioIngredienteRicettaApiConsts.ADD_INGREDIENTE_TO_RICETTA)
    public ResponseEntity<String> addDettaglioIngredienteRicetta(DettaglioIngredienteRicettaRequest dettaglioIngredienteRicettaReq) throws IngredienteNotFoundException, RicettaNotFoundException {
        dettaglioIngredienteRicettaService.addDettaglioIngredienteRicetta(dettaglioIngredienteRicettaReq);
        return ResponseEntity.status(201).body("Ingrediente aggiunto correttamente");
    }

    @DeleteMapping(DettaglioIngredienteRicettaApiConsts.REMOVE_INGREDIENTE_FROM_RICETTA)
    public ResponseEntity<String> removeDettaglioIngredienteRicetta(@PathVariable("idRicetta") int idRicetta, @PathVariable("idIngrediente") int idIngrediente) throws IngredienteNotFoundException, RicettaNotFoundException {
        dettaglioIngredienteRicettaService.removeDettaglioIngredienteRicetta(idRicetta, idIngrediente);
        return ResponseEntity.status(201).body("Ingrediente rimosso correttamente");
    }
    @GetMapping(DettaglioIngredienteRicettaApiConsts.GET_ALL_INGREDIENTI_OF_RICETTA)
    public ResponseEntity<IngredientiRicettaResponse> getAllIngredientiOfRicetta(@PathVariable("idRicetta") int idRicetta) throws RicettaNotFoundException {
        return ResponseEntity.ok(dettaglioIngredienteRicettaService.getAllIngredientiOfRicetta(idRicetta));
    }

    @PutMapping(DettaglioIngredienteRicettaApiConsts.MODIFY_INGREDIENTI_OF_RICETTA)
    public ResponseEntity<String> modifyIngredientiOfRicetta(@RequestBody DettaglioIngredienteRicettaRequest dettaglioIngredienteRicettaReq, @PathVariable("idRicetta") int idRicetta) throws IngredienteNotFoundException, RicettaNotFoundException {
        dettaglioIngredienteRicettaService.modifyIngredientiOfRicetta(dettaglioIngredienteRicettaReq, idRicetta);
        return ResponseEntity.status(201).body("Ingrediente modificati correttamente");
    }
}
