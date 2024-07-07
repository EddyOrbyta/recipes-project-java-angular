package it.orbyta.backend_test_cert.controller;

import it.orbyta.backend_test_cert.controller.constants.IngredienteApiConsts;
import it.orbyta.backend_test_cert.dto.request.IngredienteDto;
import it.orbyta.backend_test_cert.dto.request.IngredienteRequest;
import it.orbyta.backend_test_cert.exceptions.IngredienteNotFoundException;
import it.orbyta.backend_test_cert.service.IngredienteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IngredienteApiConsts.BASE_URL)
@AllArgsConstructor
@Slf4j
public class IngredienteController {

    private final IngredienteService ingredienteService;
    @PostMapping(IngredienteApiConsts.ADD_INGREDIENTE)
    public ResponseEntity<String> addIngrediente(@RequestBody IngredienteRequest ingredienteRequest) {

        boolean esitoDellAggiunta = ingredienteService.addIngrediente(ingredienteRequest);

        //int statusValude = esitoDellAggiunta == null ? HttpStatus.CREATED.value() : HttpStatus.BAD_REQUEST.value();

        String esito = !esitoDellAggiunta ? "Ingredienti aggiuni correttamente" : "Non tutti gli " +
                "ingredienti sono stati aggiunti";
        return ResponseEntity.status(HttpStatus.CREATED).body(esito);
    }

    @DeleteMapping(IngredienteApiConsts.DELETE_INGREDIENTE)
    public ResponseEntity<String> deleteIngrediente(@PathVariable("id") int id) {
        boolean esitoDellAggiunta = ingredienteService.deleteIngrediente(id);

        String esito = !esitoDellAggiunta ? "Ingrediente eliminato correttamente" : "Ingrediente non eliminato correttamente";
        return ResponseEntity.status(HttpStatus.OK).body("Ingrediente eliminato correttamente");
    }
    @PutMapping(IngredienteApiConsts.UPDATE_INGREDIENTE)
    public ResponseEntity<String> updateIngrediente(@PathVariable("id") Integer id, @RequestBody IngredienteDto ingredienteToUpdate) throws IngredienteNotFoundException {
        ingredienteService.updateIngrediente(id, ingredienteToUpdate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ingrediente aggiornato correttamente");
    }

    @GetMapping(IngredienteApiConsts.GET_ALL_INGREDIENTI)
    public ResponseEntity<IngredienteDto> getAllIngrediente() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
