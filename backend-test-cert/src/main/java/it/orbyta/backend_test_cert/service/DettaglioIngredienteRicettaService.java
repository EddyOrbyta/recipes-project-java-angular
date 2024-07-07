package it.orbyta.backend_test_cert.service;

import it.orbyta.backend_test_cert.dto.request.DettaglioIngredienteRicettaRequest;
import it.orbyta.backend_test_cert.dto.response.IngredientiRicettaResponse;
import it.orbyta.backend_test_cert.entity.DettaglioIngredienteRicetta;
import it.orbyta.backend_test_cert.entity.Ingrediente;
import it.orbyta.backend_test_cert.entity.Ricetta;
import it.orbyta.backend_test_cert.exceptions.IngredienteNotFoundException;
import it.orbyta.backend_test_cert.exceptions.RicettaNotFoundException;
import it.orbyta.backend_test_cert.repository.DettaglioIngredienteRicettaRepository;
import it.orbyta.backend_test_cert.repository.IngredienteRepository;
import it.orbyta.backend_test_cert.repository.RicettaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DettaglioIngredienteRicettaService {

    private final DettaglioIngredienteRicettaRepository dettaglioIngredienteRicettaRepository;
    private final IngredienteRepository ingredienteRepository;
    private final RicettaRepository ricettaRepository;
    public void removeDettaglioIngredienteRicetta(int idRicetta, int idIngrediente) throws RicettaNotFoundException, IngredienteNotFoundException {

        log.info("Start method - removeDettaglioIngredienteRicetta - idRicetta: {} - idIngrediente: {}", idRicetta, idIngrediente);
        Ricetta ricetta = ricettaRepository.findById(idRicetta).orElseThrow(() -> new RicettaNotFoundException("Ricetta not found")); // TODO remove with appropriate exception
        Ingrediente ingrediente = ingredienteRepository.findById(idIngrediente).orElseThrow(() -> new IngredienteNotFoundException("Ingrediente not found"));

        DettaglioIngredienteRicetta dettaglioIngrRicett = dettaglioIngredienteRicettaRepository
                .findByRicettaAndIngrediente(ricetta, ingrediente);

        dettaglioIngredienteRicettaRepository.delete(dettaglioIngrRicett);

        log.info("End method - removeDettaglioIngredienteRicetta - idRicetta: {} - idIngrediente: {}", idRicetta, idIngrediente);
    }

    public void addDettaglioIngredienteRicetta(DettaglioIngredienteRicettaRequest dettaglioIngredienteRicettaReq) throws RicettaNotFoundException, IngredienteNotFoundException {

        log.info("Start method - addDettaglioIngredienteRicetta - dettaglioIngredienteRicetta: {}", dettaglioIngredienteRicettaReq);

        Ricetta ricetta = ricettaRepository.findById(dettaglioIngredienteRicettaReq.getIdRicetta()).orElseThrow(() -> new RicettaNotFoundException("Ricetta not found")); // TODO remove with appropriate exception
        Ingrediente ingrediente = ingredienteRepository.findById(dettaglioIngredienteRicettaReq.getIdIngrediente()).orElseThrow(() -> new IngredienteNotFoundException("Ingrediente not found"));

        dettaglioIngredienteRicettaRepository.save(populateDettaglioIngredienteRicetta(dettaglioIngredienteRicettaReq, ricetta, ingrediente));

        log.info("End method - addDettaglioIngredienteRicetta - dettaglioIngredienteRicetta: {}", dettaglioIngredienteRicettaReq);

    }

    private DettaglioIngredienteRicetta populateDettaglioIngredienteRicetta(DettaglioIngredienteRicettaRequest dettaglioIngredienteRicettaReq, Ricetta ricetta, Ingrediente ingrediente) {
        return DettaglioIngredienteRicetta.builder()
                .ricetta(ricetta)
                .ingrediente(ingrediente)
                .quantita(dettaglioIngredienteRicettaReq.getQuantita())
                .build();
    }

    public IngredientiRicettaResponse getAllIngredientiOfRicetta(int idRicetta) throws RicettaNotFoundException {

        log.info("Start method - getAllIngredientiOfRicetta - idRicetta: {}", idRicetta);

        Ricetta ricetta = ricettaRepository.findById(idRicetta).orElseThrow(() -> new RicettaNotFoundException("Ricetta not found")); // TODO remove with appropriate exception

        List<DettaglioIngredienteRicetta> dettaglioIngredienteRicettaList = dettaglioIngredienteRicettaRepository
                .findAllByRicetta(ricetta);

        IngredientiRicettaResponse response = new IngredientiRicettaResponse();
        response.setIdRicetta(ricetta.getId());
        response.setIngredienti(dettaglioIngredienteRicettaList.stream().map(DettaglioIngredienteRicetta::getIngrediente).toList());

        log.info("End method - getAllIngredientiOfRicetta - idRicetta: {}", idRicetta);

        return response;
    }


    public void modifyIngredientiOfRicetta(DettaglioIngredienteRicettaRequest dettaglioIngredienteRicettaReq, int idRicetta) throws RicettaNotFoundException, IngredienteNotFoundException {
        log.info("Start method - modifyIngredientiOfRicetta - dettaglioIngredienteRicetta: {}", dettaglioIngredienteRicettaReq);

        Ricetta ricetta = ricettaRepository.findById(idRicetta).orElseThrow(() -> new RicettaNotFoundException("Ricetta not found")); // TODO remove with appropriate exception
        Ingrediente ingrediente = ingredienteRepository.findById(dettaglioIngredienteRicettaReq.getIdIngrediente()).orElseThrow(() -> new IngredienteNotFoundException("Ingrediente not found"));

        DettaglioIngredienteRicetta dettaglioIngredienteRicetta = dettaglioIngredienteRicettaRepository
                .findByRicettaAndIngrediente(ricetta, ingrediente);

        dettaglioIngredienteRicetta.setQuantita(dettaglioIngredienteRicettaReq.getQuantita());
        dettaglioIngredienteRicetta.setUntiaDiMisura(dettaglioIngredienteRicettaReq.getUnitaDiMisura());

        dettaglioIngredienteRicettaRepository.save(dettaglioIngredienteRicetta);

        log.info("End method - modifyIngredientiOfRicetta - dettaglioIngredienteRicetta: {}", dettaglioIngredienteRicettaReq);
    }
}
